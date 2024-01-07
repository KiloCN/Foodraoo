package cn.kilo.foodraoo.user.controller;

import cn.kilo.foodraoo.common.BaseContext;
import cn.kilo.foodraoo.common.Result;
import cn.kilo.foodraoo.feign.pojo.AddressBook;
import cn.kilo.foodraoo.user.service.AddressBookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * This class represents an API for managing address book related operations.
 * It contains methods for adding, updating, and querying address book.
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Slf4j
@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    /**
     * Add new AddressBook
     */
    @PostMapping()
    public Result<AddressBook> save(@RequestBody AddressBook addressBook) {
        addressBook.setUserId(BaseContext.getCurrentId());
        log.info("addressBook:{}", addressBook);
        addressBookService.save(addressBook);
        return Result.success(addressBook);
    }

    /**
     * Upadate new AddressBook
     */
    @PutMapping
    public Result<AddressBook> update(@RequestBody AddressBook addressBook) {
        addressBook.setUserId(BaseContext.getCurrentId());
        log.info("addressBook:{}", addressBook);
        addressBookService.updateById(addressBook);
        return Result.success(addressBook);
    }

    /**
     * Delete AddressBook
     */
    @DeleteMapping
    public Result delete(@RequestParam("ids") List<Long> ids) {
        log.info("ids:{}", ids);
        addressBookService.removeByIds(ids);
        return Result.success("Delete successfully");
    }


    /**
     * Set the default address
     */
    @PutMapping("/default")
    public Result<AddressBook> setDefault(@RequestBody AddressBook addressBook) {
        log.info("addressBook:{}", addressBook);
        LambdaUpdateWrapper<AddressBook> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(AddressBook::getUserId, BaseContext.getCurrentId());
        wrapper.set(AddressBook::getIsDefault, 0);
        //SQL:update address_book set is_default = 0 where user_id = ?
        addressBookService.update(wrapper);

        addressBook.setIsDefault(1);
        //SQL:update address_book set is_default = 1 where id = ?
        addressBookService.updateById(addressBook);
        return Result.success(addressBook);
    }

    /**
     * Query address according to id
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Long id) {
        AddressBook addressBook = addressBookService.getById(id);
        if (addressBook != null) {
            return Result.success(addressBook);
        } else {
            return Result.error("The object was not found");
        }
    }

    /**
     * Query default address
     */
    @GetMapping("/default")
    public Result<AddressBook> getDefault() {
        LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AddressBook::getUserId, BaseContext.getCurrentId());
        queryWrapper.eq(AddressBook::getIsDefault, 1);

        //SQL:select * from address_book where user_id = ? and is_default = 1
        AddressBook addressBook = addressBookService.getOne(queryWrapper);

        if (null == addressBook) {
            return Result.error("The object was not found");
        } else {
            return Result.success(addressBook);
        }
    }

    /**
     * Query all addresses of specified users
     */
    @GetMapping("/list")
    public Result<List<AddressBook>> list(AddressBook addressBook) {
        addressBook.setUserId(BaseContext.getCurrentId());
//        log.info(BaseContext.getCurrentId().toString());
        log.info("addressBook:{}", addressBook);

        LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(null != addressBook.getUserId(), AddressBook::getUserId, addressBook.getUserId());
        queryWrapper.orderByDesc(AddressBook::getUpdateTime);

        //SQL:select * from address_book where user_id = ? order by update_time desc
        return Result.success(addressBookService.list(queryWrapper));
    }


    @GetMapping("/defaultAddressByUserId")
    public Result<AddressBook> getDefaultAddress(@RequestParam("userId") Long userId) {
        log.info("getDefaultAddress() userId:{}", userId);
        LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AddressBook::getUserId, userId);
        queryWrapper.eq(AddressBook::getIsDefault, 1);

        //SQL:select * from address_book where user_id = ? and is_default = 1
        AddressBook addressBook = addressBookService.getOne(queryWrapper);

        if (null == addressBook) {
            return Result.error("The default address was not found");
        } else {
            return Result.success(addressBook);
        }
    }
}
