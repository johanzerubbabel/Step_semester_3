import java.util.Arrays;
import java.util.Scanner;

public class DutyRosterRotation {
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
