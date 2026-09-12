public class Employee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Ana", 50000);
        Employee e2 = new Employee("Ben", 60000);
        Employee e3 = new Employee("Cara", 55000);
        System.out.println(employeeCount + " Employee objects created");
        Employee.printCompanyInfo();
    }
}
