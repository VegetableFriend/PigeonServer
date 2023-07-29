package org.vf.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.vf.constants.Constants;
import org.vf.services.session.SessionServiceDispatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

@Component("pigeonUidLoadFilter")
public class PigeonUidLoadFilter implements Filter {

    @Autowired
    SessionServiceDispatcher sessionServiceDispatcher;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
            HttpServletRequestWrapper httpServletRequestWrapper = new HttpServletRequestWrapper((HttpServletRequest) httpServletRequest) {
                @Override
                public String getParameter(String paramName) {
                    if (Constants.USER_ID_PARAM_KEY.equals(paramName)) {
                        return PigeonUidLoadFilter.this.sessionServiceDispatcher.
                                getUidWithSession(httpServletRequest.getSession().getId());
                    } else {
                        return super.getParameter(paramName);
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
