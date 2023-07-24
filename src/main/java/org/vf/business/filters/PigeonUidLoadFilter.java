package org.vf.business.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.vf.middleware.redis.RedisService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component("pigeonUidLoadFilter")
public class PigeonUidLoadFilter implements Filter {

    @Autowired
    RedisService redisService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
            HttpServletRequestWrapper httpServletRequestWrapper = new HttpServletRequestWrapper((HttpServletRequest) httpServletRequest) {
                @Override
                public Map<String, String[]> getParameterMap() {
                    String uid = PigeonUidLoadFilter.this.redisService.valueForKey(httpServletRequest.getSession().getId());

                    HashMap<String, String[]> newMap = new HashMap<>();
                    newMap.putAll(super.getParameterMap());
                    newMap.put("uid", new String[]{uid}) ;
                    return Collections.unmodifiableMap(newMap);
                }

                @Override
                public String getParameter(String name) {
                    if (name.equals("uid")) {
                        return PigeonUidLoadFilter.this.redisService.valueForKey(httpServletRequest.getSession().getId());
                    } else {
                        return super.getParameter(name);
                    }
                }
            };


            filterChain.doFilter(httpServletRequestWrapper, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
