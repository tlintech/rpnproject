package com.tlintech.rpn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String args[]) {

        try {

            InputStreamReader in= new InputStreamReader(System.in);
            BufferedReader input = new BufferedReader(in);
            String str;
            rpnExpression expression = new rpnExpression();

            System.out.print("Enter Reverse Post Fix Notation and press Enter:");

            while ((str = input.readLine()) != null) {
                // System.out.println(str);

                expression.set(str);
                // System.out.printf("number of tokens = %d\n", expression.numTokens());

            }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }




}


