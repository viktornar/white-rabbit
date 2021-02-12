package white.rabbit.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsUtilTest {
    @Test
    void shouldPermutateGivenListOfWords() {
        List<String> elements = Arrays.asList("aaa", "bbb", "ccc");

        List<List<String>> res = PermutationsUtil.makePermitations(elements);
        assertEquals(6, res.size());
        assertEquals(3, res.get(0).size());
    }

}