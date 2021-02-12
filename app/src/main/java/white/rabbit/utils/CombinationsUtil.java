package white.rabbit.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CombinationsUtil {
    // Add all subsets that take k of the remaining elements
    public static void combine(List<String> xs, int k, List<List<String>> acc) {
        combine(xs, new ArrayList<>(), k, acc);
    }

    private static void combine(List<String> xs, List<String> prefix, int k, List<List<String>> acc) {
        if (xs.size() < k) return;
        else if (k == 0) acc.add(prefix);
        else {
            combine(xs.subList(1, xs.size()), append(prefix, xs.get(0)), k - 1, acc);
            combine(xs.subList(1, xs.size()), prefix, k, acc);
        }
    }

    public static <T> List<T> append(List<T> list, T... args){
        return Stream.concat(list.stream(), Stream.of(args))
                .collect(Collectors.toList());
    }
}
