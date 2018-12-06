package ca.bcit;
import java.util.ArrayList;
import java.util.List;

public class fullSort implements sorter {

    /**
     ** The first loop in the method is basically making every
     *  items in the list to become a list itself.
     *  So for example if the list has 1000 items,
     *  the loop makes 1000 lists in that list.
     *
     * Inside the second loop we are constantly pairing up the indexes
     * next to each other using mergeSort() and then add them into a new list.
     *
     *
     * @param list - the list you want to be sorted
     * @return list - the sorted list
     */
    public List sort(List list){
        List newList = new ArrayList();


        for (int i =0; i < list.size(); i++) {
            List tempList = new ArrayList();
            tempList.add(list.get(i));
            newList.add(tempList);
        }


        List sortedList = new ArrayList();
        while (sortedList.size() < list.size()) {
            int pos = 0;
            List sortedSmallList = new ArrayList();

            if (newList.size()%2 != 0) {
                List tempList = new ArrayList();
                tempList = mergeSort((List) newList.get(pos), (List) newList.get(newList.size()-1));
                sortedSmallList.add(tempList);
                pos = 1;
            }
            while (pos < newList.size()) {
                List tempList = new ArrayList();
                tempList = mergeSort((List) newList.get(pos), (List) newList.get(pos+1));
                sortedSmallList.add(tempList);
                pos += 2;
            }
            sortedList = (List) sortedSmallList.get(0);
            newList = sortedSmallList;
        }
        return sortedList;
    }


    /**
     *
     * @param firstList - The first list of the two you want to pair up (has to be sorted && can be empty)
     * @param secList - The second list of the two you want to pair up (has to be sorted && can be empty)
     * @return - The sorted list that resulted from combining the 2 lists
     */
    private List mergeSort(List firstList, List secList) {
        ArrayList sortedList = new ArrayList();

        int num;
        while(firstList.size() != 0 && secList.size() != 0) {
            num = (Integer) firstList.get(0);
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
            num = (Integer) firstList.get(0);
            sortedList.add(num);
            firstList.remove(0);
        }

        while(secList.size() != 0) {
            num = (Integer) secList.get(0);
            sortedList.add(num);
            secList.remove(0);
        }

        return sortedList;
    }


}
