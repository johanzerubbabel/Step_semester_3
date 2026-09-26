import java.util.*;

public class PaymentFeeCalculator {
    abstract static class Payment {
        protected double amount;
        Payment(double amount) { this.amount = amount; }
        abstract double calculateFinalAmount();
        abstract String getType();
    }

    static class CardPayment extends Payment {
        CardPayment(double amount) { super(amount); }
        double calculateFinalAmount() { return amount * 1.02; }
        String getType() { return "CARD"; }
    }

    static class WalletPayment extends Payment {
        WalletPayment(double amount) { super(amount); }
        double calculateFinalAmount() { return amount * 1.01; }
        String getType() { return "WALLET"; }
    }

    static class BankTransferPayment extends Payment {
        BankTransferPayment(double amount) { super(amount); }
        double calculateFinalAmount() { return amount; }
        String getType() { return "BANKTRANSFER"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        List<Payment> payments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);
            Payment p;
            switch (type) {
                case "CARD": p = new CardPayment(amount); break;
                case "WALLET": p = new WalletPayment(amount); break;
                default: p = new BankTransferPayment(amount);
            }
            payments.add(p);
        }

        for (Payment p : payments) {
            double finalAmt = p.calculateFinalAmount();
            total += finalAmt;
            System.out.printf("%s: %.2f%n", p.getType(), finalAmt);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
