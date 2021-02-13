package white.rabbit.utils;

import org.junit.jupiter.api.Test;
import white.rabbit.math.itertool.CombinationIterable;

import java.util.Arrays;
import java.util.List;

class CombinationIterableTest {
    @Test
    public void testLibrary() {
        int sampleSize = 3;
        List<String> input = Arrays.asList("Aa", "B", "C", "D", "s", "S", "w", "s");
        Iterable<List<String>> iterable =
                new CombinationIterable<String>(sampleSize, input);

        for (List<String> w: iterable) {
            System.out.println(Arrays.toString(w.toArray()));
        }
    }

}