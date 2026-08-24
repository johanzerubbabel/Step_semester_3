package controlflow.class_problems;
import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int origNumber = number;
        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number = number / 10;
        }

        boolean isPalindrome = (reversedNumber == origNumber);
        System.out.println("Is the number " + origNumber + " a Palindrome? " + isPalindrome);
        sc.close();
    }
}
