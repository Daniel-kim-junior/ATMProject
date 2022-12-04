package com.minsung;

import java.util.concurrent.ExecutionException;

public class ATMInfo {
    private String ATM_ID;
    private boolean insertCard;
    private int insideMoney;

    ATMInfo() {
        this.ATM_ID = "AT01-2321-25t2";
        this.insideMoney = 10000000;
        this.insertCard = false;
    }

    ATMInfo(String ATM_ID, int insideMoney) {
        this.insertCard = false;
        this.insideMoney = insideMoney;
        this.ATM_ID = ATM_ID;
    }

    public void insertC() {
         this.insertCard = true;
    }
    public void removeC() {
        this.insertCard = false;
    }


    public void moneyIn(int money) {
        this.insideMoney += money;
    }

    public void moneyOut(int money) {
        this.insideMoney -= money;
    }

    public boolean isPossibleWithdraw(int money) {
        if(this.insideMoney < money) {
            System.out.println("Lack of money in ATM");
            return false;
        }

        return true;
    }
}
