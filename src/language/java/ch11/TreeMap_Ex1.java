package language.java.ch11;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeMap_Ex1 {
    public static void main(String[] args) {
        String[] data = {"A", "D", "Z", "K", "A", "K", "A", "K", "D", "K", "K", "K"};

        TreeMap<String, Integer> map = new TreeMap<>();
        for (String str : data) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        System.out.println(" == 기본 정렬 == ");
        // 자동으로 정렬이 되기 때문에 아무 것도 하지 않아도 정렬된 형태로 나온다.
        // Key를 기준으로 오름차순 정렬된다.
        for (Map.Entry<String, Integer> one : map.entrySet()) {
            System.out.printf("%s : %s %d\n", one.getKey(), printChar(one.getValue()), one.getValue());
        }
        System.out.println();

        System.out.println(" == 값에 따른 정렬 == ");
        // sort() 를 사용하기 위해 List 형태로 변환
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(((o1, o2) -> {
            // 그리고 이 엔트리의 값이 큰 것부터 정렬할 거야
            int v1 = (int) o1.getValue();
            int v2 = (int) o2.getValue();

            return v2 - v1;
        }));

        for (Map.Entry<String, Integer> one : list) {
            System.out.printf("%s : %s %d\n", one.getKey(), printChar(one.getValue()), one.getValue());
        }
    }

    private static String printChar(Integer value) {
        return "#".repeat(value);
    }
}
