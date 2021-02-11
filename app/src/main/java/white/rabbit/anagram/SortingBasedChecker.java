package white.rabbit.anagram;

import java.util.Arrays;

public class SortingBasedChecker implements Checker {
    @Override
    public boolean areAnagrams(String left, String right) {
        var leftChars = left.toCharArray();
        var rightChars = right.toCharArray();
        Arrays.sort(leftChars);
        Arrays.sort(rightChars);
        return Arrays.equals(leftChars, rightChars);
    }
}
