package white.rabbit.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {
    @Test
    void readData() {
        var lines = FileUtil.readData("../wordlist");
        assertEquals(99175, lines.size());
    }
}