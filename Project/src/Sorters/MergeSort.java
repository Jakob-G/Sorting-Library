package Sorters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MergeSort {

    public List list = new ArrayList<Integer>();

    public void load(){
        try (Stream<String> stream = Files.lines(Paths.get("Testers\\numbers.txt"))) {
            stream.forEach(x -> list.add(Integer.parseInt(x)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void test(){
    sort(list);
}


    private void sort(List list){
        List newList = new ArrayList<Integer>();


        for (int i =0; i < list.size(); i++) {
            List tempList = new ArrayList<Integer>();
            tempList.add(list.get(i));
            newList.add(tempList);
//            System.out.println(tempList);
        }
        System.out.println(newList);


        List sortedList = new ArrayList<Integer>();
        while (sortedList.size() < list.size()) {
            int pos = 0;
            List sortedSmallList = new ArrayList<Integer>();
            while (pos + 1 < newList.size()) {
                List tempList = new ArrayList<Integer>();
                tempList = mergeSort((List) newList.get(pos), (List) newList.get(pos+1));
                sortedSmallList.add(tempList);
                pos += 2;
            }

            sortedList = (List) sortedSmallList.get(0);

            newList = sortedSmallList;
//            System.out.println("sortedList" + sortedList.size());
        }
        list = sortedList;
    }

    private List mergeSort(List firstList, List secList) {
        List<Integer> sortedList = new ArrayList<Integer>();
        while (firstList.size()!=0 && secList.size()!=0) {
            int firstNum = (Integer) firstList.get(0);
            int secNum = (Integer) secList.get(0);
            if (firstNum <= secNum) {
                sortedList.add(firstNum);
                firstList.remove(0);
            } else {
                sortedList.add(secNum);
                secList.remove(0);
            }
        }
        while (firstList.size()!=0) {
            int num = (Integer) firstList.get(0);
            sortedList.add(num);
            firstList.remove(0);
        }

        while (secList.size()!=0) {
            int num = (Integer) secList.get(0);
            sortedList.add(num);
            secList.remove(0);
        }
        return sortedList;
    }

}
