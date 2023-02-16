# HashSet

- Set 인터페이스를 구현한 가장 대표적인 컬렉션
- Set처럼 중복 요소를 저장하지 않음
- HashSet도 저장 순서를 저장하지 않지만
- 저장 순서를 저장하고 싶다면 LinkedHashSet을 사용하면 됨

### Ex1

```java
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
```

set에 1이라는 요소가 중복해서 출력된다. 이는 하나는 Integer 타입, 하나는 String 타입으로 추가했기 때문에 중복으로 간주하지 않는다.

### Ex2

```java
import java.util.HashSet;
import java.util.Set;

public class HashSet_Ex2 {
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
```

Person 클래스를 구현하여 같은 사람을 중복해서 2번씩 넣어줬는데, 1은 중복을 제거하고 한번만 나온 반면, 이름이 belle, David인 인스턴스는 중복이 제거되지 않았다.

왜냐하면, 이 인스턴스를 다른 객체로 인지하고 있기 때문이다. 두 개의 인스턴스를 equals() 메서드를 이용해 확인해보면 false를 반환할 것이다.

그렇기에 equals() 메서드를 오버라이딩해주어야 한다.

### 오버라이딩

```java
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSet_Ex3 {
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
        ... 생략

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
        
        ... 생략
    }
}
```

이렇게 오버라이딩 해주면 중복을 제거하고 한번씩 나오는 것을 볼 수 있다!