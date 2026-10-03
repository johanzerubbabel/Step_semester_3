import java.util.*;

public class HomeApplianceEnergyReport {
    interface SaverMode {
        double applySaverMode(double units);
    }

    abstract static class Appliance {
        abstract double getPowerWatts();
        abstract String getType();

        double calculateUnits(double hours) {
            return getPowerWatts() * hours / 1000.0;
        }
    }

    static class Fridge extends Appliance {
        double getPowerWatts() { return 150; }
        String getType() { return "FRIDGE"; }
    }

    static class Ac extends Appliance implements SaverMode {
        double getPowerWatts() { return 1500; }
        String getType() { return "AC"; }
        public double applySaverMode(double units) { return units * 0.75; }
    }

    static class Tv extends Appliance {
        double getPowerWatts() { return 100; }
        String getType() { return "TV"; }
    }

    static class Washer extends Appliance implements SaverMode {
        double getPowerWatts() { return 500; }
        String getType() { return "WASHER"; }
        public double applySaverMode(double units) { return units * 0.75; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverRequested = parts.length > 2 && parts[2].equals("SAVER");

            Appliance appliance;
            switch (type) {
                case "AC": appliance = new Ac(); break;
                case "TV": appliance = new Tv(); break;
                case "WASHER": appliance = new Washer(); break;
                default: appliance = new Fridge();
            }

            if (saverRequested && !(appliance instanceof SaverMode)) {
                System.out.println(appliance.getType() + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits(hours);
            if (saverRequested) {
                units = ((SaverMode) appliance).applySaverMode(units);
            }
            double cost = units * 8;
            totalCost += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.getType(), units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
