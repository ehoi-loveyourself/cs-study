package language.java.ch11;

import java.util.HashMap;
import java.util.Map;

public class HashMap_Ex3 {
    public static void main(String[] args) {
        String[] data = {"A", "D", "Z", "K", "A", "K", "A", "K", "D", "K", "K", "K"};

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : data) {
            map.put(str, map.getOrDefault(str, 0) + 1); // map.get(str)의 값이 없다면 기본값으로 0을 가져오라는 뜻이다.
        }

        for (Map.Entry<String, Integer> one : map.entrySet()) {
            System.out.printf("%s : %s %d\n", one.getKey(), printChar(one.getValue()), one.getValue());
        }
    }

    // 4. 리팩터링을 마친 메서드
    private static String printChar(int num) {
        return "#".repeat(Math.max(0, num));
    }

    /*
    // 3. 세번째로 변경한 메서드
    private static String printChar(int num) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("#".repeat(Math.max(0, num)));
        return tmp.toString();
    }

    // 2. 두번째로 변경한 메서드
    private static String printChar(int num) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < num; i++) {
            tmp.append("#");
        }
        return tmp.toString();
    }

    // 1. 처음 작성한 메서드
    private static String printChar(int num) {
        String tmp = "";
        for (int i = 0; i < num; i++) {
            tmp += "#";
        }
        return tmp;
    }
     */
}
