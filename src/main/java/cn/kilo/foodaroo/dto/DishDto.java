package cn.kilo.foodaroo.dto;


import cn.kilo.foodaroo.pojo.Dish;
import cn.kilo.foodaroo.pojo.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
/**
 * The DishDto class is a data transfer object that represents a dish and its related information.
 * It extends the Dish class and adds additional fields such as flavors, category name, and number of copies.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
