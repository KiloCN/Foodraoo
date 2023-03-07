package cn.kilo.foodaroo.mapper;

import cn.kilo.foodaroo.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * The UserMapper interface defines methods for accessing and manipulating User records in a database.
 * This interface is used to perform CRUD operations (create, read, update, and delete) on the User table.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
