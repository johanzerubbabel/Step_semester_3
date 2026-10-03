import java.util.*;

public class TravelBookingCalculator {
    abstract static class Booking {
        double distanceKm;
        static final double BOOKING_FEE = 50;

        Booking(double distanceKm) { this.distanceKm = distanceKm; }
        abstract double calculateBaseFare();
        abstract String getMode();

        double calculateTotal() { return calculateBaseFare() + BOOKING_FEE; }
    }

    static class Bus extends Booking {
        Bus(double distanceKm) { super(distanceKm); }
        double calculateBaseFare() { return 2.0 * distanceKm; }
        String getMode() { return "BUS"; }
    }

    static class Train extends Booking {
        Train(double distanceKm) { super(distanceKm); }
        double calculateBaseFare() { return 1.5 * distanceKm; }
        String getMode() { return "TRAIN"; }
    }

    static class Flight extends Booking {
        Flight(double distanceKm) { super(distanceKm); }
        double calculateBaseFare() { return 2500 + 4.0 * distanceKm; }
        String getMode() { return "FLIGHT"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Booking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String mode = parts[0];
            double distance = Double.parseDouble(parts[1]);
            Booking b;
            switch (mode) {
                case "BUS": b = new Bus(distance); break;
                case "TRAIN": b = new Train(distance); break;
                default: b = new Flight(distance);
            }
            bookings.add(b);
        }

        for (Booking b : bookings) {
            System.out.printf("%s: %.2f%n", b.getMode(), b.calculateTotal());
        }
        sc.close();
    }
}
