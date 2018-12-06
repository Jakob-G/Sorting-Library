package Testers;
import Sorters.StringsSort;
import java.util.Scanner;

public class TestStrings {

    public static void main(String args[]){
        try {

            //Change all occurrences of the current sort type to desired testing sort type

            StringsSort StringsSort = new StringsSort();
            StringsSort.load();
            System.out.println(StringsSort.getList());
            StringsSort.test();
            System.out.println(StringsSort.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
