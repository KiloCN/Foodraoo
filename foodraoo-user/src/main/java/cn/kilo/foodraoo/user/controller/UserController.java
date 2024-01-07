package cn.kilo.foodraoo.user.controller;

import cn.kilo.foodraoo.common.Result;
import cn.kilo.foodraoo.feign.pojo.User;
import cn.kilo.foodraoo.user.service.UserService;
import cn.kilo.foodraoo.common.utils.ValidateCodeUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * The UserController class is responsible for handling HTTP requests related to User.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * Send SMS verification code
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public Result<String> sendMsg(@RequestBody User user, HttpSession session){
        String phone = user.getPhone();

        if(StringUtils.isNotEmpty(phone)){
            //        Anti-brushing of SMS interface
            String redisCode = (String) redisTemplate.opsForValue().get(phone);
            if(redisCode != null){
//                log.info(redisCode);
                long l = Long.parseLong(redisCode.split("_")[1]);
                if(System.currentTimeMillis() - l < 60000){
                    return Result.error("This number has been sent a verification code within one minute. Please try again later.");
                }
            }


            //Generate random 4-bit CAPTCHA
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("The SMS verification code is "+code+" which phone number is "+phone);

            //save SMS verification code to session
//            session.setAttribute(phone,code);

            //save SMS verification code to redis
            redisTemplate.opsForValue().set(phone, code + "_" + System.currentTimeMillis(), 5, TimeUnit.MINUTES);


            return Result.success("The SMS verification code of mobile phone was sent successfully.");
        }

        return Result.error("Failed to send SMS message");
    }

    /**
     * Handle the user login request.
     * If the user verification code is correct, the login is successful.
     * The user who successfully logged in will register automatically if he or she has not registered.
     *
     * @param map
     * @param session
     * @return
     */
    @PostMapping("/login")
    public Result<User> login(@RequestBody Map map, HttpSession session, HttpServletResponse servletResponse){

        String phone = map.get("phone").toString();

        String code = map.get("code").toString();

        //get SMS verification code from session
//        Object codeInSession = session.getAttribute(phone);

        //get SMS verification code from redis
        String redisValue = (String) redisTemplate.opsForValue().get(phone);
        if(redisValue == null){
            return Result.error("The verification code has expired, please resend it");
        }
        String redisCode = redisValue.split("_")[0];

        if(redisCode != null && redisCode.equals(code)){

            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);

            User user = userService.getOne(queryWrapper);
            if(user == null){
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                //default name
                user.setName("Kevin Kimi");
                userService.save(user);
            }

//            log.info("login success userId:{ "+user.getId() + " }");
            session.setAttribute("user",user.getId());
//            log.info("check session: "+session.getAttribute("user"));


            redisTemplate.delete(phone);
            return Result.success(user);
        }
        return Result.error("Login fail!");
    }


    /**
     * Logout the currently logged-in user account.
     *
     * @param request the HTTP servlet request object.
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return Result.success("Logout successfully");
    }


    /**
     * Get the user information by user id.
     *
     * @param id the user id.
     * @return
     */
    @GetMapping("/getUserById")
    public Result<User> getUserById(@RequestParam("id") Long id) {
        User user = userService.getById(id);
        return Result.success(user);
    }
}
