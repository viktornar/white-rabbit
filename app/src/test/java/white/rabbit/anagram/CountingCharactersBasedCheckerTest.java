package white.rabbit.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingCharactersBasedCheckerTest {
    private final CountingCharactersBasedChecker countingCharactersBasedChecker = new CountingCharactersBasedChecker();

    @Test
    void shouldConfirmAnagrams() {
        assertTrue(countingCharactersBasedChecker.areAnagrams("geeksforgeeks", "forgeeksgeeks"));
        assertTrue(countingCharactersBasedChecker.areAnagrams("table", "bleat"));
        assertTrue(countingCharactersBasedChecker.areAnagrams("tear", "rate"));
        assertTrue(countingCharactersBasedChecker.areAnagrams("new york times", "monkeys write"));
        assertTrue(countingCharactersBasedChecker.areAnagrams("forty five", "over fifty"));
    }

    @Test
    void shouldNotConfirmAnagrams() {
        assertFalse(countingCharactersBasedChecker.areAnagrams("beeksforbeeks", "forgeeksgeeks"));
        assertFalse(countingCharactersBasedChecker.areAnagrams("tear", "bleat"));
        assertFalse(countingCharactersBasedChecker.areAnagrams("table", "rate"));
        assertFalse(countingCharactersBasedChecker.areAnagrams("nair slopily outworn", "poultry outwits ants"));
    }
}