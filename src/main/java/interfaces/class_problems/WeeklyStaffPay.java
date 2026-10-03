import java.util.*;

public class WeeklyStaffPay {
    abstract static class Staff {
        String name;
        Staff(String name) { this.name = name; }
        abstract double calculatePay();
    }

    static class FullTimeStaff extends Staff {
        double weeklySalary;
        FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }
        double calculatePay() { return weeklySalary; }
    }

    static class HourlyStaff extends Staff {
        double hours, rate;
        HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }
        double calculatePay() {
            if (hours <= 40) return hours * rate;
            return 40 * rate + (hours - 40) * 1.5 * rate;
        }
    }

    static class Intern extends Staff {
        double stipend;
        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }
        double calculatePay() { return stipend; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        List<Staff> staffList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            Staff s;
            switch (type) {
                case "FULLTIME": s = new FullTimeStaff(name, Double.parseDouble(parts[2])); break;
                case "HOURLY": s = new HourlyStaff(name, Double.parseDouble(parts[2]), Double.parseDouble(parts[3])); break;
                default: s = new Intern(name, Double.parseDouble(parts[2]));
            }
            staffList.add(s);
        }

        for (Staff s : staffList) {
            double pay = s.calculatePay();
            total += pay;
            System.out.printf("%s: %.2f%n", s.name, pay);
        }
        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}
