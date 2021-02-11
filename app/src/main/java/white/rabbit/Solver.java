package white.rabbit;

import org.apache.commons.lang3.StringUtils;
import white.rabbit.anagram.*;
import white.rabbit.utils.FileUtil;

import java.util.List;

public class Solver {
    private Checker anagramChecker;

    public Solver(String detectionType) {
        System.out.printf("Initializing solver with `%s` detection type%n", detectionType);
        if (detectionType.equals(DetectionType.Sort.toString())) {
            anagramChecker = new SortingBasedChecker();
        } else if (detectionType.equals(DetectionType.Counting.toString())) {
            anagramChecker = new CountingCharactersBasedChecker();
        } else {
            anagramChecker = new HistogramBasedChecker();
        }
    }

    public static void solve(
            String anagramPhrase, String wordlistLocation, String md5hash) {

        System.out.printf(
                "Trying to solve with args `%s`, `%s`, `%s` %n",
                anagramPhrase, wordlistLocation, md5hash);

        var before = System.currentTimeMillis();

        List<String> words = FileUtil.readData(wordlistLocation);

        if (words.size() == 0) {
            throw new RuntimeException("No words in list. Impossible to solve.");
        }

        var after = System.currentTimeMillis();
        var total = (after - before) / 1000;
        System.out.printf("Takes %ds to solve%n", total);
    }
}
