import java.util.*;

public class DeliveryFeeCalculator {
    abstract static class Delivery {
        double weight, distance;
        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }
        abstract double calculateFee();
        abstract String getType();
    }

    static class StandardDelivery extends Delivery {
        StandardDelivery(double weight, double distance) { super(weight, distance); }
        double calculateFee() { return 5 + 0.50 * weight + 0.10 * distance; }
        String getType() { return "STANDARD"; }
    }

    static class ExpressDelivery extends Delivery {
        ExpressDelivery(double weight, double distance) { super(weight, distance); }
        double calculateFee() { return 15 + 1.00 * weight + 0.20 * distance; }
        String getType() { return "EXPRESS"; }
    }

    static class InternationalDelivery extends Delivery {
        double customsFee;
        InternationalDelivery(double weight, double distance, double customsFee) {
            super(weight, distance);
            this.customsFee = customsFee;
        }
        double calculateFee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
        String getType() { return "INTERNATIONAL"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        List<Delivery> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);
            Delivery d;
            if (type.equals("INTERNATIONAL")) {
                double customsFee = Double.parseDouble(parts[3]);
                d = new InternationalDelivery(weight, distance, customsFee);
            } else if (type.equals("EXPRESS")) {
                d = new ExpressDelivery(weight, distance);
            } else {
                d = new StandardDelivery(weight, distance);
            }
            deliveries.add(d);
        }

        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", d.getType(), fee);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
