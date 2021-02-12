package white.rabbit.anagram;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class HistogramBasedChecker implements Checker {
    @Override
    public boolean areAnagrams(String left, String right) {
        String l = StringUtils.remove(left, " ");
        String r = StringUtils.remove(right, " ");

        if (l.length() != r.length()) return false;

        Map<Character, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < l.length(); i++) {
            if (!frequencies.containsKey(l.charAt(i))) {
                frequencies.put(l.charAt(i), 1);
            } else {
                frequencies.put(l.charAt(i), frequencies.get(l.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < r.length(); i++) {
            if (!frequencies.containsKey(r.charAt(i)) || frequencies.get(r.charAt(i)) == 0) return false;
            frequencies.put(r.charAt(i), frequencies.get(r.charAt(i)) - 1);
        }
        return true;
    }
}
