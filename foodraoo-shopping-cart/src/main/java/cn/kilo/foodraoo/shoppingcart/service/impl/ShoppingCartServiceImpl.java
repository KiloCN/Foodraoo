package cn.kilo.foodraoo.shoppingcart.service.impl;

import cn.kilo.foodraoo.common.exception.BusinessException;
import cn.kilo.foodraoo.shoppingcart.mapper.ShoppingCartMapper;
import cn.kilo.foodraoo.feign.pojo.ShoppingCart;
import cn.kilo.foodraoo.shoppingcart.service.ShoppingCartService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override
    public List<ShoppingCart> getShoppingCartListByUserId(Long userId) {
        LambdaQueryWrapper<ShoppingCart> shoppingCartLambdaQueryWrapper = new LambdaQueryWrapper<>();
        shoppingCartLambdaQueryWrapper.eq(ShoppingCart::getUserId, userId);
        return this.list(shoppingCartLambdaQueryWrapper);
    }

    @Override
    public boolean deleteShoppingCartByUserId(Long userId) {
        LambdaQueryWrapper<ShoppingCart> shoppingCartLambdaQueryWrapper = new LambdaQueryWrapper<>();
        shoppingCartLambdaQueryWrapper.eq(ShoppingCart::getUserId, userId);
        return this.remove(shoppingCartLambdaQueryWrapper);
    }
}
