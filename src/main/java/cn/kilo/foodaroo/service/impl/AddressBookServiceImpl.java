package cn.kilo.foodaroo.service.impl;

import cn.kilo.foodaroo.mapper.AddressBookMapper;
import cn.kilo.foodaroo.mapper.CategoryMapper;
import cn.kilo.foodaroo.pojo.AddressBook;
import cn.kilo.foodaroo.pojo.Category;
import cn.kilo.foodaroo.service.AddressBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;
/**
 * The AddressBookServiceImpl class is a service implementation that provides methods to manage AddressBook entities using a AddressBookMapper instance.
 * It extends the ServiceImpl class and implements the AddressBookService interface.
 * @see ServiceImpl
 * @see AddressBookMapper
 * @see AddressBook
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
