public class messageSystem {
    private Stack<String> messageStack = new Stack<>();
    static final int MESSAGE_MAX_LENGTH = 250;
    static final int MESSAGE_MIN_LENGTH = 0;

    public boolean validMessage(String str) {
        return str != null
                && str.length() != MESSAGE_MIN_LENGTH
                && str.length() <= MESSAGE_MAX_LENGTH;
        //recommended by the IDE to shorten the if(s). Makes it harder to read but ok...
    }

    //return new the top message in the stack
    public void latestMessage() {
        if (messageStack.isEmpty()) {
            System.out.println("There are no messages to see!");
        } else {
            try {
                System.out.println("latest message : | " + messageStack.pop() + " |");
            } catch (Exception e) {
                System.out.println("Failed to retrieve the latest message");
            }
        }
    }

    //push new message
    public void newMessage(String message) {
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

    //message counters
    public int messageCount() {
        return messageStack.size();
    }

    public boolean isEmpty() {
        return messageStack.isEmpty();
    }

    //reset the message stack
    public void reset() {
        messageStack.clear();
    }

}
