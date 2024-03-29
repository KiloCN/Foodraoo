package cn.kilo.foodraoo.dish.service.impl;

import cn.kilo.foodraoo.dish.mapper.DishFlavorMapper;
import cn.kilo.foodraoo.feign.pojo.DishFlavor;
import cn.kilo.foodraoo.dish.service.DishFlavorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * The DishFlavorServiceImpl class is responsible for implementing the DishFlavorService interface and providing service methods related to DishFlavor objects.
 * It extends the ServiceImpl class, which provides the basic CRUD operations.
 * This class uses the DishFlavorMapper to interact with the database and perform CRUD operations.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
