package white.rabbit;

import white.rabbit.anagram.DetectionType;
import white.rabbit.utils.CliUtil;

import java.util.Map;

import static white.rabbit.Constants.*;
import static white.rabbit.anagram.DetectionType.Histogram;

public class App {
    public static void main(String[] args) {
        Map<String, String> arguments = CliUtil.parseArguments(args);
        String anagramPhrase = arguments.get(ANAGRAM_PHRASE);
        String wordlistLocation = arguments.get(WORD_LIST_LOCATION);
        String md5hash = arguments.get(MD5HASH);
        String anagramDetectionType =
                arguments.get(ANAGRAM_DETECTION_TYPE) != null ?
                        arguments.get(ANAGRAM_DETECTION_TYPE) : Histogram.toString();

        if (anagramPhrase == null ||
                        wordlistLocation == null ||
                        md5hash == null) {
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

        new Solver(anagramDetectionType).solve(anagramPhrase, wordlistLocation, md5hash);
    }
}
