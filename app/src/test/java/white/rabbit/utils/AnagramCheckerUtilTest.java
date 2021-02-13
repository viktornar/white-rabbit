package white.rabbit.utils;

import org.junit.jupiter.api.Test;
import white.rabbit.utils.AnagramCheckerUtil;

import static org.junit.jupiter.api.Assertions.*;

class AnagramCheckerUtilTest {
    @Test
    void shouldConfirmAnagrams() {
        assertTrue(AnagramCheckerUtil.areAnagrams("geeksforgeeks", "forgeeksgeeks"));
        assertTrue(AnagramCheckerUtil.areAnagrams("table", "bleat"));
        assertTrue(AnagramCheckerUtil.areAnagrams("tear", "rate"));
        assertTrue(AnagramCheckerUtil.areAnagrams("new york times", "monkeys write"));
        assertTrue(AnagramCheckerUtil.areAnagrams("forty five", "over fifty"));
    }

    @Test
    void shouldNotConfirmAnagrams() {
        assertFalse(AnagramCheckerUtil.areAnagrams("beeksforbeeks", "forgeeksgeeks"));
        assertFalse(AnagramCheckerUtil.areAnagrams("tear", "bleat"));
        assertFalse(AnagramCheckerUtil.areAnagrams("table", "rate"));
        assertFalse(AnagramCheckerUtil.areAnagrams("i rational platypus", "poultry outwits ants"));
        assertFalse(AnagramCheckerUtil.areAnagrams("poultry outwits ants", "nair slopily outworn"));
    }
}