package white.rabbit.anagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistogramBasedCheckerTest {
    private final HistogramBasedChecker histogramBasedChecker = new HistogramBasedChecker();

    @Test
    void shouldConfirmAnagrams() {
        assertTrue(histogramBasedChecker.areAnagrams("geeksforgeeks", "forgeeksgeeks"));
        assertTrue(histogramBasedChecker.areAnagrams("table", "bleat"));
        assertTrue(histogramBasedChecker.areAnagrams("tear", "rate"));
    }

    @Test
    void shouldNotConfirmAnagrams() {
        assertFalse(histogramBasedChecker.areAnagrams("beeksforbeeks", "forgeeksgeeks"));
        assertFalse(histogramBasedChecker.areAnagrams("tear", "bleat"));
        assertFalse(histogramBasedChecker.areAnagrams("table", "rate"));
    }
}