package language.java.ch11;

import java.util.Arrays;
import java.util.Comparator;

public class Comparator_Ex1 {
    public static void main(String[] args) {
        String[] arr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(arr);
        System.out.println("1." + Arrays.toString(arr));

        Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분 안함
        System.out.println("2." + Arrays.toString(arr));

        Arrays.sort(arr, new Descending());
        System.out.println("3." + Arrays.toString(arr));
    }

    private static class Descending implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            if (o1 instanceof Comparable && o2 instanceof Comparable) {
                Comparable c1 = (Comparable) o1;
                Comparable c2 = (Comparable) o2;
                return c2.compareTo(c1);
            }
            return -1;
        }
    }
}
