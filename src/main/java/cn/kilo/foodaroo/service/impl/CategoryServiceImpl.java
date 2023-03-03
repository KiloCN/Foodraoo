package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.mapper.CategoryMapper;
import cn.kilo.foodaroo.mapper.EmployeeMapper;
import cn.kilo.foodaroo.pojo.Category;
import cn.kilo.foodaroo.service.CategoryService;
import cn.kilo.foodaroo.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * The CategoryServiceImpl class is a service implementation that provides methods to manage Category entities using a CategoryMapper instance.
 * It extends the ServiceImpl class and implements the CategoryService interface.
 * @see ServiceImpl
 * @see CategoryMapper
 * @see Category
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
