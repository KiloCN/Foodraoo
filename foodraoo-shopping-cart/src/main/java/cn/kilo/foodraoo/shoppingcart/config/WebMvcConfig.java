package cn.kilo.foodraoo.shoppingcart.config;

import cn.kilo.foodraoo.common.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * Web related configuration
 *
 * @author kilo
 * @version 0.0.1-SNAPSHOT
 */
@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {


    /**
     * Add JacksonObjectMapper Converters
     *
     * @param converters
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        converters.add(0, messageConverter);
    }

}
