
import org.junit.jupiter.api.Test;
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
    void newMessageStack() {
        String tooLong = "a".repeat(300);
        String message = "hello there.";
        assertFalse(messageSystem.newMessageStack(null));
        assertFalse(messageSystem.newMessageStack(tooLong));
        assertTrue(messageSystem.newMessageStack(message));
    }
}