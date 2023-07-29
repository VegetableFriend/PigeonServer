package org.vf.services.session;

import org.springframework.stereotype.Component;

@Component
public interface SessionService {
    void setUidForSession(String session, String uid);

    String getUidWithSession(String session);
}
