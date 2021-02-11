package white.rabbit.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistogramBasedCheckerTest {
    @Test
    void shouldConfirmAnagrams() {
        var histogramBasedChecker = new HistogramBasedChecker();
        assertTrue(histogramBasedChecker.areAnagrams("geeksforgeeks", "forgeeksgeeks"));
        assertTrue(histogramBasedChecker.areAnagrams("table", "bleat"));
        assertTrue(histogramBasedChecker.areAnagrams("tear", "rate"));
    }
}