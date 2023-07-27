package org.vf.configs;

import org.springframework.context.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.vf.log.DBLog;

import javax.servlet.annotation.WebFilter;

@Configuration
@ComponentScan(value = "org.vf", excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = RestController.class),
    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = WebFilter.class)
})
@EnableAspectJAutoProxy
public class RootConfig {
    @Bean
    public DBLog dbLog() {
        return new DBLog();
    }

    MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
}
