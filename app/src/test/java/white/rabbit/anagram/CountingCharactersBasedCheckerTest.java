package white.rabbit.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingCharactersBasedCheckerTest {
    @Test
    void shouldConfirmAnagrams() {
        var countingCharactersBasedChecker = new CountingCharactersBasedChecker();
        assertTrue(countingCharactersBasedChecker.areAnagrams("geeksforgeeks", "forgeeksgeeks"));
        assertTrue(countingCharactersBasedChecker.areAnagrams("table", "bleat"));
        assertTrue(countingCharactersBasedChecker.areAnagrams("tear", "rate"));
    }
}