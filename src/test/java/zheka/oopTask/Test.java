package zheka.oopTask;

import zheka.oopTask.Hero;
import zheka.oopTask.Invoker;
import zheka.oopTask.Necrophos;
import zheka.oopTask.Pudge;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        Invoker invoker = new Invoker("Kael", "50", "100", "285");

        Invoker.builder()
                .name("Kael")
                .damage("50")
                .health("100")
                .speed("285")
                .build();

        ArrayList<Hero> heroes = new ArrayList<>();
//        heroes.add(new Invoker("Kael"));
        heroes.add(new Pudge("Big Fat Boy"));
        heroes.add(new Necrophos("Kel'tuzad"));
        System.out.println(printList(heroes));
    }

    public ArrayList<String> printList(ArrayList<Hero> heroes) {
        ArrayList<String> heroesWithMoreThen5Letters = new ArrayList<>();
        for (Hero hero : heroes) {
            if ((hero.getName().length()) > 5) {
                heroesWithMoreThen5Letters.add(hero.getName());
            }
        }
        return heroesWithMoreThen5Letters;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int sum = 0;
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
            if (array[i] % 4 == 0) {
                sum += array[i];
            }
        }
        System.out.println(sum);
    }

    @org.junit.jupiter.api.Test
    public void testDate() {
        LocalDateTime time = LocalDateTime.now();
        LocalDateTime lastQuarter = time.truncatedTo(ChronoUnit.HOURS)
                .plusMinutes(15 * (time.getMinute() / 15));
        System.out.println(lastQuarter);
        System.out.println();
    }

    public Map<Integer, Long> getOrDefaultMeth(List<Integer> list) {
        Map<Integer, Long> counter = new HashMap<>();
        for (Integer i : list) {
            Long newValue = counter.getOrDefault(i, 0L) + 1;
            counter.put(i, newValue);
        }
        return counter;
    }
}
