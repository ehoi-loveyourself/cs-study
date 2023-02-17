package language.java.ch11;

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
