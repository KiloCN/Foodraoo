package cn.kilo.foodraoo.order;

import cn.kilo.foodraoo.common.Result;
import cn.kilo.foodraoo.feign.pojo.ShoppingCart;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import feign.codec.Decoder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
class FoodraooOrderApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void testJackson() {
        ObjectMapper om = new ObjectMapper();

        String json = "{\n" +
                "    \"code\": 1,\n" +
                "    \"msg\": null,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": \"1742847515567693825\",\n" +
                "            \"name\": \"Filet-O-Fish\",\n" +
                "            \"userId\": \"1742842542909886465\",\n" +
                "            \"dishId\": null,\n" +
                "            \"setmealId\": \"1633703586772049921\",\n" +
                "            \"dishFlavor\": null,\n" +
                "            \"number\": 1,\n" +
                "            \"amount\": 22.00,\n" +
                "            \"image\": \"112c7628-3e27-471d-97bb-7194174d3659.jpeg\",\n" +
                "            \"createTime\": \"2024-01-04 17:56:43\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"1742847533276045314\",\n" +
                "            \"name\": \"Sprite\",\n" +
                "            \"userId\": \"1742842542909886465\",\n" +
                "            \"dishId\": null,\n" +
                "            \"setmealId\": \"1633545566708649986\",\n" +
                "            \"dishFlavor\": null,\n" +
                "            \"number\": 1,\n" +
                "            \"amount\": 3.00,\n" +
                "            \"image\": \"2c8118c4-e606-4eed-b300-4d9abe3dc97b.jpeg\",\n" +
                "            \"createTime\": \"2024-01-04 17:56:47\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"map\": {}\n" +
                "}";



        // convert json to Result<List<ShoppingCart>>
        try {
            Result<List<ShoppingCart>> result = om.readValue(json, new TypeReference<Result<List<ShoppingCart>>>() {
            });
            System.out.println(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }



    @Test
    void testJackson2() {
        ObjectMapper om = new ObjectMapper();

        // 添加JavaTimeModule来支持Java 8时间类型
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        om.registerModule(javaTimeModule);

        // 设置序列化特性，如果需要的话
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // 自定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        om.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formatter));


        // 你的JSON字符串
        String json = "{\n" +
                "    \"code\": 1,\n" +
                "    \"msg\": null,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": \"1742847515567693825\",\n" +
                "            \"name\": \"Filet-O-Fish\",\n" +
                "            \"userId\": \"1742842542909886465\",\n" +
                "            \"dishId\": null,\n" +
                "            \"setmealId\": \"1633703586772049921\",\n" +
                "            \"dishFlavor\": null,\n" +
                "            \"number\": 1,\n" +
                "            \"amount\": 22.00,\n" +
                "            \"image\": \"112c7628-3e27-471d-97bb-7194174d3659.jpeg\",\n" +
                "            \"createTime\": \"2024-01-04 17:56:43\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"1742847533276045314\",\n" +
                "            \"name\": \"Sprite\",\n" +
                "            \"userId\": \"1742842542909886465\",\n" +
                "            \"dishId\": null,\n" +
                "            \"setmealId\": \"1633545566708649986\",\n" +
                "            \"dishFlavor\": null,\n" +
                "            \"number\": 1,\n" +
                "            \"amount\": 3.00,\n" +
                "            \"image\": \"2c8118c4-e606-4eed-b300-4d9abe3dc97b.jpeg\",\n" +
                "            \"createTime\": \"2024-01-04 17:56:47\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"map\": {}\n" +
                "}";

        // 尝试将JSON转换为Result<List<ShoppingCart>>对象
        try {
            Result<List<ShoppingCart>> result = om.readValue(json, new TypeReference<Result<List<ShoppingCart>>>() {});
            System.out.println(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    @Test
    void testFastJson() {
        String json = "{\n" +
                "    \"code\": 1,\n" +
                "    \"msg\": null,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": \"1742847515567693825\",\n" +
                "            \"name\": \"Filet-O-Fish\",\n" +
                "            \"userId\": \"1742842542909886465\",\n" +
                "            \"dishId\": null,\n" +
                "            \"setmealId\": \"1633703586772049921\",\n" +
                "            \"dishFlavor\": null,\n" +
                "            \"number\": 1,\n" +
                "            \"amount\": 22.00,\n" +
                "            \"image\": \"112c7628-3e27-471d-97bb-7194174d3659.jpeg\",\n" +
                "            \"createTime\": \"2024-01-04 17:56:43\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"1742847533276045314\",\n" +
                "            \"name\": \"Sprite\",\n" +
                "            \"userId\": \"1742842542909886465\",\n" +
                "            \"dishId\": null,\n" +
                "            \"setmealId\": \"1633545566708649986\",\n" +
                "            \"dishFlavor\": null,\n" +
                "            \"number\": 1,\n" +
                "            \"amount\": 3.00,\n" +
                "            \"image\": \"2c8118c4-e606-4eed-b300-4d9abe3dc97b.jpeg\",\n" +
                "            \"createTime\": \"2024-01-04 17:56:47\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"map\": {}\n" +
                "}";

        // Try to convert JSON to Result<List<ShoppingCart>> object
        try {
            Result<List<ShoppingCart>> result = JSON.parseObject(json, new com.alibaba.fastjson.TypeReference<Result<List<ShoppingCart>>>() {});
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
