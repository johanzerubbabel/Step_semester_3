import java.util.Arrays;
import java.util.Scanner;

public class DiceThrowTally {
    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int roll : rolls) {
            count[roll]++;
        }
        StringBuilder sb = new StringBuilder("Counts:");
        for (int v = 1; v <= 6; v++) {
            sb.append(" ").append(v).append(":").append(count[v]);
        }
        System.out.println(sb);

        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[index++] = v;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of throws: ");
        int n = sc.nextInt();
        int[] rolls = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter result of throw " + (i + 1) + " (1 to 6): ");
            rolls[i] = sc.nextInt();
        }
        int[] sorted = diceSort(rolls);
        System.out.println("Sorted: " + Arrays.toString(sorted));
        sc.close();
    }
}
