package zheka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZhekaTest {

    public static void main(String[] args) {
        List<List<Integer>> ListOfLists = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1, 16, 99);
        List<Integer> list2 = Arrays.asList(15, 1, 66);
        List<Integer> list3 = Arrays.asList(4, 17, 77);
        ListOfLists.add(list1);
        ListOfLists.add(list2);
        ListOfLists.add(list3);
        System.out.print(PrintAllNumbersBetween10and20(ListOfLists));
    }

    public static List<Integer> PrintAllNumbersBetween10and20(List<List<Integer>> ListOfLists) {
        ArrayList<Integer> targetList = new ArrayList<>();
        for (List<Integer> list : ListOfLists) {
            for (Integer i : list) {
                if (i > 10 && i < 20){
                    targetList.add(i);
                }
            }
        }
        return targetList;
    }
}
