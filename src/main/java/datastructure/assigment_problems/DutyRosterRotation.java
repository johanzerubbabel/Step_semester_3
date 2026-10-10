import java.util.Arrays;
import java.util.Scanner;

public class DutyRosterRotation {
    // Complexity: Time O(n), Space O(n) for the new array.
    // Rotating one place at a time, k times, costs O(n * k). With k up to 10^9
    // that is far too many steps. k % n removes the full turns, and each name
    // is placed straight into its final spot in one pass.
    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n;
        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.next();
        }
        System.out.print("Enter k: ");
        int k = sc.nextInt();
        System.out.println(Arrays.toString(rotateRoster(names, k)));
        sc.close();
    }
}
