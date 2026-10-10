import java.util.Scanner;

public class StudentResultCard {
    static class Student {
        String name;
        int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double calculateAverage() {
            int sum = 0;
            for (int m : marks) {
                sum += m;
            }
            return (double) sum / marks.length;
        }

        String getGrade() {
            double avg = calculateAverage();
            if (avg >= 90) return "A";
            else if (avg >= 75) return "B";
            else if (avg >= 60) return "C";
            else if (avg >= 40) return "D";
            else return "F";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.next();
        int[] marks = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter mark " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        Student s = new Student(name, marks);
        System.out.printf("%s: Average %.1f, Grade %s%n", s.name.toUpperCase(), s.calculateAverage(), s.getGrade());
        sc.close();
    }
}
