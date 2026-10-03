import java.util.*;

public class GardenPlotAreaReport {
    abstract static class Plot {
        String owner;
        Plot(String owner) { this.owner = owner; }
        abstract double calculateArea();
        abstract String getShapeName();
    }

    static class Circle extends Plot {
        double radius;
        Circle(String owner, double radius) { super(owner); this.radius = radius; }
        double calculateArea() { return Math.PI * radius * radius; }
        String getShapeName() { return "CIRCLE"; }
    }

    static class Rectangle extends Plot {
        double length, width;
        Rectangle(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }
        double calculateArea() { return length * width; }
        String getShapeName() { return "RECTANGLE"; }
    }

    static class Triangle extends Plot {
        double base, height;
        Triangle(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }
        double calculateArea() { return 0.5 * base * height; }
        String getShapeName() { return "TRIANGLE"; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String shape = parts[0];
            String owner = parts[1];
            Plot p;
            switch (shape) {
                case "CIRCLE": p = new Circle(owner, Double.parseDouble(parts[2])); break;
                case "RECTANGLE": p = new Rectangle(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3])); break;
                default: p = new Triangle(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
            }
            plots.add(p);
        }

        for (Plot p : plots) {
            double area = p.calculateArea();
            total += area;
            System.out.printf("%s (%s): %.2f%n", p.owner, p.getShapeName(), area);
        }
        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}
