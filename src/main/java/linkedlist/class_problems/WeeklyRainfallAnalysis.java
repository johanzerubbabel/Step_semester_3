import java.util.Scanner;

public class WeeklyRainfallAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] rainfall = new double[7];
        for (int i = 0; i < 7; i++) {
            System.out.print("Enter rainfall (mm) for day " + (i + 1) + ": ");
            rainfall[i] = sc.nextDouble();
        }

        double total = 0;
        int wettest = 0, dryDays = 0;
        StringBuilder readings = new StringBuilder("Rainfall (mm):");
        for (int i = 0; i < 7; i++) {
            readings.append(" ").append(rainfall[i]);
            total += rainfall[i];
            if (rainfall[i] > rainfall[wettest]) {
                wettest = i;
            }
            if (rainfall[i] == 0) {
                dryDays++;
            }
        }
        double average = total / 7;

        System.out.println(readings);
        System.out.println("Total Rainfall: " + Math.round(total * 100) / 100.0 + " mm");
        System.out.printf("Average Rainfall: %.2f mm%n", average);
        System.out.println("Wettest Day: Day " + (wettest + 1) + " (" + rainfall[wettest] + " mm)");
        System.out.println("Total Dry Days: " + dryDays);
        sc.close();
    }
}
