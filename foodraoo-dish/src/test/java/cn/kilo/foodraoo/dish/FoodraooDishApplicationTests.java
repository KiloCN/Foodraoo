package cn.kilo.foodraoo.dish;

import cn.kilo.foodraoo.dish.mapper.CategoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodraooDishApplicationTests {
    @Autowired
    CategoryMapper categoryMapper;



    @Test
    void test1(){
        System.out.println("abc");
    }


    @Test
    void test2(){
        System.out.println(categoryMapper.selectById(1413341197421846529L).toString());
    }
}
