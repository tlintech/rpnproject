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
        int x=0;
        int a=0;
        int b=0;
        stringExpression = setexpr;
        tokens = new StringTokenizer(stringExpression);
        numtokens = tokens.countTokens();

        while(tokens.hasMoreTokens()) {
            token = tokens.nextToken();
            // System.out.printf("token=<%s>\n",token);

            if ( token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") ) {

                // System.out.printf("its an operator! <%s>\n", token);
                element1 = st.pop();
                element2 = st.pop();
                // System.out.printf("pop = <%s>\n", element1);
                // System.out.printf("pop = <%s>\n", element2);
                a = Integer.parseInt(element1.toString());
                b = Integer.parseInt(element2.toString());

                if (token.equals("q")) {
                    System.exit(0);
                }

                if (token.equals("*")) {

                    x = b * a;
                }

                if (token.equals("+")) {
                    x = b + a;

                }

                if (token.equals("-")) {

                    x = b - a;
                }

                if (token.equals("/")) {
                        x = b / a;

                }
                // System.out.printf("result = <%d>", x);
                System.out.printf("%d\n", x);
                st.push(String.valueOf(x));
                // System.out.printf("push = <%d>", x);

            } else {
                if (token.equals("q")) {

                    System.exit(0);
                }
                    // determine token is numeric ?
                    if (token.matches(".*\\d.*")) {
                        // System.out.printf("its a number! <%s>\n",token);
                        // System.out.printf("push = <%s>\n", token);
                        // push number to stack
                        st.push(token);
                    } else {
                        System.out.printf("its not a number nor an operator!\n");
                    }

            }
        }

    }

    public int numTokens() {

        return numtokens;

    }



}
