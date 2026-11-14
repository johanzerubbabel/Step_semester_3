import java.util.Scanner;

public class LibraryReturnDesk {
    static class PileStack {
        private String[] data = new String[3];
        private int top = -1;

        boolean push(String book) {
            if (top == data.length - 1) {
                return false;
            }
            data[++top] = book;
            return true;
        }

        String pop() {
            if (top == -1) {
                return null;
            }
            return data[top--];
        }
    }

    static class WaitingLine {
        private String[] data = new String[3];
        private int front = 0, rear = 0, size = 0;

        boolean enqueue(String name) {
            if (size == data.length) {
                return false;
            }
            data[rear] = name;
            rear = (rear + 1) % data.length;
            size++;
            return true;
        }

        String dequeue() {
            if (size == 0) {
                return null;
            }
            String name = data[front];
            front = (front + 1) % data.length;
            size--;
            return name;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PileStack pile = new PileStack();
        WaitingLine line = new WaitingLine();
        System.out.print("Enter number of commands: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            System.out.print("Enter command (RETURN <book>, SHELVE, WAIT <name>, SERVE): ");
            String[] parts = sc.nextLine().trim().split("\\s+", 2);
            String command = parts[0].toUpperCase();
            String arg = parts.length > 1 ? parts[1] : "";
            switch (command) {
                case "RETURN":
                    if (pile.push(arg)) {
                        System.out.println(arg + " placed on pile");
                    } else {
                        System.out.println(arg + " rejected: pile is full");
                    }
                    break;
                case "SHELVE": {
                    String book = pile.pop();
                    if (book == null) {
                        System.out.println("pile is empty");
                    } else {
                        System.out.println("shelved " + book);
                    }
                    break;
                }
                case "WAIT":
                    if (line.enqueue(arg)) {
                        System.out.println(arg + " joined the line");
                    } else {
                        System.out.println(arg + " rejected: line is full");
                    }
                    break;
                case "SERVE": {
                    String student = line.dequeue();
                    if (student == null) {
                        System.out.println("no one waiting");
                    } else {
                        System.out.println("served " + student);
                    }
                    break;
                }
                default:
                    System.out.println("invalid command: " + command);
            }
        }
        sc.close();
    }
}
