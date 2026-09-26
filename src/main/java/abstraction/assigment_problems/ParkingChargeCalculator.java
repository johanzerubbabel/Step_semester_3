import java.util.*;

public class ParkingChargeCalculator {
    abstract static class Vehicle {
        int hours;
        Vehicle(int hours) { this.hours = hours; }
        abstract double calculateCharge();
        abstract String getType();
    }

    static class Bike extends Vehicle {
        Bike(int hours) { super(hours); }
        double calculateCharge() { return 10.0 * hours; }
        String getType() { return "BIKE"; }
    }

    static class Car extends Vehicle {
        Car(int hours) { super(hours); }
        double calculateCharge() { return 30.0 + 20.0 * (hours - 1); }
        String getType() { return "CAR"; }
    }

    static class Truck extends Vehicle {
        Truck(int hours) { super(hours); }
        double calculateCharge() { return Math.max(50.0 * hours, 100.0); }
        String getType() { return "TRUCK"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);
            Vehicle v;
            switch (type) {
                case "BIKE": v = new Bike(hours); break;
                case "CAR": v = new Car(hours); break;
                default: v = new Truck(hours);
            }
            vehicles.add(v);
        }

        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            total += charge;
            System.out.printf("%s: %.2f%n", v.getType(), charge);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
