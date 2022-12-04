package com.minsung;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        User user = new User("minsung", "Kim", "302-0373-1781-31");
        Account account = new Account("NongHyup", 200000, "302-0373-1781-31", user);
        Cash cash = new Cash();
        ATM atm = new ATM();
        if(atm.pinVerify(2012)) {
            System.out.println("Verify your pin Number");
        } else {
            System.out.println("Failed Verify");
        }

    }


}
