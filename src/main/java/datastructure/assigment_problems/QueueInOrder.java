import java.util.Scanner;

public class QueueInOrder {
    static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students in queue: ");
        int n = sc.nextInt();
        int[] tokens = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter token " + (i + 1) + ": ");
            tokens[i] = sc.nextInt();
        }
        System.out.println(firstBreak(tokens));
        sc.close();
    }
}
