package task2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Stack;
import java.lang.Math;

public class Algorithm {
    public static Double calculate(String s1) {
        
        Stack valueStack = new Stack<Double>();
        Stack operatorStack = new Stack<Character>();

        valueStack.push(0.0);
        /*
        Later in the code two elements from stack get removed whenever an operation occurs, 
        but when the first number is a square root of something there will be a "stack underflow" since it reads root as an operation and there is no number before it to get removed,
        therefore I added the 0.0 in the beginning, which does not affect the final result because it will never actually get involved in any calculations, 
        it will only get taken out when the first element is root and then immediately get placed back. For other operations it will not even get taken out at all.
        Insted of adding an element I could have just placed an if statement, but I think that is more time consuming than one additional element is space consuming.
        I am not sure if that assumption is right but I hope it is :)
        */

        for(int i = 0; i < s1.length(); i++) {

            if(s1.charAt(i) >= '0' && s1.charAt(i) <= '9') {
                double temp = (double)s1.charAt(i) - 48;
                //because ascii 0 is 48

                if(s1.charAt(i-2) == '.') {
                    temp /= 100;
                    temp += (double)valueStack.pop();
                } else if(s1.charAt(i-1) == '.') {
                    temp /= 10;
                    temp += (double)valueStack.pop();
                } else if(s1.charAt(i-1) >= '0' && s1.charAt(i-1) <= '9') {
                    temp += 10 * (double)valueStack.pop();
                }                

                valueStack.push(temp);
            }

            if(s1.charAt(i) == '+' || 
                s1.charAt(i) == '-' || 
                s1.charAt(i) == '*' || 
                s1.charAt(i) == '/' || 
                s1.charAt(i) == '%' ||
                s1.charAt(i) == '^' ||
                s1.charAt(i) == '√') {
                    operatorStack.push(s1.charAt(i));
                }

            if(s1.charAt(i) == ')') {
                double second = (double)valueStack.pop();
                double first = (double)valueStack.pop();
                char op = (char)operatorStack.pop();
                
                if(op == '+') {
                    valueStack.push(first + second);
                } else if(op == '-') {
                    valueStack.push(first - second);
                } else if(op == '*') {
                    valueStack.push(first * second);
                } else if(op == '/') {
                    valueStack.push(first / second);
                } else if (op == '%') {
                    valueStack.push(first % second);   
                } else if(op == '^') {
                    valueStack.push(Math.pow(first, second));
                } else if(op == '√') {
                    valueStack.push(first);
                    valueStack.push(Math.sqrt(second));
                } 

            }

        }
        
        double val = (double)valueStack.pop();
        return val;
    }


    //does not read file properly, not sure why
    public static ArrayList<Double> calculateFromFile(String filePath) throws FileNotFoundException {
        
        FileUtils files = new FileUtils();
        ArrayList<String> expressions = files.readFile(filePath);
        ArrayList<Double> result = new ArrayList<Double>();

        for(int i = 0; i < expressions.size(); i++) {
            result.add(Algorithm.calculate((String)expressions.get(i)));
        }

        return result;
    }
}
