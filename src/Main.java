public class Main {

    public static void main(String[] args) {

    }

    private static void stackTest() {
        Stack<Integer> myStack = new Stack<>();

        myStack.push(5);
        myStack.push(10);
        myStack.push(16);
        myStack.push(19);

        int size = myStack.size();
        System.out.println("Current of the stack: " + size);

        int x = myStack.pop();
        System.out.println(x);

        boolean empty = myStack.isEmpty();
        System.out.println("Stack empty state: " + empty);

        int peek = myStack.peek();
        System.out.println(peek);

        size = myStack.size();
        System.out.println("Current size of the stack: " + size);

        try {
            myStack.clear();
            System.out.println("Stack cleared? : " + myStack.isEmpty());
            if (!myStack.isEmpty()) {
                myStack.peek();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}