package white.rabbit.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombinationsUtil {
    // Add all subsets that take k of the remaining elements
    public static List<List<String>> combine(List<String> xs, int k) {
        List<List<String>> acc = new ArrayList<>();
        combine(xs, new ArrayList<>(), k, acc);
        return acc;
    }

    private static void combine(List<String> xs, List<String> prefix, int k, List<List<String>> acc) {
        if (k == 0) acc.add(prefix);
        else {
            for (int i = 0; i < xs.size(); i++)
                combine(xs.subList(i + 1, xs.size()), append(prefix, xs.get(i)), k - 1, acc);
        }
    }

    private static <T> List<T> append(List<T> list, T... args) {
        return Stream.concat(list.stream(), Stream.of(args))
                .collect(Collectors.toList());
    }
}
