import java.util.*;

public class ParcelShippingDesk {
    interface Insurable {
        double calculateInsurance(double declaredValue);
    }

    abstract static class Parcel {
        double weightKg, declaredValue;
        Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }
        abstract double calculateCharge();
        abstract String getType();
    }

    static class StandardParcel extends Parcel {
        StandardParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
        double calculateCharge() { return 40 + 10 * weightKg; }
        String getType() { return "STANDARD"; }
    }

    static class ExpressParcel extends Parcel implements Insurable {
        ExpressParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
        double calculateCharge() { return 80 + 15 * weightKg; }
        public double calculateInsurance(double declaredValue) { return 0.02 * declaredValue; }
        String getType() { return "EXPRESS"; }
    }

    static class FragileParcel extends Parcel implements Insurable {
        FragileParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
        double calculateCharge() { return (40 + 10 * weightKg) + 50; }
        public double calculateInsurance(double declaredValue) { return 0.02 * declaredValue; }
        String getType() { return "FRAGILE"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double grandTotal = 0;
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double declaredValue = Double.parseDouble(parts[2]);
            Parcel p;
            switch (type) {
                case "EXPRESS": p = new ExpressParcel(weight, declaredValue); break;
                case "FRAGILE": p = new FragileParcel(weight, declaredValue); break;
                default: p = new StandardParcel(weight, declaredValue);
            }
            parcels.add(p);
        }

        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = (p instanceof Insurable) ? ((Insurable) p).calculateInsurance(p.declaredValue) : 0;
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", p.getType(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
