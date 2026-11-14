import java.util.Scanner;

public class CancelBooking {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node removeFirst(Node head, String booking) {
        if (head == null) {
            System.out.println(booking + " not found");
            return head;
        }
        if (head.data.equals(booking)) {
            return head.next;
        }
        Node prev = head;
        while (prev.next != null && !prev.next.data.equals(booking)) {
            prev = prev.next;
        }
        if (prev.next == null) {
            System.out.println(booking + " not found");
        } else {
            prev.next = prev.next.next;
        }
        return head;
    }

    static void printChain(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
        }
        sb.append("null");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of bookings (0 if none): ");
        int n = Integer.parseInt(sc.nextLine().trim());
        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter booking number " + (i + 1) + ": ");
            Node node = new Node(sc.nextLine().trim());
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        System.out.print("Enter booking to cancel: ");
        String booking = sc.nextLine().trim();
        head = removeFirst(head, booking);
        printChain(head);
        sc.close();
    }
}
