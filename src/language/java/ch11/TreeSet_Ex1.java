package language.java.ch11;

import java.util.TreeSet;

public class TreeSet_Ex1 {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();

        String from = "b";
        String to = "d";

        set.add("abd");
        set.add("alien");
        set.add("bat");
        set.add("car");
        set.add("Car");
        set.add("disc");
        set.add("dance");
        set.add("dZZZ");
        set.add("dzzz");
        set.add("elephant");
        set.add("elevator");
        set.add("fan");
        set.add("flower");

        System.out.println(set);
        System.out.printf("range search : from %s to %s\n", from, to);
        System.out.println("result1 : " + set.subSet(from, to)); // result1 : [bat, car]
        System.out.println("result2 : " + set.subSet(from, to + "zzz")); // result2 : [bat, car, dZZZ, disc, dance]
    }
}
