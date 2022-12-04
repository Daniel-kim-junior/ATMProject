package com.minsung;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Fianl String
        final String goodByeStr = "Good-Bye sir";
        final String selectStr = "Please Select Number";
        final String takeOutCardStr = "please take out your card";

        // Create instances
        User user = new User("Kim min sung", "302-0373-1781-31");
        Account account = new Account("NongHyup", 200000, 1234, user);
        ATMInfo atm = new ATMInfo("AT03-2342", 1000000);

        // insertCard -> confirm pinNumber -> verify -> Select Account -> Account info
        boolean testFlag = true;
        while(testFlag) {
            // Display log
            System.out.println(selectStr);
            System.out.println("---- 1 : Insert Card, --- 2 : Exit the Program");

            // Enter a number
            int selNum = ATMDisplay.readNum();
            if(selNum == 2) {
                testFlag = boolRev(testFlag);
                System.out.println(goodByeStr);
            } else if(selNum != 1) {
                // Invalid number
                System.out.println("Please Select 1 or 2");
            } else {
                // Insert a card
                atm.insertC();
                // authentication
                if(!ATMDisplay.pinVerify(account.getPinNum())) {
                    System.out.println("Failed to Verify");
                    System.out.println(takeOutCardStr);

                    atm.removeC();
                    testFlag = false;
                } else {
                    // authentication success
                    // show deposit, withdraw, balance
                    boolean userFlag = true;
                    while(userFlag) {
                        // Display log
                        System.out.println(selectStr);
                        System.out.println("---- 1 : View Balance, --- 2 : Withdraw, --- 3 : Deposit, --- 4 : Remove Card and Exit");

                        // Enter a Number
                        selNum = ATMDisplay.readNum();
                        if(selNum == 1) {
                            account.showBalance();
                        } else if(selNum == 2) {
                            System.out.println("How much do you want to withdraw?");

                            int withMoney = ATMDisplay.readNum();
                            // if the ATM has enough money
                            if(atm.isPossibleWithdraw(withMoney)) {
                                account.withDraw(withMoney);
                                atm.moneyOut(withMoney);
                            }
                        } else if(selNum == 3) {
                            System.out.println("How much do you want to deposit?");

                            int depMoney = ATMDisplay.readNum();
                            atm.moneyIn(depMoney);
                            account.deposit(depMoney);
                        } else if(selNum == 4) {
                            // Take out user card and exit
                            userFlag = boolRev(userFlag);
                            atm.removeC();
                            testFlag = boolRev(testFlag);

                            // Display log
                            System.out.println(takeOutCardStr);
                            System.out.println(goodByeStr);
                        } else {
                            System.out.println("Please Select 1 or 2 or 3 or 4");
                        }
                    }
                }
            }
        }
    }
    public static boolean boolRev(boolean f) {
        return !f;
    }

}
