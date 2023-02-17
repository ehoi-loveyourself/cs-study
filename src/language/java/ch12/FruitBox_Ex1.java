package language.java.ch12;

import java.util.ArrayList;
import java.util.List;

// 제너릭스에 대해 개념을 살펴보
public class FruitBox_Ex1 {
    private static class Fruit { public String toString() { return "Fruit"; }}

    private static class Apple extends Fruit { public String toString() {return "Apple";}}

    private static class Grape extends Fruit { public String toString() {return "Grape";}}

    private static class Toy { public String toString() {return "Toy";}}

    public static void main(String[] args) {
        Box<Fruit> fruitBox = new Box<Fruit>(); // Fruit을 넣을 Box를 만든다.
        Box<Apple> appleBox = new Box<Apple>(); // 사과를 넣을 박스를 만든다.
        Box<Toy> toyBox = new Box<Toy>();
//        Box<Grape> grapeBox = new Box<Apple>(); // 타입이 일치하지 않아서 에러
//        Box<Fruit> appleBox2 = new Box<Apple>(); // 상속 관계에 있지만 타입이 다르므로 에러

        fruitBox.addItem(new Fruit());
        fruitBox.addItem(new Apple()); // addItem(Fruit item) 이기 때문에

        appleBox.addItem(new Apple());
//        appleBox.addItem(new Toy()); // 사과박스에는 사과만 담을 수 있음

        toyBox.addItem(new Toy());
//        toyBox.addItem(new Apple()); // 이 역시 에러

        System.out.println(fruitBox); // [Fruit, Apple]
        System.out.println(appleBox); // [Apple]
        System.out.println(toyBox); // [Toy]
    }

    private static class Box<T> {
        List<T> list = new ArrayList<>();
        void addItem(T item) {list.add(item);}
        T get(int i) {return list.get(i);}

        int size() {return list.size();}

        public String toString() {return list.toString();}
    }
}
