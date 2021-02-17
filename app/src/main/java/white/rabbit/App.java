package white.rabbit;

import white.rabbit.utils.CliUtil;

import java.util.Map;

import static white.rabbit.Constants.*;

public class App {
    public static void main(String[] args) {
        Map<String, String> arguments = CliUtil.parseArguments(args);
        String anagramPhrase = arguments.get(ANAGRAM_PHRASE);
        String wordlistLocation = arguments.get(WORD_LIST_LOCATION);
        String md5hash = arguments.get(MD5HASH);

        if (anagramPhrase == null || wordlistLocation == null || md5hash == null) {
            System.out.printf(
                    "--%s - was not specified. Usage example: --%s [anagram phrase]. Program will be terminated%n",
                    ANAGRAM_PHRASE, ANAGRAM_PHRASE);
            System.out.println("or");
            System.out.printf(
                    "--%s - was not specified. Usage example: --%s [wordlist location]. Program will be terminated%n",
                    WORD_LIST_LOCATION, WORD_LIST_LOCATION);
            System.out.println("or");
            System.out.printf("--%s - was not specified. Usage example: --%s [md5 hash]. Program will be terminated%n",
                    MD5HASH, MD5HASH);
            // Force to exit all threads. We are not playing nice with threads API so we need to force exit.
            System.exit(0);
        }

        var before = System.currentTimeMillis();
        var secretPhrase = Solver.solve(anagramPhrase, wordlistLocation, md5hash);
        if (secretPhrase.isPresent()) {
            System.out.printf("Found phrase `%s` with `%s`%n", secretPhrase.get(), md5hash);
        } else {
            System.out.println("Was not able to find secret phrase :(");
        }
        var after = System.currentTimeMillis();
        var total = (after - before) / 1000.0;
        System.out.printf("Takes %.3fs to solve%n", total);
        System.exit(0);
    }
}
