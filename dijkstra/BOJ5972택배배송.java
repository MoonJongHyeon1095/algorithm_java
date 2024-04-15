package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 41188kb
 * 464ms
 *
 - 자주 사용하는 패턴 : 배열(List<Node>[] nodes) 의 인덱스가 시작 정점, Node 인스턴스가 도착 정점

 - 헛간 A와 B (1~N) (A!=B) 를 잇는 양방향 간선, 각 간선에 0~1000마리의 소
 - 두개의 헛간이 하나 이상의 간선으로 연결되어 있을 수 았다
 - 1 ->N 최소비용
 *
 */
public class BOJ5972택배배송 {
    static int N, M;
    static List<Node>[] nodes;
    static boolean[] visited;
    static int[] costArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //헛간 개수
        M = Integer.parseInt(st.nextToken()); //양방향 간선 개수
        nodes = new ArrayList[N+1];
        visited = new boolean[N+1];
        costArr = new int[N+1];

        // 1 <= A, B <= N
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
            costArr[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            //양방향
            nodes[from].add(new Node(to, cost));
            nodes[to].add(new Node(from, cost));
        }

        dijkstra(1);

        System.out.println(costArr[N]);

    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        costArr[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll(); // 최소 가중치를 가진 노드
            visited[cur.to] = true;

            //1~N까지
            for (Node node : nodes[cur.to]) {
                if (visited[node.to]) {
                    continue;
                }

                //최소비용 갱신
                if (costArr[cur.to] + node.cost < costArr[node.to]) {
                    costArr[node.to] = costArr[cur.to] + node.cost;
                    pq.offer(new Node(node.to, costArr[node.to]));
                }
            }
        }

    }

    static class Node implements Comparable<Node> {

        int to;
        int cost;

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

        Node(
                int to,
                int cost
        ) {
            this.to = to;
            this.cost = cost;
        }
    }
}
