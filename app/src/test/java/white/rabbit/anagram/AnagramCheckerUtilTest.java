package white.rabbit.anagram;

import org.junit.jupiter.api.Test;
import white.rabbit.utils.AnagramCheckerUtil;

import static org.junit.jupiter.api.Assertions.*;

class AnagramCheckerUtilTest {
    private final AnagramCheckerUtil anagramCheckerUtil = new AnagramCheckerUtil();

    @Test
    void shouldConfirmAnagrams() {
        assertTrue(anagramCheckerUtil.areAnagrams("geeksforgeeks", "forgeeksgeeks"));
        assertTrue(anagramCheckerUtil.areAnagrams("table", "bleat"));
        assertTrue(anagramCheckerUtil.areAnagrams("tear", "rate"));
        assertTrue(anagramCheckerUtil.areAnagrams("new york times", "monkeys write"));
        assertTrue(anagramCheckerUtil.areAnagrams("forty five", "over fifty"));
    }

    @Test
    void shouldNotConfirmAnagrams() {
        assertFalse(anagramCheckerUtil.areAnagrams("beeksforbeeks", "forgeeksgeeks"));
        assertFalse(anagramCheckerUtil.areAnagrams("tear", "bleat"));
        assertFalse(anagramCheckerUtil.areAnagrams("table", "rate"));
        assertFalse(anagramCheckerUtil.areAnagrams("i rational platypus", "poultry outwits ants"));
        assertFalse(anagramCheckerUtil.areAnagrams("poultry outwits ants", "nair slopily outworn"));
    }
}