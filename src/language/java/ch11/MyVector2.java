package language.java.ch11;

import java.util.Iterator;

public class MyVector2 extends MyVector implements Iterator {
    int cursor = 0; // 앞으로 읽어올 위치
    int lastRet = -1; // 마지막으로 읽어온 요소의 위치

    public MyVector2(int capacity) {
        super(capacity);
    }

    public MyVector2() {
        this(10);
    }

    @Override
    public String toString() {
        String tmp = "";
        Iterator it = iterator();

        for (int i = 0; it.hasNext(); i++) {
            if (i != 0) tmp += ",";
            tmp += it.next();
        }

        return "[" + tmp + "]";
    }

    public Iterator iterator() {
        cursor = 0; // 초기화 하기
        lastRet = -1;
        return this;
    }

    @Override
    public boolean hasNext() {
        return cursor != size();
    }

    @Override
    public Object next() {
        lastRet = cursor++;
        return get(cursor);
    }

    @Override
    public void remove() {
        // 더이상 삭제할 것이 없으면
        if (lastRet == -1) {
            throw new IllegalStateException();
        } else {
            remove(lastRet);
            cursor--;
            lastRet = -1;
        }
    }
}
