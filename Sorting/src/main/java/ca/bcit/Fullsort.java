package com.jakobgarricks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import edu.princeton.cs.algs4.Stopwatch;

public class Fullsort {

    protected List testList = new ArrayList();

    protected void load(){
        for(int x = 0;x<1000;x++){
            testList.add((Math.random()*100));
        }
    }
    protected void test(){
        Stopwatch watch = new Stopwatch();
        for (int i=0; i<100; i++){
            Collections.shuffle(testList, new Random(100));
            sort(testList);
        }
        System.out.println(watch.elapsedTime());
        Stopwatch compare = new Stopwatch();
        for (int i=0; i<100; i++){
            Collections.shuffle(testList, new Random(100));
            Collections.sort(testList);
        }
        System.out.println(compare.elapsedTime());
    }



    protected void sort(List list){
        List newList = new ArrayList();


        for (int i =0; i < list.size(); i++) {
            List tempList = new ArrayList();
            tempList.add(list.get(i));
            newList.add(tempList);
//            System.out.println(tempList);
        }
//        System.out.println(newList);


        List sortedList = new ArrayList();
        while (sortedList.size() < list.size()) {
            int pos = 0;
            List sortedSmallList = new ArrayList();

            if (newList.size()%2 != 0) {
                List tempList = new ArrayList();
                tempList = mergeSort((List) newList.get(pos), (List) newList.get(newList.size()-1));
                sortedSmallList.add(tempList);
                pos = 1;
            }
            while (pos < newList.size()) {
                List tempList = new ArrayList();
                tempList = mergeSort((List) newList.get(pos), (List) newList.get(pos+1));
                sortedSmallList.add(tempList);
//                System.out.println(sortedSmallList);
                pos += 2;
            }
//            System.out.println(pos);
            sortedList = (List) sortedSmallList.get(0);
            newList = sortedSmallList;
        }
        testList = sortedList;
    }

    private List mergeSort(List firstList, List secList) {
        ArrayList sortedList = new ArrayList();

        double num;
        while(firstList.size() != 0 && secList.size() != 0) {
            num = (Double) firstList.get(0);
            double secNum = (Double)secList.get(0);
            if (num <= secNum) {
                sortedList.add(num);
                firstList.remove(0);
            } else {
                sortedList.add(secNum);
                secList.remove(0);
            }
        }

        while(firstList.size() != 0) {
            num = (Double)firstList.get(0);
            sortedList.add(num);
            firstList.remove(0);
        }

        while(secList.size() != 0) {
            num = (Double)secList.get(0);
            sortedList.add(num);
            secList.remove(0);
        }

        return sortedList;
    }

    public static void main( String[] args )
    {

        try {
            Fullsort sorting = new Fullsort();
            sorting.test();
            sorting.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
