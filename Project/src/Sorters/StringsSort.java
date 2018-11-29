package Sorters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Stream;

public class StringsSort {
    private List<String> list = new ArrayList<String>();
    private int radix = 256;

    public List<String> getList() {
        return list;
    }

    public void load() {
        try (Stream<String> stream = Files.lines(Paths.get("src\\Testers\\smallStrings.txt"))) {
            stream.forEach(x -> list.add(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test() {
        sort(list);
    }

    private List<String> sort(List<String> toSort) {
        list = toSort;
        List<String> newList = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++)
            newList.add("");
        sortHelper(0, list.size() - 1, 0, newList);
        return list;
    }

    private void sortHelper(int lo, int hi, int digit, List<String> newList) {
        if (hi <= lo) {
            insertion(lo, hi, digit);
            return;
        }

        int[] count = new int[radix + 2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(list.get(i), digit);
            count[c+2]++;
        }

        for(int j = 0; j < radix + 1; j++) {
            count[j + 1] += count[j];
        }

        for(int k = lo; k <= hi; k++) {
            int c = charAt(list.get(k), digit);
            newList.set(count[c + 1]++, list.get(k));
        }

        for(int l = lo; l <= hi; l++) {
            list.set(l, newList.get(l - lo));
        }

        for(int m = 0; m < radix; m++) {
            sortHelper(lo + count[m], lo + count[m + 1] - 1, digit + 1, newList);
        }
    }

    private int charAt(String s, int digit) {
        if (digit == s.length())
            return -1;
        else
            return s.charAt(digit);
    }

    private void insertion(int lo, int hi, int digit) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && compareStrings(list.get(j), list.get(j-1), digit); j--) {
                String temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
    }

    private boolean compareStrings(String one, String two, int digit) {
        for (int i = digit; i < Math.min(one.length(), two.length()); i++) {
            if (one.charAt(i) < two.charAt(i))
                return true;
            if (one.charAt(i) > two.charAt(i))
                return false;
        }
        return one.length() < two.length();
    }
}