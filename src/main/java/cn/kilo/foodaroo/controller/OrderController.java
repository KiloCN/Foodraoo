package cn.kilo.foodaroo.controller;

import cn.kilo.foodaroo.common.BaseContext;
import cn.kilo.foodaroo.common.Result;
import cn.kilo.foodaroo.pojo.Orders;
import cn.kilo.foodaroo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping("/submit")
    public Result<String> submitOrder(@RequestBody Orders orders){
        log.info(orders.toString());
        log.info(BaseContext.getCurrentId().toString());

        orderService.submit(orders);
        return Result.success("Submit Order successfully!") ;
    }
}
