package white.rabbit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    @Disabled("Intend to be run by hand since it can take a lot of time. Don't want to have a long build time.")
    @Test
    void shouldSolveWithGivenWordlist() {
        var secretPhrase = Solver.solve("poultry outwits ants", "../wordlist", "23170acc097c24edb98fc5488ab033fe");
        assertTrue(secretPhrase.isPresent());
    }

    @Test
    void shouldGroupWordsWithPossibleCombinations() {
        var group = Solver.groupWordsWithPossibleCombinations("test my grouping", 14,
                Arrays.asList(
                        "test",
                        "my",
                        "grouping"
                ));
        assertEquals(2, group.get("test").size());
        assertEquals(1, group.get("my").size());
        assertFalse(group.containsKey("grouping"));
    }

    @Test
    void shouldGetFilteredAndSortedWords() {
        var filteredAndSortedWords = Solver.getFilteredAndSortedWords(
                "test test", Arrays.asList("sett", "estt", "a"));
        assertEquals(2, filteredAndSortedWords.size());
        assertArrayEquals(new String[]{"estt", "sett"}, filteredAndSortedWords.toArray());
    }

    @Test
    void searchSecretPhrase() {
        // TODO: Rewrite tests with concurrent mode :) You can use tempus-fugit
//        var secretPhrase = Solver.searchForSecretPhrase(
//                "poultryoutwitsants", new HashMap<>() {{
//                    put("printout", Arrays.asList("stout", "yawls"));
//                }}, "e4820b45d2277f3844eac66c903e84be");
//
//        assertTrue(secretPhrase.isPresent());
    }
}