package com.minsung;


public class Account {
    private String bankName;

    private int balance;

    private String accountNum;

    private User userInformation;

    public Account(String bankName, int balance, String accountNum, User userInformation) {
        this.bankName = bankName;
        this.balance = balance;
        this.accountNum = accountNum;
        this.userInformation = userInformation;
    }

    public void showBalance() {
        System.out.println(this.balance);
    }

    public int returnWithdraw() {
        return this.balance;
    }


    public void deposit(int money) {
        this.balance += money;
        int cost = returnWithdraw();

        String depPhrase = "Deposited amount is " + money;
        String curPhrase = "Current balance is " + cost;
        System.out.println(depPhrase);
        System.out.print(curPhrase);
    }

    public void withDraw(int money) {
        try {
            int cost = returnWithdraw() - money;
            if(cost < 0) {
                throw new Exception();
            }
            System.out.println("withdraw money "+ money + " current balance is " + cost);
        } catch (Exception e) {
            System.out.println("Balance is insufficient");
        }

    }






}
