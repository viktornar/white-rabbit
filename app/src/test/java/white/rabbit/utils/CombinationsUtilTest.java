package white.rabbit.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationsUtilTest {
    @Test
    void shouldAddAllSubsetThatTakeKOfTheRemainingElements() {
        List<String> words = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff");
        List<List<String>> result = CombinationsUtil.combine(words, 2);
        assertEquals(15, result.size());
    }
}