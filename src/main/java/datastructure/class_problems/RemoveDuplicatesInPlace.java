import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicatesInPlace {
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + " (sorted ascending): ");
            nums[i] = sc.nextInt();
        }
        int k = removeDuplicates(nums);
        System.out.println("length = " + k);
        System.out.println("nums[0.." + (k - 1) + "] = " + Arrays.toString(Arrays.copyOf(nums, k)));
        sc.close();
    }
}
