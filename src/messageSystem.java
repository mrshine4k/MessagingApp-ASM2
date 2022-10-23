public class messageSystem {
    private Stack<String> messageStack = new Stack<>();

    private Queue<String> messageQueue = new Queue<>();
    static final int MESSAGE_MAX_LENGTH = 250;
    static final int MESSAGE_MIN_LENGTH = 0;

    public boolean validMessage(String str) {
        return str != null
                && str.length() != MESSAGE_MIN_LENGTH
                && str.length() <= MESSAGE_MAX_LENGTH;
        //recommended by the IDE to shorten the if(s). Makes it harder to read but ok...
    }

    //return new the top message in the stack
    public void viewMessageStack() {
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
    public void newMessageStack(String message) {
        if (validMessage(message)) {
            try {
                messageStack.push(message);
                System.out.println("message: | " + message + " | added to stack successfully!");
            } catch (Exception e) {
                System.out.println("There seems to be a problem while sending the message.");
            }
        } else {
            System.out.println("Invalid message format!");
        }
    }

    //reset the message stack
    public void resetMessageStack() {
        messageStack = new Stack<String>();
    }

    //reset the message queue
    public void resetMessageQueue() {
        messageQueue = new Queue<String>();
    }

    //reset all messages
    public void resetAll() {
        resetMessageStack();
        resetMessageQueue();
    }

}
