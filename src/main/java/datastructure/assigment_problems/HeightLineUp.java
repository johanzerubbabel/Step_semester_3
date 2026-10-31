import java.util.Arrays;
import java.util.Scanner;

public class HeightLineUp {
    static void lineUp(int[] heights) {
        int n = heights.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(heights));
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter height " + (i + 1) + ": ");
            heights[i] = sc.nextInt();
        }
        lineUp(heights);
        sc.close();
    }
}
