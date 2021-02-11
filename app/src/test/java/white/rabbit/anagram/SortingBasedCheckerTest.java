package white.rabbit.anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingBasedCheckerTest {

    @Test
    void shouldConfirmAnagrams() {
        var sortingBasedChecker = new SortingBasedChecker();
        assertTrue(sortingBasedChecker.areAnagrams("geeksforgeeks", "forgeeksgeeks"));
        assertTrue(sortingBasedChecker.areAnagrams("table", "bleat"));
        assertTrue(sortingBasedChecker.areAnagrams("tear", "rate"));
    }
}
