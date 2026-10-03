import java.util.*;

public class MovieTicketCounter {
    abstract static class Seat {
        static final double CONVENIENCE_FEE = 20;

        abstract double getPricePerTicket();
        abstract String getType();

        double calculateAmount(int count) {
            return (getPricePerTicket() + CONVENIENCE_FEE) * count;
        }
    }

    static class RegularSeat extends Seat {
        double getPricePerTicket() { return 150; }
        String getType() { return "REGULAR"; }
    }

    static class PremiumSeat extends Seat {
        double getPricePerTicket() { return 250; }
        String getType() { return "PREMIUM"; }
    }

    static class ReclinerSeat extends Seat {
        double getPricePerTicket() { return 400; }
        String getType() { return "RECLINER"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        List<Seat> seats = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int count = Integer.parseInt(parts[1]);
            Seat s;
            switch (type) {
                case "REGULAR": s = new RegularSeat(); break;
                case "PREMIUM": s = new PremiumSeat(); break;
                default: s = new ReclinerSeat();
            }
            seats.add(s);
            counts.add(count);
        }

        for (int i = 0; i < seats.size(); i++) {
            double amount = seats.get(i).calculateAmount(counts.get(i));
            total += amount;
            System.out.printf("%s: %.2f%n", seats.get(i).getType(), amount);
        }
        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
