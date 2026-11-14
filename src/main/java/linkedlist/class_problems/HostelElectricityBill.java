import java.util.Scanner;

public class HostelElectricityBill {
    static long calculateBill(long units) {
        long bill;
        if (units <= 100) {
            bill = units * 3;
        } else if (units <= 200) {
            bill = 100 * 3 + (units - 100) * 5;
        } else {
            bill = 100 * 3 + 100 * 5 + (units - 200) * 8;
        }
        return bill + 50;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();
        int billed = 0;
        long total = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter room number and reading of room " + (i + 1) + ": ");
            String room = sc.next();
            long units = sc.nextLong();
            if (units < 0) {
                System.out.println(room + ": invalid reading");
                continue;
            }
            long bill = calculateBill(units);
            billed++;
            total += bill;
            System.out.println(room + ": " + units + " units, bill " + bill);
        }
        System.out.println("Rooms billed " + billed + ", total " + total);
        sc.close();
    }
}
