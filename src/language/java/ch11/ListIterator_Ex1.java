package language.java.ch11;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIterator_Ex1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " "); // 1 2 3 4 5
        }
        System.out.println("\n====구분선====");

        while (it.hasPrevious()) {
            System.out.print(it.previous() + " "); // 5 4 3 2 1
        }
    }
}
