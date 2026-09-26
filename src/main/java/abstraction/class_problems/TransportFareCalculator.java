import java.util.*;

public class TransportFareCalculator {
    abstract static class Transport {
        double distance;
        Transport(double distance) { this.distance = distance; }
        abstract double calculateFare();
        abstract String getType();
    }

    static class Bus extends Transport {
        Bus(double distance) { super(distance); }
        double calculateFare() {
            double fare = 2 + 0.10 * distance;
            return Math.min(fare, 10);
        }
        String getType() { return "BUS"; }
    }

    static class Train extends Transport {
        Train(double distance) { super(distance); }
        double calculateFare() { return 3 + 0.15 * distance; }
        String getType() { return "TRAIN"; }
    }

    static class Metro extends Transport {
        double peakHourFactor;
        Metro(double distance, double peakHourFactor) {
            super(distance);
            this.peakHourFactor = peakHourFactor;
        }
        double calculateFare() { return (1.50 + 0.20 * distance) * peakHourFactor; }
        String getType() { return "METRO"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        List<Transport> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);
            Transport t;
            if (type.equals("METRO")) {
                double peakFactor = Double.parseDouble(parts[2]);
                t = new Metro(distance, peakFactor);
            } else if (type.equals("TRAIN")) {
                t = new Train(distance);
            } else {
                t = new Bus(distance);
            }
            journeys.add(t);
        }

        for (Transport t : journeys) {
            double fare = t.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", t.getType(), fare);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
