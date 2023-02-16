package language.java.ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSet_Lotto {
    public static void main(String[] args) {
        Set<Integer> lotto = new HashSet<>();

        for (int i = 0; lotto.size() < 6; i++) {
            lotto.add((int) (Math.random() * 45) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(lotto);
        Collections.sort(list);
        System.out.println(list);
    }
}
