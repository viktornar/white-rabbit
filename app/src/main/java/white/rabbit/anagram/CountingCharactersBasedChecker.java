package white.rabbit.anagram;

import org.apache.commons.lang3.StringUtils;

public class CountingCharactersBasedChecker implements Checker {
    @Override
    public boolean areAnagrams(String left, String right) {
        String l = StringUtils.remove(left, " ");
        String r = StringUtils.remove(right, " ");

        if (l.length() != r.length()) return false;
        for (int i = 0; i < l.length(); i++) {
            char currCh = l.charAt(i);
            if (numCopiesOf(currCh, l) != numCopiesOf(currCh, r)) {
                return false;
            }
        }
        return true;
    }

    private int numCopiesOf(char ch, String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) result++;
        }
        return result;
    }
}
