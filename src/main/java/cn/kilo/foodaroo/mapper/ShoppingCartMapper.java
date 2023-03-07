package cn.kilo.foodaroo.mapper;

import cn.kilo.foodaroo.pojo.ShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 * The ShoppingCartMapper interface defines methods for accessing and manipulating ShoppingCart records in a database.
 * This interface is used to perform CRUD operations (create, read, update, and delete) on the ShoppingCart  table.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

}
