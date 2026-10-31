import java.util.Arrays;
import java.util.Scanner;

public class PrizeTable {
    static int prizeTable(int[] marks) {
        int swaps = 0;
        for (int i = 0; i < marks.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of marks: ");
        int n = sc.nextInt();
        int[] marks = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter mark " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        int swaps = prizeTable(marks);
        System.out.println(Arrays.toString(marks) + "    swaps = " + swaps);
        sc.close();
    }
}
