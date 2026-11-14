import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassReportCard {
    static class Student {
        private String name;
        private int mark1, mark2, mark3;

        Student(String name) {
            this.name = name;
        }

        boolean setMarks(int a, int b, int c) {
            if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) {
                return false;
            }
            mark1 = a;
            mark2 = b;
            mark3 = c;
            return true;
        }

        String getName() {
            return name;
        }

        int getTotal() {
            return mark1 + mark2 + mark3;
        }

        double getAverage() {
            return getTotal() / 3.0;
        }

        String getGrade() {
            double avg = getAverage();
            if (avg >= 80) return "A";
            else if (avg >= 70) return "B";
            else if (avg >= 60) return "C";
            else if (avg >= 40) return "D";
            else return "F";
        }

        public String toString() {
            return String.format("%s total=%d avg=%.2f grade=%s", name, getTotal(), getAverage(), getGrade());
        }
    }

    static int sortByTotal(Student[] students) {
        int n = students.length;
        int passes = 0;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getTotal() < students[j + 1].getTotal()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                    swapped = true;
                }
            }
            passes++;
            if (!swapped) {
                break;
            }
        }
        return passes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        List<Student> accepted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name and three marks of student " + (i + 1) + ": ");
            String name = sc.next();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            Student s = new Student(name);
            if (s.setMarks(a, b, c)) {
                accepted.add(s);
            } else {
                System.out.println(s.getName() + " skipped: marks must be 0 to 100");
            }
        }

        Student[] ranked = accepted.toArray(new Student[0]);
        int passes = sortByTotal(ranked);
        for (int i = 0; i < ranked.length; i++) {
            System.out.println((i + 1) + ". " + ranked[i]);
        }
        System.out.println("Sorted in " + passes + " passes");
        sc.close();
    }
}
