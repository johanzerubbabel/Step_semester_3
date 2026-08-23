package controlflow.assigment_problems;
import java.util.Scanner;

public class PrimeChecker {
    static void checkPrime(int number) {
        boolean isPrime = true;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime ? "Prime" : "Not Prime");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number greater than 1: ");
        checkPrime(sc.nextInt());
        sc.close();
    }
}