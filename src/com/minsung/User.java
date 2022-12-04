package com.minsung;

public class User {
    private String accountNum;
    private String firstName;
    private String lastName;

    User(String firstName, String lastName, String accountNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNum = accountNum;
    }
}
