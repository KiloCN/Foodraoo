package cn.kilo.foodaroo.dto;


import cn.kilo.foodaroo.pojo.Setmeal;
import cn.kilo.foodaroo.pojo.SetmealDish;
import lombok.Data;
import java.util.List;

/**
 * The SetmealDto class is a data transfer object that represents a dish and its related information.
 * It extends the Setmeal class and adds additional fields such as Setmeal_dish , category name, and number of copies.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
