package white.rabbit.utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsUtil {
    public static List<List<String>> makePermitations(List<String> words) {
        List<List<String>> acc = new ArrayList<>();
        String[] a = new String[words.size()];
        for (int i = 0; i < words.size(); i++)
            a[i] = words.get(i);

        enumerate(a, a.length, words.size(), acc);

        return acc;
    }

    private static void enumerate(String[] a, int n, int k, List<List<String>> acc) {
        if (k == 0) {
            List<String> words = new ArrayList<>();
            words.addAll(Arrays.asList(a).subList(n, a.length));
            acc.add(words);
            return;
        }

        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            enumerate(a, n - 1, k - 1, acc);
            swap(a, i, n - 1);
        }
    }

    public static void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

