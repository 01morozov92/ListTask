package vitya;

import java.util.Arrays;
import java.util.List;

public class IfLoop {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alexandr", "Ilya", "Victor");
        List<String> spisochek = Arrays.asList("Alexandra", "Maks", "Valentin");
        List<String> names3 = Arrays.asList("Alexandrino", "Ilyambo", "Victoria");

        findNameWithSomeWord(names, "l");
        findNameWithSomeWord(spisochek, "M");
        findNameWithSomeWord(names3, "o");
        Test2(names);
        Test3(names);
    }

    public static void test(int x, int y){
        System.out.println(x+y);
    }

    public static void findNameWithSomeWord(List<String> someList, String word) { // Arrays.asList("Alexandra", "Maks", "Valentin");
        for (int i = 0; i < someList.size(); i++) {
            if (someList.get(i).contains(word)) {
                System.out.println(someList.get(i));
            }
        }
    }

    static void Test2(List<String> someList) {
        for (int i = 0; i < someList.size(); i++) {
            if (someList.get(i).contains("Victor")) {
                System.out.println(someList.get(i));
            }
        }
    }
    static void Test3(List<String> someList){
        for (int i = 0; i < someList.size(); i++) {
            if (someList.get(i).length()<6) {
                System.out.println(someList.get(i));
            }
        }
    }
}