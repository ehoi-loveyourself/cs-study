package language.java.ch12;

import java.util.ArrayList;
import java.util.List;

// 제너릭스에 대해 개념을 살펴보자
public class FruitBox_Ex2 {
    private static class Fruit implements Eatable {
        public String toString() {
            return "Fruit";
        }
    }

    private interface Eatable {}

    private static class Apple extends Fruit {
        public String toString() {
            return "Apple";
        }
    }

    private static class Grape extends Fruit {
        public String toString() {
            return "Grape";
        }
    }

    private static class Toy {
        public String toString() {
            return "Toy";
        }
    }

    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<Fruit>(); // Fruit을 넣을 Box를 만든다.
        FruitBox<Apple> appleBox = new FruitBox<Apple>(); // 사과를 넣을 박스를 만든다.
        FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//        FruitBox<Toy> toyBox = new FruitBox<Toy>(); // 에러
//        Box<Grape> grapeBox = new Box<Apple>(); // 타입이 일치하지 않아서 에러
//        Box<Fruit> appleBox2 = new Box<Apple>(); // 상속 관계에 있지만 타입이 다르므로 에러

        fruitBox.addItem(new Fruit());
        fruitBox.addItem(new Apple()); // addItem(Fruit item) 이기 때문에
        fruitBox.addItem(new Grape());

        appleBox.addItem(new Apple());
//        appleBox.addItem(new Grape()); // 포도는 사과의 자손이 아니기 때문에 에러
//        appleBox.addItem(new Toy()); // 사과박스에는 사과만 담을 수 있음

        grapeBox.addItem(new Grape());

        System.out.println(fruitBox); // [Fruit, Apple, Grape]
        System.out.println(appleBox); // [Apple]
        System.out.println(grapeBox); // [Grape]
    }

    // FruitBox 클래스에 들어올 수 있는 타입은 Fruit이고 Eatble 인터페이스를 상속한 것이어야만 해!
    private static class FruitBox<T extends Fruit & Eatable> extends Box<T> {}

    private static class Box<T> {
        List<T> list = new ArrayList<>();
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
