import java.util.Scanner;

public class PaymentProcessing {
    interface PaymentMode {
        double processPayment(double amount);
    }

    static class CashPayment implements PaymentMode {
        public double processPayment(double amount) {
            return amount;
        }
    }

    static class CardPayment implements PaymentMode {
        public double processPayment(double amount) {
            return amount + amount * 0.02;
        }
    }

    static class UpiPayment implements PaymentMode {
        public double processPayment(double amount) {
            return amount;
        }
    }

    static double round2(double v) {
        return Math.round(v * 100) / 100.0;
    }

    static String fmt(double v) {
        return v == Math.floor(v) ? String.format("%.1f", v) : String.valueOf(v);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of payments: ");
        int n = sc.nextInt();
        PaymentMode[] payments = new PaymentMode[n];
        String[] modes = new String[n];
        double[] amounts = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter mode (Cash/Card/UPI) and amount of payment " + (i + 1) + ": ");
            modes[i] = sc.next();
            amounts[i] = sc.nextDouble();
            if (modes[i].equalsIgnoreCase("Cash")) {
                payments[i] = new CashPayment();
            } else if (modes[i].equalsIgnoreCase("Card")) {
                payments[i] = new CardPayment();
            } else if (modes[i].equalsIgnoreCase("UPI")) {
                payments[i] = new UpiPayment();
            }
        }

        double total = 0;
        for (int i = 0; i < n; i++) {
            if (payments[i] == null) {
                System.out.println(modes[i] + ": invalid payment mode");
                continue;
            }
            double processed = payments[i].processPayment(amounts[i]);
            double fee = round2(processed - amounts[i]);
            processed = round2(processed);
            total += processed;
            System.out.println(modes[i] + ": amount " + fmt(amounts[i]) + ", fee " + fmt(fee)
                    + ", processed " + fmt(processed));
        }
        System.out.println("Total Amount Processed: " + fmt(round2(total)));
        sc.close();
    }
}
