import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static messageSystem messageSys = new messageSystem();

    public static void main(String[] args) throws IOException {
        boolean running = true;
        do {
            running = menu();
        } while (running);
        scanner.close();
        //Running thingy
    }

    public static boolean menu() {
        int barLength = 47;
        String end = "=".repeat(barLength);
        String head = "=".repeat(barLength - 24);
        String div = "-".repeat(barLength);
        System.out.println("Options |===| Usages " + head);
        System.out.println("new         | New message.");
        System.out.println("view        | View current messages.");
        System.out.println("removeLast  | Remove last message.");
        System.out.println("send        | Send all messages to inbox below.");
        System.out.println(div);
        System.out.println("inbox       | View sent message.");
        System.out.println("clearInbox  | Clear all inboxes.");
        System.out.println("clearLatest | Clear the latest inbox.");
        System.out.println("exit        | Exit.");
        System.out.println(end);
        System.out.print("Enter option to continue: ");

        String key = scanner.next();
        scanner.nextLine();

        switch (key) {
            case "exit" -> {
                return false;
            }
            case "new" -> newMessage();
            case "view" -> viewMessage();
            case "removeLast" -> removeLastMessage();
            case "send" -> sendMessage();
            case "inbox" -> checkInbox();
            case "clearInbox" -> clearInbox();
            case "clearLatest" -> clearLatestInbox();
            default -> System.out.println("Invalid input, please try again.");
        }
        return true;
    }

    private static void clearInbox() {
        messageSys.clearInbox();
    }

    private static void checkInbox() {
        messageSys.inbox();
        enterToContinue();
    }

    private static void sendMessage() {
        messageSys.sendAllMessage();
        enterToContinue();
    }

    private static void removeLastMessage() {
        if (messageSys.removeMessagePreview()) {
            System.out.println("Confirm deletion of latest message? (y/n).");
            String key = scanner.next();
            scanner.nextLine();
            if (key.equals("n")) {
                System.out.println("Delete cancelled.");
            } else if (key.equals("y")) {
                messageSys.removeLastMessageStack();
            }
        }
        enterToContinue();
    }

    private static void clearLatestInbox() {
        if (messageSys.removeInboxPreview()) {
            System.out.println("Confirm deletion of latest message? (y/n).");
            String key = scanner.next();
            scanner.nextLine();
            if (key.equals("n")) {
                System.out.println("Delete cancelled.");
            } else if (key.equals("y")) {
                messageSys.removeLastInboxStack();
            }
        }
    }

    public static void newMessage() {
        System.out.print("new message: ");
        String message = scanner.nextLine();
        if (messageSys.newMessageStack(message)) {
            System.out.println("There seems to be a problem while sending the message.");
        }
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