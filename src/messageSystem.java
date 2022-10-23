public class messageSystem {
    private static Stack<String> messageStack = new Stack<>();
    private static Queue<String> messageQueue = new Queue<>();
    private static final int MESSAGE_MAX_LENGTH = 250;
    private static final int MESSAGE_MIN_LENGTH = 0;

    public static boolean validMessage(String str) {
        return str != null
                && str.length() != MESSAGE_MIN_LENGTH
                && str.length() <= MESSAGE_MAX_LENGTH;
        //recommended by the IDE to shorten the if(s). Makes it harder to read but ok...
    }

    //return new the top message in the stack
    public static void viewMessageStack() {
        if (messageStack.isEmpty()) {
            System.out.println("There are no messages to see!");
        } else {
            try {
                String message;
                Stack<String> preview = messageStack;
                System.out.print("The message stack are as following: ");
                for (int i = -1; i <= messageStack.size(); i++) {
                    //needs i to be -1 so that it runs one more time when size reaches 1
                    message = preview.peek();
                    preview.pop();
                    System.out.print(message + " > ");
                }
            } catch (Exception e) {
                System.out.println("Failed to retrieve messages");
            }
        }
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

}
