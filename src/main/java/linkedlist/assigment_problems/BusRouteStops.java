import java.util.Scanner;

public class BusRouteStops {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node build(String[] stops) {
        Node head = null, tail = null;
        for (String stop : stops) {
            Node node = new Node(stop);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    static void printRoute(Node head) {
        int count = 0;
        Node last = null;
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data).append(" -> ");
            count++;
            last = cur;
        }
        sb.append("null");
        System.out.println(sb);
        if (head != null) {
            System.out.println("Stops: " + count + ", First: " + head.data + ", Last: " + last.data);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stops: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        String[] stops = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter stop " + (i + 1) + ": ");
            stops[i] = sc.nextLine().trim();
        }
        printRoute(build(stops));
        sc.close();
    }
}
