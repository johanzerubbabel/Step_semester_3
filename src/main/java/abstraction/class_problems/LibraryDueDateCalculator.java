import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class LibraryDueDateCalculator {
    abstract static class LibraryItem {
        String title;
        LibraryItem(String title) { this.title = title; }
        abstract int getBorrowDays();
    }

    static class Book extends LibraryItem {
        Book(String title) { super(title); }
        int getBorrowDays() { return 14; }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title) { super(title); }
        int getBorrowDays() { return 7; }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) { super(title); }
        int getBorrowDays() { return 3; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] split = line.split(" ", 2);
            String type = split[0];
            String title = split[1].replaceAll("^\"|\"$", "");

            LibraryItem item;
            switch (type) {
                case "BOOK": item = new Book(title); break;
                case "DVD": item = new Dvd(title); break;
                default: item = new Magazine(title);
            }
            LocalDate dueDate = currentDate.plusDays(item.getBorrowDays());
            System.out.println(item.title + ": " + dueDate.format(fmt));
        }
        sc.close();
    }
}
