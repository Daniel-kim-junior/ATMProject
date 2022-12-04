package com.minsung;

public class User {
    private String accountNum;
    private String name;

    User(String name, String accountNum) {
        this.name = name;
        this.accountNum = accountNum;
    }

    public String getUserName() {
        return this.name;
    }

    public String getAccountNum() {
        return this.accountNum;
    }
}
