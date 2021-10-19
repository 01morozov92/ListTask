package zheka;

import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 4, 2, 1, 3, 4, 5, 6, 7, 9, 9, 8, 2, 3, 4, 5, 6, 1);
        countNumbers(numbers);
        System.out.println(countNumbers(numbers));
    }

    public static Map<Integer, Integer> countNumbers(List<Integer> numbers) {
        Map<Integer, Integer> counter = new HashMap<>();
        //���������� � ��� ��������� ����� �� ������.
        for (Integer x : numbers) {//��� ������ �� �����
            if (!counter.containsKey(x)) {//����
                counter.put(x, 1);
            } else {
                counter.put(x, counter.get(x) + 1);
            }
        }
        return counter;
    }
}






































    /*public static Map<Integer, Long> getOrDeafault(List<Integer> numbers) {
        List<Integer> numbers2 = new ArrayList<>(numbers);
        for (Integer newList : numbers){

        }*/