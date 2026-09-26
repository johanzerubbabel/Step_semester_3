import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StreamingRenewalCalculator {
    abstract static class Plan {
        String name;
        LocalDate startDate;
        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }
        abstract int getValidityDays();
    }

    static class BasicPlan extends Plan {
        BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
        int getValidityDays() { return 30; }
    }

    static class StandardPlan extends Plan {
        StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
        int getValidityDays() { return 90; }
    }

    static class PremiumPlan extends Plan {
        PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
        int getValidityDays() { return 365; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Plan> plans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2], fmt);
            Plan p;
            switch (type) {
                case "BASIC": p = new BasicPlan(name, startDate); break;
                case "STANDARD": p = new StandardPlan(name, startDate); break;
                default: p = new PremiumPlan(name, startDate);
            }
            plans.add(p);
        }

        for (Plan p : plans) {
            LocalDate renewalDate = p.startDate.plusDays(p.getValidityDays());
            System.out.println(p.name + ": " + renewalDate.format(fmt));
        }
        sc.close();
    }
}
