import java.util.*;

public class CityCabFareMeter {
    interface NightService {
        double applyNightSurcharge(double fare);
    }

    abstract static class Cab {
        abstract double getRatePerKm();
        abstract String getType();

        double calculateFare(double km) {
            double fare = km * getRatePerKm();
            return Math.max(fare, 100);
        }
    }

    static class MiniCab extends Cab {
        double getRatePerKm() { return 10; }
        String getType() { return "MINI"; }
    }

    static class SedanCab extends Cab implements NightService {
        double getRatePerKm() { return 14; }
        String getType() { return "SEDAN"; }
        public double applyNightSurcharge(double fare) { return fare * 1.2; }
    }

    static class SuvCab extends Cab implements NightService {
        double getRatePerKm() { return 18; }
        String getType() { return "SUV"; }
        public double applyNightSurcharge(double fare) { return fare * 1.2; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double km = Double.parseDouble(parts[1]);
            String time = parts[2];

            Cab cab;
            switch (type) {
                case "SEDAN": cab = new SedanCab(); break;
                case "SUV": cab = new SuvCab(); break;
                default: cab = new MiniCab();
            }

            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    double fare = ((NightService) cab).applyNightSurcharge(cab.calculateFare(km));
                    total += fare;
                    System.out.printf("%s: %.2f%n", cab.getType(), fare);
                } else {
                    System.out.println(cab.getType() + ": night service not available");
                }
            } else {
                double fare = cab.calculateFare(km);
                total += fare;
                System.out.printf("%s: %.2f%n", cab.getType(), fare);
            }
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
