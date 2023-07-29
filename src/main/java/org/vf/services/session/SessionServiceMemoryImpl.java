package org.vf.services.session;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SessionServiceMemoryImpl implements SessionService {
    private HashMap<String, String> sessionUidHashMap = new HashMap<>();

    @Override
    public void setUidForSession(String session, String uid) {
        this.sessionUidHashMap.put(session, uid);
    }

    @Override
    public String getUidWithSession(String session) {
        return this.sessionUidHashMap.get(session);
    }
}
