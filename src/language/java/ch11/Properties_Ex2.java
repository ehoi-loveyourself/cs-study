package language.java.ch11;

import java.util.Properties;

public class Properties_Ex2 {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        System.out.println("java.version : " + properties.getProperty("java.version"));
        System.out.println("user.language : " + properties.getProperty("user.language"));
        properties.list(System.out);
    }
}
