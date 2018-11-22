package com.jakobgarricks.demo;
import com.jakobgarricks.CountingSort;
import java.util.ArrayList;
import java.util.List;
//import com.jakobgarricks.CountingSort;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Integer> newList = new ArrayList<Integer>();
        CountingSort thing = new CountingSort();
        for(int x = 0;x<100000;x++){
            newList.add((int)(Math.random()*1000));
        }
        System.out.println(newList);
        thing.Sort(newList);
        System.out.println(newList);
        System.out.println( "Hello World!" );
    }
}
