package task2;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String answer;

        System.out.println("How will you input expressions? \nA) manually \nB) from file");
        answer = reader.nextLine();

        if(answer.equals("A")) {
            System.out.println("Enter expression: ");
            answer = reader.nextLine();
            System.out.println(Algorithm.calculate(answer));
        } else if(answer.equals("B")) {
        /*
            System.out.println("Enter file: ");
            answer = reader.nextLine();

            ArrayList<Double> result = Algorithm.calculateFromFile(answer);
            for(Double each: result) {
                System.out.println(each);
            } 
        */
        } else {
            System.out.println("Sorry, wrong input.");
        }

    }
}
