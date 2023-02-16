package language.java.ch11;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSet_Ex4 {
    public static void main(String[] args) {
        Set set = new HashSet<>();
        set.add(new Person("Belle", 29));
        set.add(new Person("Belle", 29));
        set.add(new Person("David", 10));
        set.add(new Person("David", 10));
        set.add(1);
        set.add(1);

        System.out.println(set);
        // [Person{name='Belle', age=29}, 1, Person{name='David', age=10}]
    }

    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Person) {
                Person obj = (Person) o;
                return this.name.equals(obj.name) && this.age == obj.age;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
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
