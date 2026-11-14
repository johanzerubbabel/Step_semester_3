import java.util.Scanner;

public class LateComersLine {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node addFirst(Node head, String name) {
        Node node = new Node(name);
        node.next = head;
        return node;
    }

    static Node addLast(Node head, String name) {
        Node node = new Node(name);
        if (head == null) {
            return node;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        return head;
    }

    static void printLine(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
        }
        sb.append("null");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students in the starting line (0 if empty): ");
        int n = Integer.parseInt(sc.nextLine().trim());
        Node head = null;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            head = addLast(head, sc.nextLine().trim());
        }
        System.out.print("Enter number of operations: ");
        int m = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < m; i++) {
            System.out.print("Enter operation (addFirst <name> or addLast <name>): ");
            String line = sc.nextLine().replace("(", " ").replace(")", " ").trim();
            String[] parts = line.split("\\s+", 2);
            String name = parts.length > 1 ? parts[1].trim() : "";
            if (parts[0].equalsIgnoreCase("addFirst")) {
                head = addFirst(head, name);
            } else if (parts[0].equalsIgnoreCase("addLast")) {
                head = addLast(head, name);
            } else {
                System.out.println("invalid operation: " + parts[0]);
            }
        }
        printLine(head);
        sc.close();
    }
}
