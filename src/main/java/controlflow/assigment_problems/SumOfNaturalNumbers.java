package controlflow.assigment_problems;
import java.util.Scanner;

public class SumOfNaturalNumbers {
    static void sumOfNaturalNumbers(int n) {
        int counter = 1, sum = 0;
        while (counter <= n) {
            sum += counter;
            counter++;
        }
        System.out.println("Sum of numbers from 1 to " + n + " = " + sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        sumOfNaturalNumbers(sc.nextInt());
        sc.close();
    }
}