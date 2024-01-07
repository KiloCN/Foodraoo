package cn.kilo.foodraoo.order.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@Configuration
@Slf4j
public class FeignClientConfiguration {
//    @Bean
//    public Decoder feignDecoder() {
//        log.info("FeignClientConfiguration feignDecoder()");
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        // 添加JavaTimeModule来支持Java 8时间类型
//        JavaTimeModule javaTimeModule = new JavaTimeModule();
//        objectMapper.registerModule(javaTimeModule);
//
//        // 设置序列化特性，如果需要的话
//        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//
//        // 自定义日期时间格式
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));
//        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter));
//        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formatter));
//
//        // 创建一个SpringDecoder并设置自定义的ObjectMapper
//        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(new MappingJackson2HttpMessageConverter(objectMapper));
//        return new SpringDecoder(objectFactory);
//    }


//    测试类没问题，但是实际不行
//    @Bean
//    public Decoder feignDecoder() {
//        // 创建 FastJSON 配置
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        // 可以在这里配置FastJSON的一些参数，比如日期格式等
//
//        // 创建一个FastJsonHttpMessageConverter
//        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
//        fastJsonConverter.setFastJsonConfig(fastJsonConfig);
//
//        // 创建一个SpringDecoder并设置自定义的Converter
//        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(fastJsonConverter);
//        return new SpringDecoder(objectFactory);
//    }


    @Bean
    public Decoder feignDecoder() {
        // 创建 FastJSON 配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 可以在这里配置FastJSON的一些参数，比如日期格式等

        // 创建一个FastJsonHttpMessageConverter
        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
        fastJsonConverter.setFastJsonConfig(fastJsonConfig);

        // 创建一个SpringDecoder并设置自定义的Converter
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(fastJsonConverter);
        return new SpringDecoder(objectFactory);
    }

}
