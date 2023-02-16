package language.java.ch11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterator_Ex2 {
    public static void main(String[] args) {
        List<Integer> origin = new ArrayList<>();
        List<Integer> copy1 = new ArrayList<>();
        List<Integer> copy2 = new ArrayList<>();

        for (int i = 0; i < 10; i++)
            origin.add(i);

        Iterator<Integer> it = origin.iterator();
        while (it.hasNext()) {
            copy1.add(it.next());
        }

        System.out.println(" == origin에서 copy1으로 복사 ==");
        System.out.println("origin : " + origin);
        System.out.println("copy1 : " + copy1);

        it = origin.iterator();
        while (it.hasNext()) {
            copy2.add(it.next());
            it.remove(); // 복사하고 삭제
        }

        System.out.println(" == origin에서 copy2으로 이동 ==");
        System.out.println("origin : " + origin);
        System.out.println("copy2 : " + copy2);
    }
}
