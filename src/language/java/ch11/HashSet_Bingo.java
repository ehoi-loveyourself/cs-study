package language.java.ch11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSet_Bingo {
    public static void main(String[] args) {
        // 5 * 5 빙고판을 채우기 위해서
//        Set<Integer> set = new HashSet<>();
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; set.size() < 25; i++) {
            set.add((int)(Math.random() * 50) + 1);
        }

        Iterator<Integer> it = set.iterator();
        int[][] board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = it.next();
                System.out.print((board[i][j] >= 10 ? " " : "  ") + board[i][j]);
            }
            System.out.println();
        }
    }
}
