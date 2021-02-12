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
        assertTrue(sortingBasedChecker.areAnagrams("new york times", "monkeys write"));
        assertTrue(sortingBasedChecker.areAnagrams("forty five", "over fifty"));
    }

    @Test
    void shouldNotConfirmAnagrams() {
        assertFalse(sortingBasedChecker.areAnagrams("beeksforbeeks", "forgeeksgeeks"));
        assertFalse(sortingBasedChecker.areAnagrams("tear", "bleat"));
        assertFalse(sortingBasedChecker.areAnagrams("table", "rate"));
        assertFalse(sortingBasedChecker.areAnagrams("nair slopily outworn", "poultry outwits ants"));
    }
}
