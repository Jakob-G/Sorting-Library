package Sorters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.List;
import java.util.stream.Stream;

public class CountingSort {

    public List list = new ArrayList<Integer>();

    public void load(){
        try (Stream<String> stream = Files.lines(Paths.get("src\\Testers\\numbers.txt"))) {
            stream.forEach(x -> list.add(Integer.parseInt(x)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void test(){
            sort(list);
    }

    private void sort(List list){

        int length = list.size();
        List newList = new ArrayList<Integer>();

        for(int x=0;x<length;x++){
            if (newList.size()<(Integer)list.get(x)+1){
                for(int n=newList.size();n<(Integer)list.get(x)+1;n++){
                    newList.add(0);
                }
            }
            newList.set((Integer)list.get(x),(Integer)newList.get((Integer)list.get(x))+1);
        }
        int counter = 0;
        for(int i = 1;i<newList.size();i++){
            for(int x = 0;x<(Integer)newList.get(i);x++){
                list.set(counter,i);
                counter++;
            }
        }
    }
}

