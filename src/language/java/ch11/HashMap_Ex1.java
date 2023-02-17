package language.java.ch11;

import java.util.*;

public class HashMap_Ex1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("김자바", 100); // map에 저장하는 메서드
        map.put("이자바", 90);
        map.put("박자바", 80);
        map.put("최자바", 70);
        map.put("전자바", 60);

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();// 맵의 key와 value를 같이 담은 entry를 반환받아 각 요소에 접근할 수 있도록 iterator()를 반환한다.
        while (it.hasNext()) {
            Map.Entry<String, Integer> next = it.next();
            System.out.printf("%s의 점수는 %d입니다.\n", next.getKey(), next.getValue());
        } // map을 순회하며 key와 value에 접근할 수 있다.

        System.out.println(" == 명단 == ");
        for (String name : map.keySet()) { // key의 집합만 꺼내 접근할 수 있다.
            System.out.println(name);
        }

        Collection<Integer> values = map.values(); // values는 컬렉션 인터페이스를 반환한다.
        Iterator<Integer> iterator = values.iterator();
        int totalSum = 0;
        while (iterator.hasNext()) {
            totalSum += iterator.next();
        }
        System.out.println(" == 점수 == ");
        System.out.println("총점 : " + totalSum);
        System.out.println("평균 : " + (float) totalSum / map.size());
        System.out.println("최고 점수 : " + Collections.max(values)); // 컬렉션에서 가장 큰 값을 반환
        System.out.println("최저 점수 : " + Collections.min(values)); // 컬렉션에서 가장 작은 값을 반환
    }
}
