public class messageSystem {
    private static final int MESSAGE_MAX_LENGTH = 250;
    private static final int MESSAGE_MIN_LENGTH = 0;
    private static Stack<String> messageStack = new Stack<>();
    private static Queue<String> messageQueue = new Queue<>();
    private static Stack<String> inboxStack = new Stack<>();
    private static Queue<String> inboxQueue = new Queue<>();

    public static boolean validMessage(String str) {
        return str != null
                && str.length() != MESSAGE_MIN_LENGTH
                && str.length() <= MESSAGE_MAX_LENGTH;
        //recommended by the IDE to shorten the if(s). Makes it harder to read but ok...
    }

    //push new message
    public static boolean newMessageStack(String message) {
        if (validMessage(message)) {
            try {
                messageStack.push(message);
                System.out.println("Message added: \"" + message + "\"");
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            System.out.println("Error: Invalid message format!");
        }
        return false;
    }

    //central removePreview for stacks
    public static boolean removePreview(Stack<String> stack) {
        if (stack.isEmpty()) {
            System.out.println("There are no message in here.");
            return false;
        } else {
            System.out.println("Removing latest message: \"" + stack.peek() + "\".");
            return true;
        }
    }

    public static boolean removeMessagePreview() {
        return removePreview(messageStack);
    }

    public static boolean removeInboxPreview() {
        return removePreview(inboxStack);
    }

    //central removeLast for stacks
    public static boolean removeLast(Stack<String> stack) {
        if (!stack.isEmpty()) {
            try {
                System.out.println("Removed message: " + stack.pop());
                return true;
            } catch (Exception e) {
                System.out.println("Error happened: " + e.getMessage());
                return false;
            }
        }
        System.out.println("There are no message to remove!");
        return false;

    }

    public static void removeLastMessageStack() {
        removeLast(messageStack);
    }

    public static void removeFirstInboxStack() {
        removeLast(inboxStack);
    }

    public static boolean sendAllMessage() {
        if (messageStack.isEmpty()) {
            return false;
        }

        progressPercentage(0, 100);

        if (transferToQueue()) {
            progressPercentage(33, 100);

            if (sendMessages()) {
                progressPercentage(66, 100);

                if (addToInbox()) {
                    progressPercentage(100, 100);
                    System.out.println("Sent all messages successfully! Check the inbox for messages");
                    return true;
                }
            }
        }
        return false;
    }

    //transferring messages from messsage stack to message queue
    public static boolean transferToQueue() {
        try {
            for (int i = 0; messageStack.size() >= 1; i++) {
                messageQueue.offer(messageStack.pop());
            }
            return true;
        } catch (Exception e) {
            System.out.println("There seems to be a problem while trying to transfer to message queue.");
            System.out.println(e);
        }
        return false;
    }

    //sends message from message queue to inbox queue
    public static boolean sendMessages() {
        try {
            for (int i = 0; messageQueue.size() >= 1; i++) {
                inboxQueue.offer(messageQueue.poll());
            }
            return true;
        } catch (Exception e) {
            System.out.println("There seems to be a problem while trying to send the messages to inbox queue.");
            System.out.println(e);
        }
        return false;
    }

    //move all messages from inbox queue to inbox stack
    public static boolean addToInbox() {
        try {
            for (int i = 0; inboxQueue.size() >= 1; i++) {
                inboxStack.push(inboxQueue.poll());
            }
            return true;
        } catch (Exception e) {
            System.out.println("There seems to be a problem while trying to move the messages to the inbox.");
            System.out.println(e);
            return false;
        }
    }

    public static void progressPercentage(int done, int total) {    //from StackOverflow, used to display progress
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

    //return new the top message in the stack
    public static boolean viewMessageStack() {
        if (messageStack.isEmpty()) {
            System.out.println("Message stack is empty.");
            return false;
        }
        try {
            System.out.print("Message stack: ");
            String[] temp = new String[messageStack.size()];
            for (int i = 0; messageStack.size() >= 1; i++) {//needs to use messageStack size because it goes down in this case.
                temp[i] = messageStack.pop();   //getting all element out to an array to present it then push all back in later.
                System.out.print("\"" + temp[i] + (messageStack.size() != 0 ? "\", " : "\".\n"));
                //ends with "." instead of "," yes this is unnecessary, only a formatting thing.
            }
            for (int i = temp.length - 1; messageStack.size() < temp.length; i--) {
                messageStack.push(temp[i]); //pushing all back inside
            }
            return true;
        } catch (Exception e) {
            System.out.println("There seems to be a problem while trying to view the message stack.");
            System.out.println(e);
            return false;
        }
    }

    public static boolean inbox() {
        String[] temp = new String[inboxStack.size()];
        System.out.printf(inboxStack.isEmpty() ? "Empty inbox.\n" : "Inbox (%d messages):\n", inboxStack.size());

        try {
            for (int i = 0; inboxStack.size() >= 1; i++) {
                temp[i] = inboxStack.pop();
                System.out.print("\"" + temp[i] + (inboxStack.size() != 0 ? "\", " : "\".\n")); //reused from above
            }
            for (int i = temp.length - 1; inboxStack.size() < temp.length; i--) {
                inboxStack.push(temp[i]); //pushing all back inside
            }
            return true;
        } catch (Exception e) {
            System.out.println("There seems to be a problem while trying to view the inbox.");
            System.out.println(e);
            return false;
        }
    }

    public void clearInbox() {
        System.out.println(inboxStack.clear() ? "Inbox cleared." : "Failed to clear inbox.");
    }
}
