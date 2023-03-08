package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.mapper.OrderDetailMapper;
import cn.kilo.foodaroo.mapper.SetmealDishMapper;
import cn.kilo.foodaroo.pojo.OrderDetail;
import cn.kilo.foodaroo.pojo.SetmealDish;
import cn.kilo.foodaroo.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * The OrderDetailServiceImpl class is a service implementation that provides methods to manage OrderDetail entities using a OrderDetailMapper instance.
 * It extends the ServiceImpl class and implements the OrderDetailService interface.
 * @see ServiceImpl
 * @see OrderDetailMapper
 * @see OrderDetail
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
