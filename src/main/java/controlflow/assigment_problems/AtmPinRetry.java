package controlflow.assigment_problems;
import java.util.Scanner;

public class AtmPinRetry {
    static void atmPinRetry(String correctPin, String[] attempts) {
        int index = 0;
        boolean success = false;
        while (index < attempts.length && !success) {
            if (attempts[index].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }
            index++;
        }
        if (!success) System.out.println("Card blocked — too many incorrect attempts");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter correct PIN: ");
        String correctPin = sc.next();
        System.out.print("Enter number of attempts to simulate: ");
        int n = sc.nextInt();
        String[] attempts = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter attempt " + (i + 1) + ": ");
            attempts[i] = sc.next();
        }
        atmPinRetry(correctPin, attempts);
        sc.close();
    }
}