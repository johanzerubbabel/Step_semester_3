import java.util.Scanner;

public class ExamScoreBandCounter {
    static int firstAtLeast(int[] scores, int target) {
        int lo = 0, hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    static int firstGreaterThan(int[] scores, int target) {
        int lo = 0, hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        return firstGreaterThan(scores, high) - firstAtLeast(scores, low);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of scores: ");
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter score " + (i + 1) + " (ascending order): ");
            scores[i] = sc.nextInt();
        }
        System.out.print("Enter low: ");
        int low = sc.nextInt();
        System.out.print("Enter high: ");
        int high = sc.nextInt();
        System.out.println(countInBand(scores, low, high));
        sc.close();
    }
}
