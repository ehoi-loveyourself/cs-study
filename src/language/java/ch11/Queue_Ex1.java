package language.java.ch11;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue_Ex1 {
    static Queue<String> q = new LinkedList<>();
    static final int MAX_SIZE = 5;

    public static void main(String[] args) {
        System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");

        while (true) {
            System.out.println(">>");
            try {
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine().trim();

                if ("".equals(input)) continue;

                if (input.equalsIgnoreCase("q")) {
                    System.exit(0);
                } else if (input.equalsIgnoreCase("help")) {
                    System.out.println(" help - 도움말을 보여줍니다.");
                    System.out.println(" q 또는 Q - 프로그램을 종료합니다.");
                    System.out.printf(" history - 최근 입력한 명령어를 %d개 보여줍니다.\n", MAX_SIZE);
                } else if (input.equalsIgnoreCase("history")) {
                    // 입력받은 명령어 저장
                    save(input);

                    // 큐에 담긴 내용을 보여준다.
                    LinkedList<String> list = (LinkedList<String>) q;
                    Iterator<String> it = list.iterator();

                    int idx = 1;
                    while (it.hasNext()) {
                        System.out.printf("%d.%s\n", idx++, it.next());
                    }
                } else {
                    save(input);
                    System.out.println(input);
                }
            } catch (Exception e) {
                System.out.println("입력 오류 입니다.");
            }
        }
    }

    private static void save(String input) {
        // 큐에 저장한다.
        q.add(input);
        // 최대 크기를 넘으면 맨 처음 것을 삭제 한다.
        if (q.size() > MAX_SIZE) {
            q.poll();
        }
    }
}
