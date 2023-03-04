package cn.kilo.foodaroo.service;

import cn.kilo.foodaroo.pojo.Category;
import cn.kilo.foodaroo.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * The CategoryService interface extends the IService interface to provide specific service methods for Category entities.
 * Its define how to handle the logic related services that manage Category entities.
 *
 * @see Category is the entity class that this service manages
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
public interface CategoryService extends IService<Category> {

    /**
     * Delete a Category based on the id,
     * Should check whether the Category is associated with a Setmeal(Combo) or Dish
     * @param id
     */
    public void removeCategoryById(Long id);
}
