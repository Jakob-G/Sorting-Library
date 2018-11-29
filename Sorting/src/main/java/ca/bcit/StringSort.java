package com.jakobgarricks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Stream;

public class StringSort {
    private List<String> list = new ArrayList<String>();
    private int radix = 256;
    private int maxLen;

    public List<String> getList() {
        return list;
    }

//    public void load(){
//        try (Stream<String> stream = Files.lines(Paths.get("src\\Testers\\smallStrings.txt"))) {
//            stream.forEach(x -> list.add(x));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void test(){
//        sort(list);
//    }

    private int getRadixVal(String x, int digit) {
        return (int)x.charAt(maxLen - digit);
    }

    private List<Integer> computeOffsets(int start, int end, int digit) {
        List<Integer> counts = new ArrayList<Integer>();
        for (int i = 0; i < radix; i++)
            counts.add(0);
        for (int j = start; j < end; j++) {
            int val = getRadixVal(list.get(j), digit);
            counts.set(val, counts.get(j) + 1);
        }
        List<Integer> offsets = new ArrayList<Integer>();
        for (int k = 0; k < radix; k++)
            offsets.add(0);
        int sum = 0;
        for (int m = 0; m < radix; m++) {
            offsets.set(m, sum);
            sum += counts.get(m);
        }
        return offsets;
    }

    private void swap(List<Integer> offsets, int start, int end, int digit){
        int i = start;
        List<Integer> nextFree = offsets;
        int curBlock = 0, radixVal = 0, swapTo = 0;

        while (curBlock < radix - 1) {
            if (i >= start + offsets.get(curBlock + 1)) {
                curBlock += 1;
            }
            else {
                radixVal = getRadixVal(list.get(i), digit);
                if (radixVal == curBlock) {
                    i += 1;
                }
                else {
                    swapTo = nextFree.get(radixVal);
                    String temp = list.get(i);
                    list.set(i, list.get(swapTo));
                    list.set(swapTo, temp);
                    nextFree.set(radixVal, nextFree.get(radixVal) + 1);
                }
            }
            System.out.println("\ni: " + i + ", curBlock: " + curBlock + ", radixVal: " + radixVal + ", swapTo: " + swapTo);
            System.out.println(list);
        }
    }

    private void sort_helper(int start, int end, int digit) {
        List<Integer> offsets = computeOffsets(start, end, digit);
        swap(offsets, start, end, digit);
        System.out.println(list);
        if (digit == 0)
            return;
        for (int i = 0; i < offsets.size() - 1; i++)
            sort_helper(offsets.get(i), offsets.get(i + 1), digit - 1);
    }

    private List<String> sort(List<String> inList){
        list = inList;
        String max_string = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max_string) > 0)
                max_string = list.get(i);
        }
        maxLen = max_string.length();
        sort_helper(0, list.size(), max_string.length());
        return list;
    }
}