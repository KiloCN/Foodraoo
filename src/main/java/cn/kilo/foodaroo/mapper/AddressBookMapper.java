package cn.kilo.foodaroo.mapper;

import cn.kilo.foodaroo.pojo.AddressBook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * The AddressBookMapper interface defines methods for accessing and manipulating AddressBook records in a database.
 * This interface is used to perform CRUD operations (create, read, update, and delete) on the AddressBook  table.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {

}
