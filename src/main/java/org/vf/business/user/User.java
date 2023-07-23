package org.vf.business.user;

public class User {
    private int uid;
    private String account;

    private String password;

    User(int uid, String account, String password) {
        this.uid = uid;
        this.account = account;
        this.password = password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
