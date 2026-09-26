import java.util.*;

public class FestivalBonusCalculator {
    abstract static class Employee {
        String name;
        double salary;
        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }
        abstract double calculateBonus();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String name, double salary) { super(name, salary); }
        double calculateBonus() { return salary * 0.10; }
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String name, double salary) { super(name, salary); }
        double calculateBonus() { return salary * 0.05; }
    }

    static class Intern extends Employee {
        Intern(String name, double salary) { super(name, salary); }
        double calculateBonus() { return 2000.0; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);
            Employee e;
            switch (type) {
                case "FULLTIME": e = new FullTimeEmployee(name, salary); break;
                case "PARTTIME": e = new PartTimeEmployee(name, salary); break;
                default: e = new Intern(name, salary);
            }
            employees.add(e);
        }

        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            total += bonus;
            System.out.printf("%s: %.2f%n", e.name, bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}
