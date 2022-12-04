# Bear-Robotics Intern AssignMent

#### ATM Controller assignMent



## Requirements

Write code for a simple ATM. It doesn't need any UI

At least the following flow should be implemented: Insert Card => PIN number => Select Account => See Balance/Deposit/Withdraw

For simplification, there are only 1 dollar bills in this world, no cents. Thus account balance can be represented in integer.

Your code doesn't need to integrate with a real bank system, but keep in mind that we may want to integrate it with a real bank system in the future. It doesn't have to integrate with a real cash bin in the ATM, but keep in mind that we'd want to integrate with that in the future. And even if we integrate it with them, we'd like to test our code. Implementing bank integration and ATM hardware like cash bin and card reader is not a scope of this task, but testing the controller part (not including bank system, cash bin etc) is within the scope.

A bank API wouldn't give the ATM the PIN number, but it can tell you if the PIN number is correct or not.

Based on your work, another engineer should be able to implement the user interface. You don't need to implement any REST API, RPC, network communication etc, but just functions/classes/methods, etc.

You can simplify some complex real world problems if you think it's not worth illustrating in the project.

## Environment and Code explan
Language : JAVA 11

The five files are located to "src/com/minsung"

### 1. Account.java
This Code consist of Account Information and four methods

(1) showBalance : User can view their balance

(2) deposit : User can deposit at their account

(3) withDraw : User can withdraw money from their account

(4) getPinNum : It is used to compare with the pinNumber recieved from main input for testing (getter)

### 2. User.java
This Code consist of User Information and two methods

(1) getUserName : getter userName

(2) getAccountNum : getter accountNum

### 3. ATMDisplay.java
This Code consist of two methods, and has a BufferedReader for input

(1) readNum : This method uses a BufferedReader and Exception process for user input.

(2) pinVerify : This method checks the user's pin number with a limit of five inputs.

### 4. ATMInfo.java

This Code is ATM information consist of five methods

(1) insertC : This method insert a card in an ATM

(2) removeC : This method remove a card in an ATM

(3) moneyIn : This method puts money into an ATM

(4) moneyOut : This method outs money at an ATM

(5) isPossibleWithdraw : This method checks whether ATM has enough money

### 5. Main.java

This Code is consist of looping Test and Final String variable and Create instance and Boolean Reverse method
