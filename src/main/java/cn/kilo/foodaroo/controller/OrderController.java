package cn.kilo.foodaroo.controller;

import cn.kilo.foodaroo.common.BaseContext;
import cn.kilo.foodaroo.common.Result;
import cn.kilo.foodaroo.pojo.Orders;
import cn.kilo.foodaroo.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param orders
     * @return
     */
    @RequestMapping("/submit")
    public Result<String> submitOrder(@RequestBody Orders orders){
        log.info(orders.toString());
        log.info(BaseContext.getCurrentId().toString());

        orderService.submit(orders);
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
    public Result<Page<Orders>> getPage(int page, int pageSize, Long number, String beginTime, String endTime){
        Page<Orders> pageInfo = new Page<>(page, pageSize);

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

        LambdaQueryWrapper<Orders> ordersLambdaQueryWrapper = new LambdaQueryWrapper<>();
        ordersLambdaQueryWrapper.like(number != null, Orders::getNumber, number);
        ordersLambdaQueryWrapper.ge(beginTimeLocalDateTime != null, Orders::getOrderTime, beginTimeLocalDateTime).
                le(endTimeLocalDateTime != null, Orders::getOrderTime, endTimeLocalDateTime);
        ordersLambdaQueryWrapper.orderByDesc(Orders::getOrderTime);

        Page<Orders> pageResult = orderService.page(pageInfo, ordersLambdaQueryWrapper);

        return Result.success(pageResult);
    }

    /**
     * Get the History Order Page of current user
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/userPage")
    public Result<Page<Orders>> getHistoryOrderPage(int page, int pageSize){
        Long currentUserId = BaseContext.getCurrentId();
        Page<Orders> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Orders> ordersLambdaQueryWrapper = new LambdaQueryWrapper<>();
        ordersLambdaQueryWrapper.eq(Orders::getUserId,currentUserId);
        ordersLambdaQueryWrapper.orderByDesc(Orders::getOrderTime);
        Page<Orders> pageResult = orderService.page(pageInfo, ordersLambdaQueryWrapper);
        return Result.success(pageResult);

    }
}
