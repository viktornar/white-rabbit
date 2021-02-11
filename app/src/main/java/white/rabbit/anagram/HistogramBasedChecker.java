package white.rabbit.anagram;


import java.util.HashMap;
import java.util.Map;

public class HistogramBasedChecker implements Checker {
    @Override
    public boolean areAnagrams(String left, String right) {
        if (left.length() != right.length()) return false;

        Map<Character, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < left.length(); i++) {
            if (!frequencies.containsKey(left.charAt(i))) {
                frequencies.put(left.charAt(i), 1);
            } else {
                frequencies.put(left.charAt(i), frequencies.get(left.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < right.length(); i++) {
            if (!frequencies.containsKey(right.charAt(i))) return false;
        }
        return true;
    }
}
