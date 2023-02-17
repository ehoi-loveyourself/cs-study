# HashMap과 TreeMap

## HashMap

- Hashtable : HashMap = Vector : ArrayList 의 관계식을 가진다고 보면 된다.
    - 그러므로 HashMap을 사용하자!
- Map을 구현했으므로 key, value를 묶어서 하나의 entry로 저장한다는 특징이 있다.
    - key : 컬렉션 내의 키 중에서 유일해야 한다.
    - value : 키와 달리 중복을 허용한다.

    ```java
    import java.util.HashMap;
    
    public class HashMap_Ex1 {
        public static void main(String[] args) {
            HashMap<String, String> map = new HashMap<>();
            map.put("asdf", "1234");
            map.put("asdf", "4567");
            map.put("apple", "0987");
    
            System.out.println(map.entrySet()); // [apple=0987, asdf=4567]
        }
    }
    ```

  키를 중복하여 넣게 되면 기존의 value를 덮어쓰고, 마지막 넣은 value 값이 저장된다.

- 해싱(hashing)을 사용하여 많은 데이터를 검색할 때 성능이 뛰어나다.

### 기본적인 메서드

코드로 작성하면서 알아보자

```java
import java.util.*;

public class HashMap_Ex1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("김자바", 100); // map에 저장하는 메서드
        map.put("이자바", 90);
        map.put("박자바", 80);
        map.put("최자바", 70);
        map.put("전자바", 60);

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();// 맵의 key와 value를 같이 담은 entry를 반환받아 각 요소에 접근할 수 있도록 iterator()를 반환한다.
        while (it.hasNext()) {
            Map.Entry<String, Integer> next = it.next();
            System.out.printf("%s의 점수는 %d입니다.\n", next.getKey(), next.getValue());
        } // map을 순회하며 key와 value에 접근할 수 있다.

        System.out.println(" == 명단 == ");
        for (String name : map.keySet()) { // key의 집합만 꺼내 접근할 수 있다.
            System.out.println(name);
        }

        Collection<Integer> values = map.values(); // values는 컬렉션 인터페이스를 반환한다.
        Iterator<Integer> iterator = values.iterator();
        int totalSum = 0;
        while (iterator.hasNext()) {
            totalSum += iterator.next();
        }
        System.out.println(" == 점수 == ");
        System.out.println("총점 : " + totalSum);
        System.out.println("평균 : " + (float) totalSum / map.size());
        System.out.println("최고 점수 : " + Collections.max(values)); // 컬렉션에서 가장 큰 값을 반환
        System.out.println("최저 점수 : " + Collections.min(values)); // 컬렉션에서 가장 작은 값을 반환
    }
}
```

실행결과는 다음과 같다.

```
김자바의 점수는 100입니다.
박자바의 점수는 80입니다.
최자바의 점수는 70입니다.
이자바의 점수는 90입니다.
전자바의 점수는 60입니다.
 == 명단 == 
김자바
박자바
최자바
이자바
전자바
 == 점수 == 
총점 : 400
평균 : 80.0
최고 점수 : 100
최저 점수 : 60
```

### 활용 예시 1

HashMap은 키와 값을 모두 Object 타입으로 저장하기 때문에 HashMap의 value 값을 또다시 HashMap으로 저장할 수 있다.

다음 예시는 그룹 - 전화번호 - 이름 계층으로 이루어진 전화번호부를 구현해본 것이다.

```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap_Ex2 {
    static HashMap<String, HashMap<String, String>> phoneBook = new HashMap<>();
    public static void main(String[] args) {
        addPhoneNo("친구", "김자바", "010-1111-1111");
        addPhoneNo("친구", "이자바", "010-2222-2222");
        addPhoneNo("회사", "최자바", "010-3333-3333");
        addPhoneNo("회사", "박자바", "010-4444-4444");
        addPhoneNo("택배", "010-5555-5555");

        printPhoneBook();
    }

    private static void addPhoneNo(String groupName, String name, String phoneNo) {
        /* 이렇게 해도 되겠지만 코드의 가독성이 좋지 않으므로 수정하도록 하자 */
        // HashMap<String, String> group = phoneBook.getOrDefault(groupName, new HashMap<String, HashMap<String, String>>().put(groupName, new HashMap<>()));
        addGroup(groupName);
        HashMap<String, String> group = phoneBook.get(groupName);
        group.put(phoneNo, name); // 이름을 key로 하면 중복될 수 있다.
    }

    private static void addPhoneNo(String name, String phoneNo) {
        addPhoneNo("기타", name, phoneNo);
    }

    private static void addGroup(String groupName) {
        if (!phoneBook.containsKey(groupName)) {
            phoneBook.put(groupName, new HashMap<>());
        }
    }

    private static void printPhoneBook() {
        // 1. 여기서는 iterator 를 달아서 각 요소에 접근했고 
        Iterator<Map.Entry<String, HashMap<String, String>>> it = phoneBook.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, HashMap<String, String>> group = it.next();

            Set<Map.Entry<String, String>> cntByGroup = group.getValue().entrySet();
            System.out.printf("* %s[%d]\n", group.getKey(), cntByGroup.size());

            // 2. 여기서는 enhanced for 문을 이용해서 각 요소에 접근한다.
            for (Map.Entry<String, String> one : cntByGroup) {
                System.out.printf("%s %s\n", one.getKey(), one.getValue());
            }
            System.out.println();
        }
    }
}
```

실행결과

```
* 기타[1]
010-5555-5555 택배

* 친구[2]
010-1111-1111 김자바
010-2222-2222 이자바

* 회사[2]
010-4444-4444 박자바
010-3333-3333 최자바
```

### 활용 예시 2

아래의 배열에 있는 문자가 모두 몇 개나 있는지 문자와 값을 각각 출력하고 그 값만큼 #을 함께 출력하는 예시다.

범위가 명확하다면 cnt 배열을 사용해 빈도수를 측정하겠지만, 범위가 불명확하다면 HashMap을 이용하여 구할 수 있다.

(그리고 아래쪽에는 인텔리제이가 알려주는 기능을 이용해 계속 리팩터링을 거쳤던 과정을 기억하고 싶어 기록해두었다.)

```java
import java.util.HashMap;
import java.util.Map;

public class HashMap_Ex3 {
    public static void main(String[] args) {
        String[] data = {"A", "D", "Z", "K", "A", "K", "A", "K", "D", "K", "K", "K"};

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : data) {
            map.put(str, map.getOrDefault(str, 0) + 1); // map.get(str)의 값이 없다면 기본값으로 0을 가져오라는 뜻이다.
        }
        
        for (Map.Entry<String, Integer> one : map.entrySet()) {
            System.out.printf("%s : %s %d\n", one.getKey(), printChar(one.getValue()), one.getValue());
        }
    }

    // 4. 리팩터링을 마친 메서드
    private static String printChar(int num) {
        return "#".repeat(Math.max(0, num));
    }
    
    /*
    // 3. 세번째로 변경한 메서드
    private static String printChar(int num) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("#".repeat(Math.max(0, num)));
        return tmp.toString();
    }
    
    // 2. 두번째로 변경한 메서드
    private static String printChar(int num) {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < num; i++) {
            tmp.append("#");
        }
        return tmp.toString();
    }
    
    // 1. 처음 작성한 메서드
    private static String printChar(int num) {
        String tmp = "";
        for (int i = 0; i < num; i++) {
            tmp += "#";
        }
        return tmp;
    }
     */
}
```

실행결과

```
A : ### 3
D : ## 2
Z : # 1
K : ###### 6
```

## TreeMap

- 이진 검색 트리와 Map의 만남이다.
- 검색에 관한 부분은 HashMap이, 범위검색이나 정렬에 관한 부분은 TreeMap이 더 뛰어나다.

### 활용 예시

HashMap에서 활용했던 예시를 가지고 TreeMap을 활용해보자.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeMap_Ex1 {
    public static void main(String[] args) {
        String[] data = {"A", "D", "Z", "K", "A", "K", "A", "K", "D", "K", "K", "K"};

        TreeMap<String, Integer> map = new TreeMap<>();
        for (String str : data) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        System.out.println(" == 기본 정렬 == ");
        // 자동으로 정렬이 되기 때문에 아무 것도 하지 않아도 정렬된 형태로 나온다.
        // Key를 기준으로 오름차순 정렬된다.
        for (Map.Entry<String, Integer> one : map.entrySet()) {
            System.out.printf("%s : %s %d\n", one.getKey(), printChar(one.getValue()), one.getValue());
        }
        System.out.println();

        System.out.println(" == 값에 따른 정렬 == ");
        // sort() 를 사용하기 위해 List 형태로 변환
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(((o1, o2) -> {
            // 그리고 이 엔트리의 값이 큰 것부터 정렬할 거야
            int v1 = (int) o1.getValue();
            int v2 = (int) o2.getValue();

            return v2 - v1;
        }));

        for (Map.Entry<String, Integer> one : list) {
            System.out.printf("%s : %s %d\n", one.getKey(), printChar(one.getValue()), one.getValue());
        }
    }

    private static String printChar(Integer value) {
        return "#".repeat(value);
    }
}
```

- TreeMap을 사용하면 Key를 기준으로 오름차순으로 정렬해준다.
- 값으로 정렬하고 싶다면 Comparator를 구현해야 한다.

```
== 기본 정렬 == 
A : ### 3
D : ## 2
K : ###### 6
Z : # 1

 == 값에 따른 정렬 == 
K : ###### 6
A : ### 3
D : ## 2
Z : # 1
```

## Reference
- 자바의 정석