package org.vf.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.vf.business.user.User;
import org.vf.services.cache.RedisService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PigeonSavedRequestAwareAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    RequestCache requestCache;

    @Autowired
    RedisService redisService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SavedRequest savedRequest = this.requestCache.getRequest(request, response);
        this.saveRequestSessionIdAndUid(request, authentication);

        if (savedRequest == null) {
            clearAuthenticationAttributes(request);
        } else {
            String targetUrlParameter = this.getTargetUrlParameter();

            if (!this.isAlwaysUseDefaultTargetUrl() && (targetUrlParameter == null || !StringUtils.hasText(request.getParameter(targetUrlParameter)))) {
                this.clearAuthenticationAttributes(request);
            } else {
                this.requestCache.removeRequest(request, response);
                this.clearAuthenticationAttributes(request);
            }
        }
    }

    @Bean
    RequestCache requestCache() {
        return new HttpSessionRequestCache();
    }

    private void saveRequestSessionIdAndUid(HttpServletRequest request, Authentication authentication) {
        this.redisService.setValueForKey(this.sessionIdFrom(request), this.uidFrom(authentication));
    }

    private String sessionIdFrom(HttpServletRequest request) {
        return request.getSession().getId();
    }

    private String uidFrom(Authentication authentication) {
        String uid = "";

        Object obj = authentication.getPrincipal();
        if (obj instanceof User) {
            User user = (User)obj;
            uid = String.valueOf(user.getUid());
        }
        return uid;
    }
}
