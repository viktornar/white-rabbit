package white.rabbit;

public class Solver {
    private Solver() {
    }

    public static void solve(
            String anagramPhrase, String wordlistLocation, String md5hash, String anagramDetectionType) {

        System.out.printf(
                "Trying to solve with args %s, %s, %s, %s %n",
                anagramPhrase, wordlistLocation, md5hash, anagramDetectionType);

        var before = System.currentTimeMillis();
        var after = System.currentTimeMillis();
        var total = (after - before) / 1000;
        System.out.printf("Takes %ds to solve%n", total);
    }
}
