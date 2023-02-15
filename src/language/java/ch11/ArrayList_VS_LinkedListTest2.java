package language.java.ch11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayList_VS_LinkedListTest2 {
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>(1_000_000);
        List<Integer> ll = new LinkedList<>();

        add(al);
        add(ll);

        System.out.println("== 접근 시간 테스트 ==");
        System.out.println("ArrayList : " + access(al));
        System.out.println("LinkedList : " + access(ll));
    }

    private static void add(List<Integer> list) {
        for (int i = 0; i < 100_000; i++) {
            list.add(i);
        }
    }

    private static long access(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
