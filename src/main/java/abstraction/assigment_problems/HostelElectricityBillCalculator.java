import java.util.*;

public class HostelElectricityBillCalculator {
    abstract static class Room {
        int units;
        Room(int units) { this.units = units; }
        abstract double calculateBill();
        abstract String getType();
    }

    static class SingleRoom extends Room {
        SingleRoom(int units) { super(units); }
        double calculateBill() { return 8.0 * units; }
        String getType() { return "SINGLE"; }
    }

    static class SharedRoom extends Room {
        int occupants;
        SharedRoom(int units, int occupants) {
            super(units);
            this.occupants = occupants;
        }
        double calculateBill() { return (6.0 * units) / occupants; }
        String getType() { return "SHARED"; }
    }

    static class AcRoom extends Room {
        AcRoom(int units) { super(units); }
        double calculateBill() { return 10.0 * units + 200; }
        String getType() { return "AC"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);
            Room r;
            if (type.equals("SHARED")) {
                int occupants = Integer.parseInt(parts[2]);
                r = new SharedRoom(units, occupants);
            } else if (type.equals("AC")) {
                r = new AcRoom(units);
            } else {
                r = new SingleRoom(units);
            }
            rooms.add(r);
        }

        for (Room r : rooms) {
            double bill = r.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", r.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
