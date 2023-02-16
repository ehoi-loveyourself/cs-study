package language.java.ch11;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack extends Vector {
    public Object push(Object obj) {
        addElement(obj);
        return obj;
    }

    public Object pop() {
        Object obj = peek();
        // 마지막 요소 삭제
        // 만일 스택이 비어있으면 peek() 메서드에서 exception을 발생시킨다.
        removeElement(size() - 1);
        return obj;
    }

    public Object peek() {
        int len = size();

        if (len == 0) {
            throw new EmptyStackException();
        }
        return elementAt(len - 1);
    }

    public boolean empty() {
        return size() == 0;
    }

    public int search(Object obj) {
        int i = lastIndexOf(obj);

        if (i >= 0) return size() - i;

        return -1;
    }
}
