package org.vf.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.annotation.WebFilter;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(value = "org.vf.business", includeFilters = {
    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = RestController.class),
    @ComponentScan.Filter(type = FilterType.ANNOTATION, value = WebFilter.class)
})
public class WebConfig {
}
