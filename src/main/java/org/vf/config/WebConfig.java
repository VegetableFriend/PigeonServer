package org.vf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(value = "org.vf.business", includeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = RestController.class)
})
public class WebConfig {

}
