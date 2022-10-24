import java.lang.reflect.Array;
import java.util.Arrays;

public class messageSystem {
    private static Stack<String> messageStack = new Stack<>();
    private static Queue<String> messageQueue = new Queue<>();

    private static Stack<String> inboxStack = new Stack<>();
    private static Queue<String> inboxQueue = new Queue<>();

    private static final int MESSAGE_MAX_LENGTH = 250;
    private static final int MESSAGE_MIN_LENGTH = 0;

    public static boolean validMessage(String str) {
        return str != null
                && str.length() != MESSAGE_MIN_LENGTH
                && str.length() <= MESSAGE_MAX_LENGTH;
        //recommended by the IDE to shorten the if(s). Makes it harder to read but ok...
    }

    //return new the top message in the stack
    public void viewMessageStack() {
        if (messageStack.isEmpty()) {
            System.out.println("Message stack is empty.");
            return;
        }
        System.out.print("Message stack: ");
        String[] temp = new String[messageStack.size()];
        for (int i = 0; messageStack.size() >= 1; i++) {       //needs to use messageStack size because it goes down in this case.
            temp[i] = messageStack.pop();
            System.out.print("\"" + temp[i] + (messageStack.size() != 0 ? "\", " : "\".\n"));   //ends with "." instead of "," yes this is unnecessary.
        }
        for (int i = temp.length - 1; messageStack.size() < temp.length; i--) {
            messageStack.push(temp[i]);
        }
        temp = null;
    }

    //push new message
    public static void newMessageStack(String message) {
        if (validMessage(message)) {
            try {
                messageStack.push(message);
                System.out.println("Message added: \"" + message + "\"");
            } catch (Exception e) {
                System.out.println("There seems to be a problem while sending the message.");
            }
        } else {
            System.out.println("Error: Invalid message format! Either its too long, too short or something else");
        }
    }

    //reset the message stack
    public static void resetMessageStack() {
        messageStack = new Stack<String>();
    }

    //reset the message queue
    public static void resetMessageQueue() {
        messageQueue = new Queue<String>();
    }

    //reset all messages
    public static void resetAll() {
        resetMessageStack();
        resetMessageQueue();
    }

    public static boolean removePreview() {
        if (messageStack.isEmpty()) {
            System.out.println("There are no message in store.");
            return false;
        } else {
            System.out.println("Removing last message: \"" + messageStack.peek() + "\".");
            return true;
        }
    }

    public static void removeLastMessageStack() {
        if (!messageQueue.isEmpty()) {
            System.out.println("Removed message: " + messageStack.pop());
        }
    }

    public static void sendAllMessage() {
        if (messageStack.isEmpty()) {
            return;
        }
        transferToQueue();
    }

    public static void transferToQueue() {
        String[] temp = new String[messageStack.size()];
        try {
            System.out.println("Moving messages from stack to buffer...");
            for (int i = temp.length - 1; messageStack.size() >= 1; i--) {
                temp[i] = messageStack.pop();
                progressPercentage(temp.length - i, temp.length);
            }
            System.out.println("Moving message to send queue...");
            for (int i = 0; i < temp.length; i++) {
                messageQueue.offer(temp[i]);
                progressPercentage(i + 1, temp.length);
            }
            System.out.println("\nSeeing message in queue...");
            for (int i = 0; messageQueue.size() >= 1; i++) {
                System.out.println("Message transferred: \"" + messageQueue.poll() + "\"");
            }
        } catch (Exception e) {
            System.out.println("There seems to be a problem while trying to transfer to message queue line.");
            System.out.println(e);
            for (int i = 0; messageQueue.size() >= 1; i++) {
                System.out.println("Message transferred: \"" + messageQueue.poll() + "\"");
            }
        }
        temp = null;
    }

    public static void progressPercentage(int done, int total) {    //from StackOverflow
        int size = 5;
        String iconLeftBoundary = "[";
        String iconDone = "=";
        String iconRemain = ".";
        String iconRightBoundary = "]";

        if (done > total) {
            throw new IllegalArgumentException();
        }
        int donePercents = (100 * done) / total;
        int doneLength = size * donePercents / 100;

        StringBuilder bar = new StringBuilder(iconLeftBoundary);
        for (int i = 0; i < size; i++) {
            if (i < doneLength) {
                bar.append(iconDone);
            } else {
                bar.append(iconRemain);
            }
        }
        bar.append(iconRightBoundary);

        System.out.print("\r" + bar + " " + donePercents + "%");

        if (done == total) {
            System.out.print("\n");
        }
    }


}
