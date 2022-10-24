import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static messageSystem messageSys = new messageSystem();

    public static void main(String[] args) throws IOException {
        boolean running = true;
        do {
            String end = "=".repeat(50);
            String head = "=".repeat(end.length() - 24);
            String div = "-".repeat(50);
            System.out.println("Command |======| Usages "+head);
            System.out.println("new            | New message.");
            System.out.println("view           | View current messages.");
            System.out.println("removeLast     | Remove last message.");
            System.out.println("send           | Send all messages to inbox below.");
            System.out.println(div);
            System.out.println("inbox          | View sent message.");
            System.out.println("clearInbox     | Clear all inboxes.");
            System.out.println("clearLastInbox | Clear the latest inbox.");
            System.out.println("exit           | Exit.");
            System.out.println(end);
            System.out.print("Enter option to continue: ");

            String key = scanner.next();
            scanner.nextLine();

            switch (key) {
                case "exit" -> running = false;
                case "new" -> newMessage();
                case "view" -> viewMessage();
                case "removeLast" -> removeLastMessage();
                case "send" -> sendMessage();
                case "inbox" -> checkInbox();
                default -> System.out.println("Invalid input, please try again.");
            }
        } while (running);
        scanner.close();
    }

    private static void checkInbox() {

    }

    private static void sendMessage() {
        messageSys.sendAllMessage();
        enterToContinue();
    }

    private static void removeLastMessage() {
        if (messageSys.removePreview()) {
            System.out.println("Confirm deletion of last message? (y/n).");
            String key = scanner.next();
            scanner.nextLine();
            if (key.equals("y")) {
                messageSys.removeLastMessageStack();
            } else {
                System.out.println("Delete cancelled.");
            }
        }
        enterToContinue();
    }

    public static void newMessage() {
        System.out.print("new message: ");
        String message = scanner.nextLine();
        messageSys.newMessageStack(message);
        enterToContinue();
    }


    public static void viewMessage() {
        messageSys.viewMessageStack();
        enterToContinue();
    }

    public static void enterToContinue() {
        try {
            System.out.println("\nPress enter to continue.");
            System.in.read();   //wait for user enter to continue
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}