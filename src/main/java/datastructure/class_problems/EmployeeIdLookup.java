import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeIdLookup {
    static Map<String, String> buildLookup(String[][] records) {
        Map<String, String> lookup = new HashMap<>();
        for (String[] record : records) {
            lookup.put(record[0], record[1]);
        }
        return lookup;
    }

    static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of records: ");
        int n = sc.nextInt();
        String[][] records = new String[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee ID " + (i + 1) + ": ");
            records[i][0] = sc.next();
            System.out.print("Enter department " + (i + 1) + ": ");
            records[i][1] = sc.next();
        }
        Map<String, String> lookup = buildLookup(records);
        System.out.print("Enter number of lookups: ");
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            System.out.print("Enter employee ID to look up: ");
            System.out.println(getDepartment(lookup, sc.next()));
        }
        sc.close();
    }
}
