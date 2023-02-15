package language.java.ch11;

import java.util.*;

public class MyVector implements List {
    private Object[] data;
    private int capacity;
    private int size;

    public MyVector() {
        this(10);
    }

    public MyVector(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("유효하지 않은 값입니다. : " + capacity);
        }
        this.capacity = capacity;
        data = new Object[capacity];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object datum : data) {
            if (datum.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);

        return result;
    }

    @Override
    public boolean add(Object o) {
        // 저장공간을 확보하고 난 다음에
        ensureCapacity(size + 1); // 하나를 더 집어넣는 거니까 지금 size 보다 1만큼 더 큰지 확인
        // 집어넣기
        data[size++] = o;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
        if (data.length < minCapacity) {
            // 최소 요구 조건보다 지금 배열이 더 작으면
            setCapacity(minCapacity);
        }
    }

    private void setCapacity(int minCapacity) {
        if (capacity == minCapacity) return; // 지금 수용조건이랑 크기가 같으면 변경할 필요 없음

        Object[] tmp = new Object[minCapacity];
        System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
        capacity = minCapacity;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(data, null);
        size = 0;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) { // 대체하는 것
        return data[index] = element;
    }

    @Override
    public void add(int index, Object element) {
        // 하나씩 뒤로 미루기 위해서
        // 사이즈를 늘리자
        ensureCapacity(size + 1);
        for (int i = size - 2; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
    }

    @Override
    public Object remove(int index) {
        // index가 범위를 벗어났다면?
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
        }

        Object oldObj = data[index];

        // 마지막 객체가 아니라면
        if (index != size - 1) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
        }
        data[size - 1] = null; // 마지막 애 지워주고
        size--; // 사이즈도 빼주고

        return oldObj;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < data.length; i++) {
            if (o.equals(data[i])) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = data.length - 1; i >= 0; i--) {
            if (o.equals(data[i])) return i;
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
