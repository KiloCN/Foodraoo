package cn.kilo.foodraoo.user.service.impl;

import cn.kilo.foodraoo.user.mapper.UserMapper;
import cn.kilo.foodraoo.feign.pojo.User;
import cn.kilo.foodraoo.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * The UserServiceImpl class is a service implementation that provides methods to manage User entities using a UserMapper instance.
 * It extends the ServiceImpl class and implements the UserService interface.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 * @see ServiceImpl
 * @see UserMapper
 * @see User
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
