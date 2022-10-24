public class messageSystem {
    private Stack<String> messageStack = new Stack<>();
    private Queue<String> messageQueue = new Queue<>();
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
        System.out.print("Message stack: ");
        String[] arr = new String[messageStack.size()];
        for (int i = 0; messageStack.size() >= 1 ; i++) {       //needs to use messageStack size because it goes down in this case.
            arr[i] = messageStack.pop();
            System.out.print("\""+arr[i]+"\",");
        }
        for (int i = arr.length - 1; messageStack.size() < arr.length ; i--) {
            messageStack.push(arr[i]);
        }
        arr = null;
    }

    //push new message
    public void newMessageStack(String message) {
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

    public void view() {
        System.out.println(messageStack.peek());
    }

}
