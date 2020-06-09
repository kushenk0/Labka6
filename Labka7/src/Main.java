/**
 * 9217
 * c2-1
 * c3-1
 */

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Flowers a = new Flowers(1, 2, 3);
        Flowers b = new Flowers(4, 5, 6);
        Flowers c = new Flowers(7, 8, 9);

        Set<Flowers> flowersSet = new MyLinkedSet<>();

        flowersSet.add(a);
        flowersSet.add(b);
        flowersSet.add(c);
        flowersSet.add(a);
        flowersSet.add(b);

        System.out.println("1):");
        for (Flowers flowers : flowersSet) {
            System.out.println(flowers);
        }

        flowersSet.remove(b);

        System.out.println();
        System.out.println("2):");
        for (Flowers flowers : flowersSet) {
            System.out.println(flowers);
        }
    }
}
