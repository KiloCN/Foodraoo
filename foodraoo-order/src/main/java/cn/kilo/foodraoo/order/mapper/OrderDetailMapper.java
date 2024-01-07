package cn.kilo.foodraoo.order.mapper;

import cn.kilo.foodraoo.feign.pojo.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
/**
 * The OrderDetailMapper interface defines methods for accessing and manipulating OrderDetail records in a database.
 * This interface is used to perform CRUD operations (create, read, update, and delete) on the OrderDetail table.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
}
