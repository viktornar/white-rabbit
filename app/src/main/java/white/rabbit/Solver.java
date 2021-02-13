package white.rabbit;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import white.rabbit.math.itertool.CombinationIterable;
import white.rabbit.math.itertool.PermutationIterable;
import white.rabbit.utils.AnagramCheckerUtil;
import white.rabbit.utils.FileUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static white.rabbit.Constants.MAX_WORD_COUNT;

public class Solver {
    public static void solve(
            String anagramPhrase, String wordlistLocation, String md5hash) {

        System.out.printf(
                "Trying to solve with args `%s`, `%s`, `%s` %n",
                anagramPhrase, wordlistLocation, md5hash);

        var before = System.currentTimeMillis();
        var words = FileUtil.readData(wordlistLocation);

        if (words.size() == 0) {
            throw new RuntimeException("No words in list. Impossible to solve.");
        }

        var anagramWords = StringUtils.remove(anagramPhrase, " ");
        var anagramLength = anagramWords.length();
        var sortedWords = getSortedWords(anagramPhrase, words);
        var possibleWordsCombinations = groupWordsWithPossibleCombinations(anagramPhrase, anagramLength, sortedWords);
        searchAndPrintPhrase(anagramWords, possibleWordsCombinations, md5hash);
        var after = System.currentTimeMillis();
        var total = (after - before) / 1000.0;
        System.out.printf("Takes %.3fs to solve%n", total);
    }

    private static Map<String, List<String>> groupWordsWithPossibleCombinations(String anagramPhrase, int anagramLength, List<String> sortedWords) {
        Map<String, List<String>> possibleWordsCombinations = new HashMap<>();

        for (var i = 0; i < sortedWords.size(); i++) {
            var word = sortedWords.get(i);
            List<String> combinations = new ArrayList<>();
            for (var j = i + 1; j < sortedWords.size(); j++) {
                var combination = sortedWords.get(j);
                var possiblePhrase = word + combination;

                if (possiblePhrase.length() <= anagramLength && AnagramCheckerUtil.inAnagrams(anagramPhrase, possiblePhrase)) {
                    combinations.add(combination);
                }

            }

            if (combinations.size() > 0) {
                possibleWordsCombinations.put(word, combinations);
            }
        }
        return possibleWordsCombinations;
    }

    private static List<String> getSortedWords(String anagramPhrase, List<String> words) {
        return words.stream()
                .filter(word -> AnagramCheckerUtil.inAnagrams(anagramPhrase, word))
                .collect(Collectors.toSet())
                .stream()
                .sorted().collect(Collectors.toList());
    }

    private static void searchAndPrintPhrase(
            String anagramWords, Map<String, List<String>> possibleWordsCombinations, String md5hash) {

        searchloop:
        for (var i = 2; i <= MAX_WORD_COUNT; i++) {
            for (var entry : possibleWordsCombinations.entrySet()) {
                var word = entry.getKey();
                var v = entry.getValue().stream().sorted().distinct().collect(Collectors.toList());
                Iterable<List<String>> combinations = new CombinationIterable<>(i, v);
                for (List<String> cw : combinations) {
                    cw.add(word);
                    String phrase = StringUtils.join(cw, "");

                    if (AnagramCheckerUtil.areAnagrams(anagramWords, phrase)) {
                        var permutations = new PermutationIterable<>(cw);
                        for (var permutation : permutations) {
                            String maybePhrase = StringUtils.join(permutation, " ");
                            if (DigestUtils.md5Hex(maybePhrase).equals(md5hash)) {
                                System.out.printf("Found phrase `%s` with `%s`%n", maybePhrase, md5hash);
                                // No more reason to search. Exit all loops.
                                break searchloop;
                            }
                        }
                    }
                }
            }
        }
    }

}
