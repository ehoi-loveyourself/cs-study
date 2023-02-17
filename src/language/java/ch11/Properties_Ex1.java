package language.java.ch11;

import java.util.Enumeration;
import java.util.Properties;

public class Properties_Ex1 {
    public static void main(String[] args) {
        Properties prop = new Properties();

        prop.setProperty("timeout", "30");
        prop.setProperty("language", "kr");
        prop.setProperty("size", "10");
        prop.setProperty("capacity", "10");

        Enumeration<?> enumeration = prop.propertyNames(); // 오 Enumeration을 반환하는구나

        while (enumeration.hasMoreElements()) {
            String element = String.valueOf(enumeration.nextElement());
            System.out.println(element + ":" + prop.getProperty(element));
        }
        System.out.println();

        prop.setProperty("size", "20");
        System.out.println("size=" + prop.getProperty("size"));
        System.out.println("capacity=" + prop.getProperty("capacity", "20"));
        System.out.println("loadfactor=" + prop.getProperty("loadfactor", "0.75"));
        System.out.println();

        System.out.println("== 전체 출력 ==");
        System.out.println(prop);
        System.out.println();

        System.out.println("prop.list(System.out) 메서드 활용");
        prop.list(System.out);
    }
}
