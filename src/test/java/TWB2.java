import java.util.Scanner;
class TWB2 {
    int max;
    int a[];
    public TWB2 (int max) {
        int a[] = new int[max];
        this.a = a;
        this.max = max;
    }
    public char yn() {
        Scanner s = new Scanner(System.in);
        System.out.print("Добавить новый шарик? Y/N: ");
        char yn = (char) s.next().charAt(0);
        return yn;
    }
    public int condition(int max) {
        System.out.print("Вот, что сейчас в трубке: ");
        int sum = 0;
        for (int i1 = 0; i1 < max; i1++) {
            System.out.print(a[i1] + " ");
            sum = sum + a[i1];
        }
        System.out.println();
        System.out.println("Сумма цифр шариков: " + sum);
        return a[max-1];
    }
    public int shift(int max) {
        Scanner s = new Scanner(System.in);
        System.out.print("Шарик с какой цифрой добавить? ");
        int number = s.nextInt();
        for (int i2 = max-1; i2 > 0; i2--) {
            a[i2] = a[i2-1];
        }
        a[0] = number;
        return a[max-1];
    }
}
class TubeWithBalls2 {
    public static void main(String[] args) {
        System.out.println("Трубка с шариками");
        System.out.print("Введите длину трубки в шариках: ");
        Scanner s = new Scanner(System.in);
        int max = s.nextInt();
        TWB2 twb2 = new TWB2(max);
        twb2.condition(max);
        if (twb2.yn() == 'Y') {
            do {
                twb2.shift(max);
                twb2.condition(max);
            } while (twb2.yn() != 'N');
        }
    }
}