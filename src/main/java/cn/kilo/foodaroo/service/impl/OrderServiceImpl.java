package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.common.BaseContext;
import cn.kilo.foodaroo.common.exception.BusinessException;
import cn.kilo.foodaroo.mapper.OrderDetailMapper;
import cn.kilo.foodaroo.mapper.OrderMapper;
import cn.kilo.foodaroo.pojo.*;
import cn.kilo.foodaroo.service.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
 * @see Orders
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressBookService addressBookService;
    @Autowired
    private OrderDetailService orderDetailService;


    @Override
    public void submit(Orders orders) {
        Long currentUserId = BaseContext.getCurrentId();

        LambdaQueryWrapper<ShoppingCart> shoppingCartLambdaQueryWrapper = new LambdaQueryWrapper<>();
        shoppingCartLambdaQueryWrapper.eq(ShoppingCart::getUserId, currentUserId);
        List<ShoppingCart> shoppingCartList = shoppingCartService.list(shoppingCartLambdaQueryWrapper);

        if ((shoppingCartList == null) || (shoppingCartList.size() == 0)) {
            throw new BusinessException("ShoppingCart is empty!");
        }


        User user = userService.getById(currentUserId);
        AddressBook addressBook = addressBookService.getById(orders.getAddressBookId());

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



        orders.setNumber(String.valueOf(orderId));
        orders.setOrderTime(LocalDateTime.now());
        orders.setCheckoutTime(LocalDateTime.now());
        orders.setStatus(2);
        orders.setAmount(new BigDecimal(amount.get()));
        orders.setUserId(currentUserId);
        orders.setUserName(user.getName());
        orders.setConsignee(addressBook.getConsignee());
        orders.setPhone(addressBook.getPhone());
        orders.setAddress((addressBook.getProvinceName() == null ? "" : addressBook.getProvinceName())
                + (addressBook.getCityName() == null ? "" : addressBook.getCityName())
                + (addressBook.getDistrictName() == null ? "" : addressBook.getDistrictName())
                + (addressBook.getDetail() == null ? "" : addressBook.getDetail()));

        this.save(orders);

        shoppingCartService.remove(shoppingCartLambdaQueryWrapper);
    }
}
