package language.java.ch11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayList_VS_LinkedListTest {
    public static void main(String[] args) {
        // 단순히 저장하는 시간만 비교할 수 있도록 초기용량을 충분히 설정
        List<Integer> al = new ArrayList<>(2_000_000);
        List<Integer> ll = new LinkedList<>();

        System.out.println("== 순차적으로 추가하기 ==");
        System.out.println("ArrayList : " + add1(al));
        System.out.println("LinkedList : " + add1(ll));

        System.out.println("== 중간에 추가하기 ==");
        System.out.println("ArrayList : " + add2(al));
        System.out.println("LinkedList : " + add2(ll));

        System.out.println("== 중간에서 삭제하기 ==");
        System.out.println("ArrayList : " + remove2(al));
        System.out.println("LinkedList : " + remove2(ll));

        System.out.println("== 순차적으로 삭제하기 ==");
        System.out.println("ArrayList : " + remove1(al));
        System.out.println("LinkedList : " + remove1(ll));
    }

    private static long add1(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) list.add(i);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long add2(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000; i++) list.add(500, -1);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long remove1(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = list.size() - 1; i >= 0; i--) list.remove(i);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long remove2(List<Integer> list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000; i++) list.remove(i);
        long end = System.currentTimeMillis();
        return end - start;
    }
}
