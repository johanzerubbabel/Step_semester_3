package controlflow.assigment_problems;
import java.util.Scanner;

public class MultiplicationTableGenerator {
    static void generateFirstValidTable(int[] candidates) {
        for (int candidate : candidates) {
            if (candidate < 1) {
                System.out.println("Skipping invalid number: " + candidate);
                continue;
            }
            for (int j = 1; j <= 10; j++) {
                System.out.println(candidate + " x " + j + " = " + (candidate * j));
            }
            break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter candidate " + (i + 1) + ": ");
            candidates[i] = sc.nextInt();
        }
        generateFirstValidTable(candidates);
        sc.close();
    }
}