import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class messageSystemTest {

    @Test
    void validMessage() {
        String tooLong = "a".repeat(300);
        String message = "hello there.";
        assertFalse(messageSystem.validMessage(null));
        assertFalse(messageSystem.validMessage(tooLong));
        assertTrue(messageSystem.validMessage(message));
    }

    @Test
    void sendAllMessage() {
        input();
        assertTrue(messageSystem.sendAllMessage());
    }

    @Test
    void newMessageStack() {
        String tooLong = "a".repeat(300);
        String message = "hello there.";
        assertFalse(messageSystem.newMessageStack(null));
        assertFalse(messageSystem.newMessageStack(tooLong));
        assertTrue(messageSystem.newMessageStack(message));
    }


    private static void input() {
        messageSystem.newMessageStack("a");
        messageSystem.newMessageStack("b");
        messageSystem.newMessageStack("c");
        messageSystem.newMessageStack("d");
        messageSystem.newMessageStack("e");
        messageSystem.newMessageStack("f");
    }

    @Test
    void viewMessageStack() {
        input();
        assertTrue(messageSystem.viewMessageStack());
    }

    @Test
    void inbox() {
        sendAllMessage();
        assertTrue(messageSystem.inbox());
    }

    @Test
    void clearInbox() {
        inbox();
        assertTrue(messageSystem.clearInbox());
    }

}
