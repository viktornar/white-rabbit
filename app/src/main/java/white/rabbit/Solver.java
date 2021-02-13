package white.rabbit;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import white.rabbit.math.itertool.CombinationIterable;
import white.rabbit.math.itertool.PermutationIterable;
import white.rabbit.utils.AnagramCheckerUtil;
import white.rabbit.utils.FileUtil;

import java.util.*;
import java.util.stream.Collectors;

import static white.rabbit.Constants.MAX_WORD_COUNT;

public class Solver {
    private Solver() {

    }

    public static Optional<String> solve(
            String anagramPhrase, String wordlistLocation, String md5hash) {

        System.out.printf(
                "Trying to solve with args `%s`, `%s`, `%s` %n",
                anagramPhrase, wordlistLocation, md5hash);


        var words = FileUtil.readData(wordlistLocation);

        if (words.size() == 0) {
            throw new RuntimeException("No words in list. Impossible to solve.");
        }

        var anagramWords = StringUtils.remove(anagramPhrase, " ");
        var anagramLength = anagramWords.length();
        var sortedWords = getFilteredAndSortedWords(anagramPhrase, words);
        var possibleWordsCombinations = groupWordsWithPossibleCombinations(anagramPhrase, anagramLength, sortedWords);

        return searchSecretPhrase(anagramWords, possibleWordsCombinations, md5hash);
    }

    static Map<String, List<String>> groupWordsWithPossibleCombinations(String phrase, int lettersCountInPhrase, List<String> words) {
        Map<String, List<String>> possibleWordsCombinationsForPhrase = new HashMap<>();

        for (var i = 0; i < words.size(); i++) {
            var word = words.get(i);
            List<String> combinations = new ArrayList<>();

            for (var j = i + 1; j < words.size(); j++) {
                var combination = words.get(j);
                var possiblePartOfPhrase = word + combination;

                if (possiblePartOfPhrase.length() <= lettersCountInPhrase && AnagramCheckerUtil.inAnagrams(phrase, possiblePartOfPhrase)) {
                    combinations.add(combination);
                }

            }

            if (combinations.size() > 0) {
                possibleWordsCombinationsForPhrase.put(word, combinations);
            }
        }

        return possibleWordsCombinationsForPhrase;
    }

    static List<String> getFilteredAndSortedWords(String anagramPhrase, List<String> words) {
        return words.stream()
                .filter(word -> AnagramCheckerUtil.inAnagrams(anagramPhrase, word))
                .collect(Collectors.toSet())
                .stream()
                .sorted().collect(Collectors.toList());
    }

    static Optional<String> searchSecretPhrase(
            String anagramWords, Map<String, List<String>> possibleWordsCombinations, String md5hash) {

        Optional<String> secretPhrase = Optional.empty();

        searchloop:
        for (var i = 2; i <= MAX_WORD_COUNT; i++) {

            for (var entry : possibleWordsCombinations.entrySet()) {
                var word = entry.getKey();
                var v = entry.getValue().stream().sorted().distinct().collect(Collectors.toList());
                Iterable<List<String>> combinations = new CombinationIterable<>(i, v);

                for (List<String> cw : combinations) {
                    cw.add(word);
                    var phrase = StringUtils.join(cw, "");

                    if (AnagramCheckerUtil.areAnagrams(anagramWords, phrase)) {
                        var permutations = new PermutationIterable<>(cw);

                        for (var permutation : permutations) {
                            var maybePhrase = StringUtils.join(permutation, " ");

                            if (DigestUtils.md5Hex(maybePhrase).equals(md5hash)) {
                                secretPhrase = Optional.of(maybePhrase);
                                // No more reason to search. Exit from all loops.
                                break searchloop;
                            }
                        }
                    }
                }
            }
        }

        return secretPhrase;
    }
}
