package language.java.ch11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSet_Ex1 {
    public static void main(String[] args) {
        Object[] arr = {"1", 1, "2", "2", "2", "3", "3", "4", "4"};
        // 배열 형태의 arr를 컬렉션 프레임워크인 List로 바꾸어 set에 집어넣었다.
        Set<Object> set = new HashSet<>(Arrays.asList(arr));

        System.out.println(set); // [1, 1, 2, 3, 4] 하나는 Integer 1, 하나는 String 1이다. 서로 다름

    }
}
