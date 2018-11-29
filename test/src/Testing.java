

public class Testing {

    public static void main(String args[]){
        try {
            Sorting sorting = new Sorting();
            sorting.load();
            //System.out.println(sorting.testList);
            sorting.test();
            //System.out.println(sorting.testList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
