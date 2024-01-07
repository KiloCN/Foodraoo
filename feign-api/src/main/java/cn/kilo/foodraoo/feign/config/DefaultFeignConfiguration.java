package cn.kilo.foodraoo.feign.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.Collections;



public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }

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
    @Bean
    public Encoder feignEncoder(){
        HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(customObjectMapper());
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(jacksonConverter);
        return new SpringEncoder(objectFactory);
    }

    public ObjectMapper customObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        //Customize as much as you want
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        return objectMapper;
    }



//    @Bean
//    public MappingJackson2HttpMessageConverter customMappingJackson2HttpMessageConverter() {
//        return new CustomMappingJackson2HttpMessageConverter();
//    }
//
//    static class CustomMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
//        public CustomMappingJackson2HttpMessageConverter() {
//            setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
//        }
//    }
}
