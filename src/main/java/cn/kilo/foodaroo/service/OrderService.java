package cn.kilo.foodaroo.service;

import cn.kilo.foodaroo.pojo.Employee;
import cn.kilo.foodaroo.pojo.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * The OrderService interface extends the IService interface to provide specific service methods for Orders entities.
 * Its define how to handle the logic related services that manage Orders entities.
 *
 * @see Orders is the entity class that this service manages
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
public interface OrderService extends IService<Orders> {
    public void submit(Orders orders);
}
