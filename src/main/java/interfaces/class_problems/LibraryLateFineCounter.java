import java.util.*;

public class LibraryLateFineCounter {
    abstract static class LibraryItem {
        String title;
        int daysLate;
        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }
        abstract double calculateFine();
    }

    static class Book extends LibraryItem {
        Book(String title, int daysLate) { super(title, daysLate); }
        double calculateFine() { return 2.0 * daysLate; }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title, int daysLate) { super(title, daysLate); }
        double calculateFine() { return Math.min(5.0 * daysLate, 50.0); }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) { super(title, daysLate); }
        double calculateFine() { return 1.0 * daysLate; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String title = parts[1];
            int daysLate = Integer.parseInt(parts[2]);
            LibraryItem item;
            switch (type) {
                case "BOOK": item = new Book(title, daysLate); break;
                case "DVD": item = new Dvd(title, daysLate); break;
                default: item = new Magazine(title, daysLate);
            }
            items.add(item);
        }

        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            total += fine;
            System.out.printf("%s: %.2f%n", item.title, fine);
        }
        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
