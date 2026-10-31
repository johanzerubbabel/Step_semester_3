import java.util.Arrays;
import java.util.Scanner;

public class LibraryBookShelf {
    static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int key = books[i];
            int j = i - 1;
            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;
            System.out.println("After placing " + key + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        int[] books = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter book number " + (i + 1) + ": ");
            books[i] = sc.nextInt();
        }
        shelf(books);
        sc.close();
    }
}
