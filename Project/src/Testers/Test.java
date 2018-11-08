package Testers;
//Import the type of sort here
import Sorters.CountingSort;

public class Test {

    public static void main(String args[]){
        try {

            //Change all occurrences of the current sort type to desired testing sort type

            CountingSort CountingSort = new CountingSort();
            CountingSort.load();
            System.out.println(CountingSort.list);
            CountingSort.test();
            System.out.println(CountingSort.list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
