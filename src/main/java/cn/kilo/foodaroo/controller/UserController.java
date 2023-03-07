package cn.kilo.foodaroo.controller;

import cn.kilo.foodaroo.common.Result;
import cn.kilo.foodaroo.pojo.User;
import cn.kilo.foodaroo.service.UserService;
import cn.kilo.foodaroo.utils.ValidateCodeUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

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

    /**
     * Send SMS verification code
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public Result<String> sendMsg(@RequestBody User user, HttpSession session){
        String phone = user.getPhone();

        if(StringUtils.isNotEmpty(phone)){
            //Generate random 4-bit CAPTCHA
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("The SMS verification code is "+code+" which phone number is "+phone);

            session.setAttribute(phone,code);

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
    public Result<User> login(@RequestBody Map map, HttpSession session){
        String phone = map.get("phone").toString();

        String code = map.get("code").toString();

        Object codeInSession = session.getAttribute(phone);

        if(codeInSession != null && codeInSession.equals(code)){

            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);

            User user = userService.getOne(queryWrapper);
            if(user == null){
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user",user.getId());
            return Result.success(user);
        }
        return Result.error("Login fail!");
    }
}
