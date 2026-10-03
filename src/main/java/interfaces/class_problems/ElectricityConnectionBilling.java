import java.util.*;

public class ElectricityConnectionBilling {
    abstract static class Connection {
        int units;
        Connection(int units) { this.units = units; }
        abstract double calculateBill();
        abstract String getType();
    }

    static class Home extends Connection {
        Home(int units) { super(units); }
        double calculateBill() {
            if (units <= 100) return 5.0 * units;
            return 100 * 5.0 + (units - 100) * 7.0;
        }
        String getType() { return "HOME"; }
    }

    static class Shop extends Connection {
        Shop(int units) { super(units); }
        double calculateBill() { return 8.0 * units + 100; }
        String getType() { return "SHOP"; }
    }

    static class Factory extends Connection {
        Factory(int units) { super(units); }
        double calculateBill() { return Math.max(6.0 * units, 1000.0); }
        String getType() { return "FACTORY"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        List<Connection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);
            Connection c;
            switch (type) {
                case "HOME": c = new Home(units); break;
                case "SHOP": c = new Shop(units); break;
                default: c = new Factory(units);
            }
            connections.add(c);
        }

        for (Connection c : connections) {
            double bill = c.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", c.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
