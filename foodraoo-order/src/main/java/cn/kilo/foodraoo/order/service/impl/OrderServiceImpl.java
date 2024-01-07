package cn.kilo.foodraoo.order.service.impl;

import cn.kilo.foodraoo.common.BaseContext;
import cn.kilo.foodraoo.common.exception.BusinessException;
import cn.kilo.foodraoo.feign.client.ShoppingCartClient;
import cn.kilo.foodraoo.feign.client.UserClient;
import cn.kilo.foodraoo.feign.pojo.AddressBook;
import cn.kilo.foodraoo.feign.pojo.ShoppingCart;
import cn.kilo.foodraoo.feign.pojo.User;
import cn.kilo.foodraoo.order.mapper.OrderMapper;
import cn.kilo.foodraoo.feign.pojo.*;
import cn.kilo.foodraoo.order.service.*;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * The OrderServiceImpl class is a service implementation that provides methods to manage Orders entities using a OrderMapper instance.
 * It extends the ServiceImpl class and implements the OrderService interface.
 * @see ServiceImpl
 * @see OrderMapper
 * @see Order
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private ShoppingCartClient shoppingCartClient;
    @Autowired
    private UserClient userClient;
    @Autowired
    private OrderDetailService orderDetailService;


    @Override
    public void submit(Order order) {
        //there mey be a problem here!
        Long currentUserId = BaseContext.getCurrentId();

//        LambdaQueryWrapper<ShoppingCart> shoppingCartLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        shoppingCartLambdaQueryWrapper.eq(ShoppingCart::getUserId, currentUserId);
//        List<ShoppingCart> shoppingCartList = shoppingCartService.list(shoppingCartLambdaQueryWrapper);
//
//        if ((shoppingCartList == null) || (shoppingCartList.size() == 0)) {
//            throw new BusinessException("ShoppingCart is empty!");
//        }
        //Modify the above code to the following code(Microservice call)
        List<ShoppingCart> shoppingCartList = shoppingCartClient.getShoppingCartListByUserId(currentUserId).getData();
        if ((shoppingCartList == null) || (shoppingCartList.size() == 0)) {
            throw new BusinessException("ShoppingCart is empty!");
        }


//        User user = userService.getById(currentUserId);
//        AddressBook addressBook = addressBookService.getById(orders.getAddressBookId());

        //Modify the above code to the following code(Microservice call)
        User user = userClient.getUserById(currentUserId).getData();
        AddressBook addressBook = userClient.getDefaultAddress(currentUserId).getData();

        if (addressBook == null) {
            throw new BusinessException("No default address can not submit order!");
        }

        long orderId = IdWorker.getId();

        AtomicInteger amount = new AtomicInteger(0);
        List<OrderDetail> orderDetailList = shoppingCartList.stream().map((ShoppingCart item) -> {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setNumber(item.getNumber());
            orderDetail.setDishFlavor(item.getDishFlavor());
            orderDetail.setDishId(item.getDishId());
            orderDetail.setSetmealId(item.getSetmealId());
            orderDetail.setName(item.getName());
            orderDetail.setImage(item.getImage());
            orderDetail.setAmount(item.getAmount());
            amount.addAndGet(item.getAmount().multiply(new BigDecimal(item.getNumber())).intValue());
            return orderDetail;
        }).collect(Collectors.toList());
        orderDetailService.saveBatch(orderDetailList);



        order.setNumber(String.valueOf(orderId));
        order.setOrderTime(LocalDateTime.now());
        order.setCheckoutTime(LocalDateTime.now());
        order.setStatus(2);
        order.setAmount(new BigDecimal(amount.get()));
        order.setUserId(currentUserId);
        order.setUserName(user.getName());
        order.setConsignee(addressBook.getConsignee());
        order.setPhone(addressBook.getPhone());
        order.setAddress((addressBook.getProvinceName() == null ? "" : addressBook.getProvinceName())
                + (addressBook.getCityName() == null ? "" : addressBook.getCityName())
                + (addressBook.getDistrictName() == null ? "" : addressBook.getDistrictName())
                + (addressBook.getDetail() == null ? "" : addressBook.getDetail()));
        order.setPosition(addressBook.getPosition());

        this.save(order);

        //Transaction, if order add seccessfully, then delete the shopping cart.
//        shoppingCartService.remove(shoppingCartLambdaQueryWrapper);
        //Modify the above code to the following code(Microservice call)
        shoppingCartClient.deleteShoppingCartByUserId(currentUserId);
    }
}
