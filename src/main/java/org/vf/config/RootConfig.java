package org.vf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
@Configuration
@ComponentScan(value = "org.vf", excludeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = RestController.class)
})
public class RootConfig {

    MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }
}
