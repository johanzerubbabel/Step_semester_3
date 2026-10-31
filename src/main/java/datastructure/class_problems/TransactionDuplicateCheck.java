import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TransactionDuplicateCheck {
    static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of transaction IDs: ");
        int n = sc.nextInt();
        String[] ids = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter transaction ID " + (i + 1) + ": ");
            ids[i] = sc.next();
        }
        System.out.println(hasDuplicate(ids));
        sc.close();
    }
}
