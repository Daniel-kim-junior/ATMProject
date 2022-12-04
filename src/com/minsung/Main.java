package com.minsung;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        
        User user = new User("minsung", "Kim", "302-0373-1781-31");
        Account account = new Account("NongHyup", 200000, 1234, user);
        ATMInfo atm = new ATMInfo("AT03-2342", 1000000);

        // insertCard -> confirm pinNumber -> verify -> Select Account -> Account info
        boolean testFlag = true;
        while(testFlag) {
            System.out.println("Please Select Number");
            System.out.println("---- 1 : Insert Card, --- 2 : Exit the Program");
            int selNum = ATMDisplay.readNum();
            if(selNum == 2) {
                testFlag = false;
            } else if(selNum != 1) {
                System.out.println("Please Select 1 or 2");
            } else {
                atm.insertC();
                // authentication
                if(!ATMDisplay.pinVerify(account.getPinNum())) {
                    System.out.println("Failed to Verify, please take out your card");
                    atm.removeC();
                    testFlag = false;
                }

                // authentication success
                // show deposit, withdraw, balance
                boolean userFlag = true;
                while(userFlag) {
                    System.out.println("Please Select Number");
                    System.out.println("---- 1 : View Balance, --- 2 : Withdraw, --- 3 : Deposit, --- 4 : Remove Card and Exit");
                    selNum = ATMDisplay.readNum();
                    if(selNum == 1) {
                        account.showBalance();
                    } else if(selNum == 2) {
                        System.out.println("How much do you want to withdraw?");
                        int withMoney = ATMDisplay.readNum();
                        if(atm.isPossibleWithdraw(withMoney)) {
                            account.withDraw(withMoney);
                            atm.withdraw(withMoney);
                        }
                    } else if(selNum == 3) {
                        int depMoney = ATMDisplay.readNum();
                        atm.deposit(depMoney);
                        account.deposit(depMoney);
                    } else if(selNum == 4) {
                        userFlag = false;
                        atm.removeC();
                        testFlag = false;
                        System.out.println("Good bye");
                    } else {
                        System.out.println("Please Select 1 or 2 or 3 or 4");
                    }
                }

            }
        }
    }


}
