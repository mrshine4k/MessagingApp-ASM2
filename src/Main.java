import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        boolean running = true;
        do {
            String str = "=".repeat(25);
            System.out.println("\nEnter option to continue");
            System.out.println(str);
            System.out.println("new  | New message.");
            System.out.println("view | View current messages.");
            System.out.println("exit | Exit.");
            System.out.println(str);

            String key = scanner.next();
            scanner.nextLine();

            switch (key) {
                case "exit" -> running = false;
                case "new" -> newMessage();
                case "view" -> viewMessage();
                default -> System.out.println("Invalid input, please try again.");
            }
        } while (running);
    }

    public static void newMessage() {
        System.out.println("new message:");
        String message = scanner.nextLine();
        messageSystem.newMessageStack(message);
        enterToContinue();
    }

    public static void viewMessage() {
        messageSystem.viewMessageStack();
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