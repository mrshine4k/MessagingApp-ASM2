
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class messageSystemTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;


    @Test
    void validMessage() {
        String tooLong = "a".repeat(300);
        String message = "hello there.";
        assertFalse(messageSystem.validMessage(null));
        assertFalse(messageSystem.validMessage(tooLong));
        assertTrue(messageSystem.validMessage(message));
    }

//    @Test
//    void newMessageStack() {
//        String tooLong = "a".repeat(300);
//        String message = "hello there.";
//        (messageSystem.newMessageStack(tooLong));
//        assertTrue(messageSystem.newMessageStack(message));
//    }

    @Test
    void resetMessageStack() {
    }

    @Test
    void resetMessageQueue() {
    }

    @Test
    void resetAll() {
    }

    @Test
    void viewLast() {
    }

    @Test
    void removeLastMessageStack() {
    }

    @Test
    void sendAllMessage() {
    }

    @Test
    void transferToQueue() {
    }
}