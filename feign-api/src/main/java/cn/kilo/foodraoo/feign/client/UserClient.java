package cn.kilo.foodraoo.feign.client;

import cn.kilo.foodraoo.common.Result;
import cn.kilo.foodraoo.feign.pojo.AddressBook;
import cn.kilo.foodraoo.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("foodraoo-user")
public interface UserClient {

    @GetMapping("/user/getUserById")
    Result<User> getUserById(@RequestParam("id") Long id);


    @GetMapping("/addressBook/defaultAddressByUserId")
    Result<AddressBook> getDefaultAddress(@RequestParam("userId") Long userId);
}
