package cn.kilo.foodraoo.order.controller;

import cn.kilo.foodraoo.common.BaseContext;
import cn.kilo.foodraoo.common.Result;
import cn.kilo.foodraoo.feign.pojo.Order;
import cn.kilo.foodraoo.order.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * The OrderController class handles HTTP requests related to order management.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * Submit Order
     * @param order
     * @return
     */
    @RequestMapping("/submit")
    public Result<String> submitOrder(@RequestBody Order order){
        log.info(order.toString());
        log.info(BaseContext.getCurrentId().toString());

        orderService.submit(order);
        return Result.success("Submit Order successfully!") ;
    }


    /**
     * Get Orders Page according to the condition
     * @param page
     * @param pageSize
     * @param number
     * @param beginTime
     * @param endTime
     * @return
     */
    @GetMapping("/page")
    public Result<Page<Order>> getPage(int page, int pageSize, Long number, String beginTime, String endTime){
        Page<Order> pageInfo = new Page<>(page, pageSize);

        LocalDateTime beginTimeLocalDateTime = null;
        LocalDateTime endTimeLocalDateTime = null;
        if (beginTime != null) {
            beginTime = beginTime.replaceAll("%20","T").replaceAll("%3A",":");
            beginTimeLocalDateTime = LocalDateTime.parse(beginTime);
        }
        if (endTime != null) {
            endTime = endTime.replaceAll("%20","T").replaceAll("%3A",":");
            endTimeLocalDateTime = LocalDateTime.parse(endTime);
        }

        LambdaQueryWrapper<Order> ordersLambdaQueryWrapper = new LambdaQueryWrapper<>();
        ordersLambdaQueryWrapper.like(number != null, Order::getNumber, number);
        ordersLambdaQueryWrapper.ge(beginTimeLocalDateTime != null, Order::getOrderTime, beginTimeLocalDateTime).
                le(endTimeLocalDateTime != null, Order::getOrderTime, endTimeLocalDateTime);
        ordersLambdaQueryWrapper.orderByDesc(Order::getOrderTime);

        Page<Order> pageResult = orderService.page(pageInfo, ordersLambdaQueryWrapper);

        return Result.success(pageResult);
    }

    /**
     * Get the History Order Page of current user
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/userPage")
    public Result<Page<Order>> getHistoryOrderPage(int page, int pageSize){
        Long currentUserId = BaseContext.getCurrentId();
        Page<Order> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Order> ordersLambdaQueryWrapper = new LambdaQueryWrapper<>();
        ordersLambdaQueryWrapper.eq(Order::getUserId,currentUserId);
        ordersLambdaQueryWrapper.orderByDesc(Order::getOrderTime);
        Page<Order> pageResult = orderService.page(pageInfo, ordersLambdaQueryWrapper);
        return Result.success(pageResult);

    }


    /**
     * Update Order info
     * @param order
     * @return
     */
    @PutMapping
    public Result<String> updateOrder(@RequestBody Order order){
        try {
            orderService.updateById(order);
            return Result.success("Update order successfully!");
        } catch (Exception e) {
            return Result.error("Error in updating this order!");
        }
    }



    /**
     * Get Order by id
     * @param id
     * @return
     */
    @GetMapping("/getOrderById")
    public Result<Order> getOrderById(@RequestParam("id") Long id){
        Order order = orderService.getById(id);
        return Result.success(order);
    }
}
