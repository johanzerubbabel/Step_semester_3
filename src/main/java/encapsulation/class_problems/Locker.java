public class Locker {
    private final int lockerNumber;
    private String code;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    boolean changeCode(String currentCode, String newCode) {
        if (currentCode.equals(code)) {
            code = newCode;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        boolean result1 = l.changeCode("1234", "5678");
        System.out.println(result1 ? "success" : "rejected");
        boolean result2 = l.changeCode("0000", "9999");
        System.out.println(result2 ? "success" : "rejected, code is still 5678");
    }
}
