import java.util.*;

public class CollegeFeeCounter {
    interface BusUser {
        double getTransportFee();
    }

    abstract static class Student {
        String name;
        Student(String name) { this.name = name; }
        abstract double getTuition();
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) { super(name); }
        double getTuition() { return 40000; }
        public double getTransportFee() { return 12000; }
    }

    static class Hosteller extends Student {
        Hosteller(String name) { super(name); }
        double getTuition() { return 40000 + 60000; }
    }

    static class ScholarStudent extends Student implements BusUser {
        ScholarStudent(String name) { super(name); }
        double getTuition() { return 20000; }
        public double getTransportFee() { return 12000; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            Student s;
            switch (type) {
                case "DAY_SCHOLAR": s = new DayScholar(name); break;
                case "HOSTELLER": s = new Hosteller(name); break;
                default: s = new ScholarStudent(name);
            }
            students.add(s);
        }

        for (Student s : students) {
            double fee = s.getTuition();
            if (s instanceof BusUser) {
                fee += ((BusUser) s).getTransportFee();
            }
            total += fee;
            System.out.printf("%s: %.2f%n", s.name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
