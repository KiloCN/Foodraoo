package cn.kilo.foodraoo.user.mapper;

import cn.kilo.foodraoo.feign.pojo.AddressBook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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
