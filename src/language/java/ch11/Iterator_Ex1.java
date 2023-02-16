package language.java.ch11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterator_Ex1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " "); // 1 2 3 4 5
        }
    }
}
