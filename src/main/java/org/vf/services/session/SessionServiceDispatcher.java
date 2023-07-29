package org.vf.services.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionServiceDispatcher {
    @Autowired
    SessionService sessionService;

    public void setUidForSession(String session, String uid) {
        this.sessionService.setUidForSession(session, uid);
    }

    public String getUidWithSession(String session) {
        return this.sessionService.getUidWithSession(session);
    }
}
