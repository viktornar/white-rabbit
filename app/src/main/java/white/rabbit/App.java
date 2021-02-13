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

        if ( anagramPhrase == null || wordlistLocation == null || md5hash == null) {
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
            System.exit(0);
        }

        Solver.solve(anagramPhrase, wordlistLocation, md5hash);
    }
}
