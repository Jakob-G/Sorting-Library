package com.jakobgarricks;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


import edu.princeton.cs.algs4.Stopwatch;
//import com.github.Jakob-G.SortingLibrary


public class CountingSort implements Sorter{


    public List Sort(List<Integer> list) {
        List<Integer> newList = new ArrayList<Integer>();

        for(Object x:list){
            if (newList.size()<(Integer)x+1){
                for(int n=newList.size();n<(Integer)x+1;n++){
                    newList.add(0);
                }
            }
            newList.set((Integer)x,newList.get((Integer)x)+1);
        }
        int counter = 0;
        for(int i = 1;i<newList.size();i++){
            for(int x = 0;x<newList.get(i);x++){
                list.set(counter,i);
                counter++;
            }
        }
        return list;
    }


    protected void test(){
        List<Integer> testList = new ArrayList<Integer>();
        for(int x = 0;x<100000;x++){
            testList.add((int)(Math.random()*1000));
        }

        Stopwatch watch = new Stopwatch();
        for (int i=0; i<1000; i++){
            Collections.shuffle(testList, new Random(100));
            Sort(testList);
        }
        System.out.println(watch.elapsedTime());
        Stopwatch compare = new Stopwatch();
        for (int i=0; i<1000; i++){
            Collections.shuffle(testList, new Random(100));
            Collections.sort(testList);
        }
        System.out.println(compare.elapsedTime());
    }

    public static void main( String[] args )
    {

        try {
            CountingSort sorting = new CountingSort();
            sorting.test();
            sorting.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

