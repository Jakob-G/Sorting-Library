package ca.bcit;
import java.util.ArrayList;
import java.util.List;


public class countingSort implements sorter{

    /**
     *
     * @param list - the list you want to be sorted
     * @return list - the sorted list
     */
    public List sort(List<Integer> list) {
        List<Integer> newList = new ArrayList<Integer>();

        for(Integer x:list){
            if (newList.size()<x+1){
                for(int n=newList.size();n<x+1;n++){
                    newList.add(0);
                }
            }
            newList.set(x,newList.get(x)+1);
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
}

