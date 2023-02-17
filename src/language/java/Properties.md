# Properties

- HashMap의 구버전인 Hashtable을 상속받아 구현한 것
- Hashtable은 (Object, Object) 형태로 저장하는데 반면 Properties는 (String, String) 로 저장
- 주로 어플리케이션 환경설정과 관련된 속성(property)를 저장하는데 사용

### 활용 예시

잘 감이 안 오므로 코드로 살펴보자

```java
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
```

실행결과

```
capacity:10
size:10
timeout:30
language:kr

size=20
capacity=10  <-- capacity가 없으면 20을 가져오라고 했지만, 기존의 값이 있어서 그대로 10을 반환했다.
loadfactor=0.75  <-- loadfactor라는 key가 없었으므로 0.75라는 값을 리턴했다.

== 전체 출력 ==
{size=20, language=kr, timeout=30, capacity=10}  <-- 근데 전체출력할 때 loadfactor는 없다.

prop.list(System.out) 메서드 활용
-- listing properties --
size=20
language=kr
timeout=30
capacity=10
```

### 활용 예시 2

시스템 속성을 가져오는 예제이다.

System.getProperties()를 통해 시스템 속성을 가져올 수 있다.

```java
import java.util.Properties;

public class Properties_Ex2 {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        System.out.println("java.version : " + properties.getProperty("java.version"));
        System.out.println("user.language : " + properties.getProperty("user.language"));
        properties.list(System.out);
    }
}
```

실행 결과