package com.minsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {
    // pinNumber Confirm Logic
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static int trials = 5;
    public static int readPinNum() throws IOException {
        try {
            return Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.out.println("Please Enter Only Number");
        }
        return 0;
    }

    public static boolean pinVerify(int correct) throws IOException {
        int trial = 0;
        boolean verify = false;
        System.out.println("Enter your pin Number");
        while(trial < trials) {
            int pin = readPinNum();
            if(pin == correct) {
                verify = true;
                break;
            } else {
                if(trial < trials - 1) {
                    System.out.println("Wrong pin number please retry");
                }
            }
            trial++;
        }
        return verify;
    }
}
