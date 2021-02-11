package white.rabbit.anagram;

public class CountingCharactersBasedChecker implements Checker {
    @Override
    public boolean areAnagrams(String left, String right) {
        if (left.length() != right.length()) return false;
        for (int i = 0; i < left.length(); i++) {
            char currCh = left.charAt(i);
            if (numCopiesOf(currCh, left) != numCopiesOf(currCh, right)) {
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
