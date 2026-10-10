import java.util.Scanner;

public class ExamScoreBandCounter {
    // Complexity:
    //   Linear scan      -> Time O(n), Space O(1)
    //   Binary search    -> Time O(log n), Space O(1)
    // Duplicates at the edges: a normal binary search stops at ANY match, which could be
    // in the middle of a run of equal scores. So after a match we keep searching
    // (hi = mid) to land on the FIRST position of the run. Using ">= low" and "> high"
    // makes sure every duplicate at both edges of the band is counted.

    // first index whose score >= target
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

    // first index whose score > target
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
