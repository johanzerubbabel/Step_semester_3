public class PiggyBank {
    private final String id;
    private double savings;

    PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    void deposit(double amount) {
        savings += amount;
    }

    void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("Withdrawal rejected: insufficient savings");
        } else {
            savings -= amount;
        }
    }

    double getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("After deposit: " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("After withdraw: " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("After rejected withdraw: " + pb.getSavings());
    }
}
