package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 14872kb
 * 156ms
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 우선순위 큐와 큐를 동시에 사용하여 비교대조
 * 우선순위 큐는 O(log n), 큐는 O(1)
 * 시간복잡도는 O(n log n)
 * 이번에 알았는데, 우선순위 큐란 추상적인 개념이며 그것을 구체화한 것이 완전이진트리의 최소힙 최대힙 이라고 합니다.
 --------------------------------------------------
 */
public class BOJ1966프린터큐 {
    private static class Document {
        int index; // 문서의 원래 인덱스
        int priority; // 문서의 우선순위

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int targetIndex = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            Deque<Document> queue = new LinkedList<>();

            //우선순위 큐에는 내림차순으로, 일반 큐에는 원래의 순서대로
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                int priority = Integer.parseInt(st.nextToken());
                pq.add(priority); // O(log n)
                queue.add(new Document(j, priority)); //O(1)
            }

            //최악의 경우 O(n log n)
            int count = 0;
            while (!queue.isEmpty()) {
                Document currentDoc = queue.peek();
                int needPriority = pq.peek();

                //우선순위 높은 것이 pq에 남아있으면 requeue
                if (currentDoc.priority < needPriority) {
                    queue.add(queue.poll());
                } else {
                    //타겟이 출력되면 종료
                    if (currentDoc.index == targetIndex) {
                        count++;
                        break;
                    }

                    queue.poll();
                    pq.poll();
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
