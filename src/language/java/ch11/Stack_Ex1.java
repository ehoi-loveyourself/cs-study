package language.java.ch11;

import java.util.Stack;

public class Stack_Ex1 {
    public static Stack<String> back = new Stack<>();
    public static Stack<String> forward = new Stack<>();

    public static void main(String[] args) {
        goURL("1.네이트");
        goURL("2.야후");
        goURL("3.네이버");
        goURL("4.다음");

        printStatus();

        goBack();
        System.out.println("= 뒤로 버튼을 누른 후 =");
        printStatus();

        goBack();
        System.out.println("= 뒤로 버튼을 누른 후 =");
        printStatus();

        goForward();
        System.out.println("= 앞으로 버튼을 누른 후 =");
        printStatus();

        goURL("codechobo.com");
        System.out.println("= 새로운 주소로 이동 후'");
        printStatus();
    }

    private static void goForward() {
        if (!forward.isEmpty()) {
            back.push(forward.pop());
        }
    }

    private static void goBack() {
        if (!back.isEmpty()) {
            forward.push(back.pop());
        }
    }

    private static void goURL(String url) {
        back.push(url); // 뒤로 가기 스택에 추가해줘
        if (!forward.isEmpty()) {
            forward.clear(); // 앞으로 가기 스택이 차 있으면 비워줘
        }
    }

    private static void printStatus() {
        System.out.println("back : " + back);
        System.out.println("forward : " + forward);
        System.out.println("현재 화면은 '" + back.peek() + "' 입니다.");
        System.out.println();
    }
}
