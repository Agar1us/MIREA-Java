import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WorkTest {

    @Test
    void LibraryTest() throws IOException {
        boolean real = Work.isLibrary("requests");
        assertTrue(real);
    }

    @Test
    void HeightTest() {
        boolean real = Work.isHeight(-3);
        assertFalse(real);
    }
}