import java.util.Scanner;

public class CampusStaffSalary {
    static class Staff {
        String name;
        double baseSalary;

        Staff(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }

        double getBonus() {
            return 0;
        }

        String getType() {
            return "Staff";
        }
    }

    static class Teacher extends Staff {
        Teacher(String name, double baseSalary) {
            super(name, baseSalary);
        }

        double getBonus() {
            return 5000;
        }

        String getType() {
            return "Teacher";
        }
    }

    static class LabAssistant extends Staff {
        LabAssistant(String name, double baseSalary) {
            super(name, baseSalary);
        }

        double getBonus() {
            return 2000;
        }

        String getType() {
            return "LabAssistant";
        }
    }

    static String fmt(double v) {
        return v == Math.floor(v) ? String.format("%.1f", v) : String.valueOf(v);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of staff: ");
        int n = sc.nextInt();
        Staff[] staff = new Staff[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter type (Teacher/LabAssistant/Staff), name and base salary of person " + (i + 1) + ": ");
            String type = sc.next();
            String name = sc.next();
            double base = sc.nextDouble();
            if (type.equalsIgnoreCase("Teacher")) {
                staff[i] = new Teacher(name, base);
            } else if (type.equalsIgnoreCase("LabAssistant")) {
                staff[i] = new LabAssistant(name, base);
            } else {
                staff[i] = new Staff(name, base);
            }
        }

        double grandTotal = 0;
        for (Staff s : staff) {
            double total = s.baseSalary + s.getBonus();
            grandTotal += total;
            System.out.println(s.name + " (" + s.getType() + "): base " + fmt(s.baseSalary)
                    + ", bonus " + fmt(s.getBonus()) + ", total " + fmt(total));
        }
        System.out.println("Grand Total Salary: " + fmt(grandTotal));
        sc.close();
    }
}
