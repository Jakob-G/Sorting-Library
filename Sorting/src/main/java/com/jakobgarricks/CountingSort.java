package com.jakobgarricks;
import java.util.ArrayList;
import java.util.List;
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

    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
    }
}

