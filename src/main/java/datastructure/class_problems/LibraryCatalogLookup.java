import java.util.Scanner;

public class LibraryCatalogLookup {
    static String findBook(String[][] catalog, String targetIsbn) {
        int low = 0, high = catalog.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = catalog[mid][0].compareTo(targetIsbn);
            if (cmp == 0) {
                return catalog[mid][1];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        String[][] catalog = new String[n][2];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter ISBN " + (i + 1) + " (sorted ascending): ");
            catalog[i][0] = sc.nextLine().trim();
            System.out.print("Enter title " + (i + 1) + ": ");
            catalog[i][1] = sc.nextLine().trim();
        }
        System.out.print("Enter target ISBN: ");
        String target = sc.nextLine().trim();
        System.out.println(findBook(catalog, target));
        sc.close();
    }
}
