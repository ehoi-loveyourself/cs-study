package language.java.ch11;

import java.util.TreeSet;

public class TreeSet_Ex2 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        int[] score = {80, 95, 50, 35, 45, 65, 10, 100};

        for (int i = 0; i < score.length; i++) {
            set.add(score[i]);
        }

        System.out.println("50보다 큰 값 : " + set.tailSet(50)); // [50, 65, 80, 95, 100]
        System.out.println("50보다 작은 값 : " + set.headSet(50)); // [10, 35, 45]
    }
}
