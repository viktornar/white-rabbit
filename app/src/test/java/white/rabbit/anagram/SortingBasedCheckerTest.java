package white.rabbit.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingBasedCheckerTest {
    private final SortingBasedChecker sortingBasedChecker = new SortingBasedChecker();

    @Test
    void shouldConfirmAnagrams() {
        assertTrue(sortingBasedChecker.areAnagrams("geeksforgeeks", "forgeeksgeeks"));
        assertTrue(sortingBasedChecker.areAnagrams("table", "bleat"));
        assertTrue(sortingBasedChecker.areAnagrams("tear", "rate"));
    }

    @Test
    void shouldNotConfirmAnagrams() {
        assertFalse(sortingBasedChecker.areAnagrams("beeksforbeeks", "forgeeksgeeks"));
        assertFalse(sortingBasedChecker.areAnagrams("tear", "bleat"));
        assertFalse(sortingBasedChecker.areAnagrams("table", "rate"));
    }
}
