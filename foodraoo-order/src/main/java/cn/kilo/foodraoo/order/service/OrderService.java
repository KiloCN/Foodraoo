package cn.kilo.foodraoo.order.service;

import cn.kilo.foodraoo.feign.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * The OrderService interface extends the IService interface to provide specific service methods for Orders entities.
 * Its define how to handle the logic related services that manage Orders entities.
 *
 * @see Order is the entity class that this service manages
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
public interface OrderService extends IService<Order> {
    public void submit(Order order);
}
