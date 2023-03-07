package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.mapper.ShoppingCartMapper;
import cn.kilo.foodaroo.mapper.UserMapper;
import cn.kilo.foodaroo.pojo.ShoppingCart;
import cn.kilo.foodaroo.pojo.User;
import cn.kilo.foodaroo.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * The ShoppingCartServiceImpl class is a service implementation that provides methods to manage ShoppingCart entities using a ShoppingCartMapper instance.
 * It extends the ServiceImpl class and implements the ShoppingCartService interface.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 * @see ServiceImpl
 * @see ShoppingCartMapper
 * @see ShoppingCart
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
