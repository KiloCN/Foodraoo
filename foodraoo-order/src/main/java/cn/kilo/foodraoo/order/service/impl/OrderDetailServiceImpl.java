package cn.kilo.foodraoo.order.service.impl;

import cn.kilo.foodraoo.order.mapper.OrderDetailMapper;
import cn.kilo.foodraoo.feign.pojo.OrderDetail;
import cn.kilo.foodraoo.order.service.OrderDetailService;
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
