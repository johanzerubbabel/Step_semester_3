import java.util.Scanner;

public class PlateStack {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    void push(String plate) {
        Node node = new Node(plate);
        node.next = head;
        head = node;
        size++;
    }

    String pop() {
        if (head == null) {
            return null;
        }
        String plate = head.data;
        head = head.next;
        size--;
        return plate;
    }

    String peek() {
        return head == null ? null : head.data;
    }

    boolean isEmpty() {
        return head == null;
    }

    int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PlateStack stack = new PlateStack();
        System.out.print("Enter number of operations: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            System.out.print("Enter operation (push <plate>, pop, peek, isEmpty): ");
            String line = sc.nextLine().replace("(", " ").replace(")", " ").trim();
            String[] parts = line.split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String arg = parts.length > 1 ? parts[1].trim() : "";
            switch (command) {
                case "push":
                    stack.push(arg);
                    System.out.println("push " + arg + " -> top " + stack.peek() + ", size " + stack.getSize());
                    break;
                case "pop": {
                    String plate = stack.pop();
                    if (plate == null) {
                        System.out.println("pop -> stack is empty");
                    } else {
                        System.out.println("pop -> " + plate + ", size " + stack.getSize());
                    }
                    break;
                }
                case "peek": {
                    String plate = stack.peek();
                    if (plate == null) {
                        System.out.println("peek -> stack is empty");
                    } else {
                        System.out.println("peek -> " + plate);
                    }
                    break;
                }
                case "isempty":
                    System.out.println("isEmpty -> " + stack.isEmpty());
                    break;
                default:
                    System.out.println("invalid operation: " + command);
            }
        }
        sc.close();
    }
}
