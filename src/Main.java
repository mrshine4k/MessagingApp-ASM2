public class Main {

    public static void main(String[] args) {
        messageSystem test = new messageSystem();
        test.newMessageStack("hello");
        test.newMessageStack("hi there");
        test.newMessageStack("eep");

        test.viewMessageStack();

    }
}