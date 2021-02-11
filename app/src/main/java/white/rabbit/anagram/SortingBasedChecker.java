package white.rabbit.anagram;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class SortingBasedChecker implements Checker {
    @Override
    public boolean areAnagrams(String left, String right) {
        String l = StringUtils.remove(left, " ");
        String r = StringUtils.remove(right, " ");

        var lChars = l.toCharArray();
        var rChars = r.toCharArray();
        Arrays.sort(lChars);
        Arrays.sort(rChars);
        return Arrays.equals(lChars, rChars);
    }
}
