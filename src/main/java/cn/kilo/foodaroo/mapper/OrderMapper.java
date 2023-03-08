package cn.kilo.foodaroo.mapper;

import cn.kilo.foodaroo.pojo.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 * The OrderMapper interface defines methods for accessing and manipulating Order records in a database.
 * This interface is used to perform CRUD operations (create, read, update, and delete) on the order table.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
