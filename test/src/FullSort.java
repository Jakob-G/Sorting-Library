import edu.princeton.cs.algs4.Stopwatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


public class FullSort {

    public List list = new ArrayList<Integer>();

    protected void load(){
        try (Stream<String> stream = Files.lines(Paths.get("numbers.txt"))) {
            stream.forEach(x -> list.add(Integer.parseInt(x)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void test(){
        Stopwatch watch = new Stopwatch();
        for (int i=0; i<1000; i++){
            Collections.shuffle(list, new Random(100));
            sort(list);
        }
        System.out.println(watch.elapsedTime());
        Stopwatch compare = new Stopwatch();
        for (int i=0; i<1000; i++){
            Collections.shuffle(list, new Random(100));
            Collections.sort(list);
        }
        System.out.println(compare.elapsedTime());
    }


    private void sort(List list){
        List listForEveryNum = new ArrayList();

        for(int i = 0; i < list.size(); ++i) {
            List tempList = new ArrayList();
            tempList.add(list.get(i));
            listForEveryNum.add(tempList);
        }

        ArrayList sortedSmallList;
        for(Object sortedList = new ArrayList();
            ((List)sortedList).size() != list.size();
            sortedList = (List)sortedSmallList.get(0)) {
            int pos = 0;

            for(sortedSmallList = new ArrayList(); pos + 1 < listForEveryNum.size(); pos += 2) {
                new ArrayList();
                List tempList = this.mergeSort((List)listForEveryNum.get(pos), (List)listForEveryNum.get(pos + 1));
                sortedSmallList.add(tempList);
            }

            System.out.println(sortedSmallList);
            listForEveryNum = sortedSmallList;
        }

    }

    private List mergeSort(List firstList, List secList) {
        ArrayList sortedList = new ArrayList();

        int num;
        while(firstList.size() != 0 && secList.size() != 0) {
            num = (Integer)firstList.get(0);
            int secNum = (Integer)secList.get(0);
            if (num <= secNum) {
                sortedList.add(num);
                firstList.remove(0);
            } else {
                sortedList.add(secNum);
                secList.remove(0);
            }
        }

        while(firstList.size() != 0) {
            num = (Integer)firstList.get(0);
            sortedList.add(num);
            firstList.remove(0);
        }

        while(secList.size() != 0) {
            num = (Integer)secList.get(0);
            sortedList.add(num);
            secList.remove(0);
        }

        return sortedList;
    }

}