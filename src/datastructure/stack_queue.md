### 스택 vs 큐

|  | 스택 | 큐 |
| --- | --- | --- |
| 개념 | 마지막에 저장된 데이터를 가장 먼저 꺼내는 LIFO 구조 | 먼저 저장된 데이터가 가장 먼저 나오는 FIFO 구조 |
| 예시 | 입구가 하나인 접시꽂이 | 입구와 출구가 정해져 있는 파이프 |
| 활용 | 괄호검사, undo/redo, 뒤로/앞으로 | 최근 사용 문서, 대기목록, 버퍼 |

### 우선순위 큐 (Priority Queue)

- Queue 인터페이스 중의 하나
- 저장한 순서에 관계없이 우선순위가 가장 높은 것부터 나옴
- 저장공간으로 배열을 사용하며
- 각 요소를 힙의 형태로 저장
    - JVM의 힙과는 전혀 다른 것이다.

### Deque(Double-Ended Queue)

- 덱 또는 디큐 라고 읽음
- 양쪽 끝으로 추가, 삭제가 가능하다.
- 구현체로는 ArrayDeque, LinkedList 등이 있다.

| Deque | Queue | Stack |
| --- | --- | --- |
| offerLast() | offer() | push() |
| pollFirst() | poll() |  |
| pollLast() |  | pop() |
| peekFirst() | peek() |  |
| peekLast() |  | peek() |