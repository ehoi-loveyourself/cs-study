package language.java.ch11;

import java.util.HashSet;
import java.util.Set;

public class HashSet_Ex3 {
    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();
        set.add(new Person("Belle", 29));
        set.add(new Person("Belle", 29));
        set.add(new Person("David", 10));
        set.add(new Person("David", 10));
        set.add(1);
        set.add(1);

        System.out.println(set);
        // [1, Person{name='Belle', age=29}, Person{name='David', age=10}, Person{name='David', age=10}, Person{name='Belle', age=29}]
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
