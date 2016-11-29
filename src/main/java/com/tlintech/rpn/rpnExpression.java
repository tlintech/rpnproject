package com.tlintech.rpn;


import java.util.StringTokenizer;
import java.util.Stack;
import java.io.PrintStream;


/**
 * Created by tlintech on 11/17/16.
 *  Rebase with github to github url rpnproject
 */
public class rpnExpression {

    String stringExpression;
    StringTokenizer tokens;
    int numtokens;

    public void set (String setexpr) {
        String token = new String();
        char[] tokenCharArray;
        Stack st = new Stack();
        Object element1;
        Object element2;
        double x=0.0;
        double a=0.0;
        double b=0.0;
        stringExpression = setexpr;
        tokens = new StringTokenizer(stringExpression);
        numtokens = tokens.countTokens();

        while(tokens.hasMoreTokens()) {
            token = tokens.nextToken();
            // System.out.printf("token=<%s>\n",token);

            // if its a number then push to the stack
            if (token.matches(".*\\d.*")) {
                // System.out.printf("its a number! <%s>\n",token);
                // System.out.printf("push = <%s>\n", token);
                // push number to stack
                st.push(token);
                // System.out.printf("(2)push = <%s>", token);

            }

            if ( token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") ) {

                // System.out.printf("its an operator! <%s>\n", token);
                element1 = st.pop();
                element2 = st.pop();
                // System.out.printf("pop = <%s>\n", element1);
                // System.out.printf("pop = <%s>\n", element2);
                a = Double.parseDouble(element1.toString());
                b = Double.parseDouble(element2.toString());

                if (token.equals("q")) { System.exit(0);}
                if (token.equals("*")) { x = b * a; }
                if (token.equals("+")) { x = b + a; }
                if (token.equals("-")) { x = b - a; }
                if (token.equals("/")) { x = b / a; }

                // System.out.printf("result = <%d>", x);
                System.out.printf("%f\n", x);
                st.push(Double.toString(x));
                // System.out.printf("(1)push = <%f>", x);

            }
        }

    }

    public int numTokens() {

        return numtokens;

    }



}
