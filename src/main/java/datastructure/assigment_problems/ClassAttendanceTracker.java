import java.util.Scanner;

public class ClassAttendanceTracker {
    // Complexity: Time O(n), Space O(1).
    // Yes, both answers come from a single pass.
    static int[] attendanceSummary(int[] days) {
        int present = 0, streak = 0, longest = 0;
        for (int d : days) {
            if (d == 1) {
                present++;
                streak++;
                if (streak > longest) {
                    longest = streak;
                }
            } else {
                streak = 0;
            }
        }
        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter day " + (i + 1) + " (1 = present, 0 = absent): ");
            days[i] = sc.nextInt();
        }
        int[] result = attendanceSummary(days);
        System.out.println("Present: " + result[0] + ", Longest streak: " + result[1]);
        sc.close();
    }
}
