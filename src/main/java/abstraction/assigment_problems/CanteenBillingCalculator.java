import java.util.*;

public class CanteenBillingCalculator {
    abstract static class Customer {
        double amount;
        Customer(double amount) { this.amount = amount; }
        abstract double calculateFinalAmount();
        abstract String getType();
    }

    static class Student extends Customer {
        Student(double amount) { super(amount); }
        double calculateFinalAmount() { return amount * 0.90; }
        String getType() { return "STUDENT"; }
    }

    static class Staff extends Customer {
        Staff(double amount) { super(amount); }
        double calculateFinalAmount() { return amount * 0.95; }
        String getType() { return "STAFF"; }
    }

    static class Guest extends Customer {
        Guest(double amount) { super(amount); }
        double calculateFinalAmount() { return amount + 10; }
        String getType() { return "GUEST"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        List<Customer> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);
            Customer c;
            switch (type) {
                case "STUDENT": c = new Student(amount); break;
                case "STAFF": c = new Staff(amount); break;
                default: c = new Guest(amount);
            }
            bills.add(c);
        }

        for (Customer c : bills) {
            double finalAmt = c.calculateFinalAmount();
            total += finalAmt;
            System.out.printf("%s: %.2f%n", c.getType(), finalAmt);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
