package Sorters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class BubbleSort {

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

    }
}