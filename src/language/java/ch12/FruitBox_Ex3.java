package language.java.ch12;

import java.util.ArrayList;
import java.util.List;

// 와일드카드에 대해서
// 그것도 ? extends T 로 와일드카드의 상한을 제한하는 것을 알아보자
public class FruitBox_Ex3 {
    private static class Fruit { public String toString() {
            return "Fruit";
        }}

    private static class Apple extends Fruit { public String toString() {
            return "Apple";
        }}

    private static class Grape extends Fruit { public String toString() {
            return "Grape";
        }}


    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>(); // Fruit을 넣을 Box를 만든다.
        FruitBox<Apple> appleBox = new FruitBox<Apple>(); // 사과를 넣을 박스를 만든다.

        fruitBox.addItem(new Apple());
        fruitBox.addItem(new Grape());
        appleBox.addItem(new Apple());
        appleBox.addItem(new Apple());

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox));
    }

    private static class Juicer {
        static Juice makeJuice(FruitBox<? extends Fruit> box) {
            StringBuilder sb = new StringBuilder();
            for (Fruit fruit : box.getList()) {
                sb.append(fruit).append(" ");
            }
            return new Juice(sb.toString());
        }
    }

    private static class Juice {
        private String name;

        public Juice(String name) {
            this.name = name + "Juice";
        }

        public String toString() {
            return name;
        }
    }

    // FruitBox 클래스에 들어올 수 있는 타입은 Fruit이고 Eatble 인터페이스를 상속한 것이어야만 해!
    private static class FruitBox<T extends Fruit> extends Box<T> {}

    private static class Box<T> {
        List<T> list = new ArrayList<>();

        List<T> getList() {
            return this.list;
        }

        void addItem(T item) {
            list.add(item);
        }

        T get(int i) {
            return list.get(i);
        }

        int size() {
            return list.size();
        }

        public String toString() {
            return list.toString();
        }
    }
}
