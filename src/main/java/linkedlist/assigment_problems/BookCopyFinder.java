import java.util.Scanner;

public class BookCopyFinder {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    static String find(Node head, String id) {
        int position = 0, copies = 0, firstPosition = -1;
        for (Node cur = head; cur != null; cur = cur.next) {
            position++;
            if (cur.data.equals(id)) {
                copies++;
                if (firstPosition == -1) {
                    firstPosition = position;
                }
            }
        }
        if (copies == 0) {
            return id + " not found";
        }
        return id + " first at position " + firstPosition + ", copies: " + copies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of books on the trolley: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        Node head = null, tail = null;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter book ID " + (i + 1) + ": ");
            Node node = new Node(sc.nextLine().trim());
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        System.out.print("Enter book ID to find: ");
        String id = sc.nextLine().trim();
        System.out.println(find(head, id));
        sc.close();
    }
}
