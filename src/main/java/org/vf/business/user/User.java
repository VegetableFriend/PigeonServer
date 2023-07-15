package org.vf.business.user;

public class User {
    private int uid;
    private String account;

    User(int uid, String account) {
        this.uid = uid;
        this.account = account;
    }

    public int getUid() {
        return uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
