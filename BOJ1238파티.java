import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *18352kb
 * 212ms
 * 우선순위 큐 연산 하나 당 O(log V)
 * 전체 시간복잡도 O((V+E) logV)
 */
public class BOJ1238파티 {
    static int N,M,X;
    static ArrayList<Node>[] graph;
    static ArrayList<Node>[] reverseGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X= Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        reverseGraph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>(); // X에서 모든 정점으로의 최단거리
            reverseGraph[i] = new ArrayList<>(); //모든 정점에서 X로의 최단거리
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
            reverseGraph[to].add(new Node(from, cost));
        }

        // X에서 모든 노드로 가는 최단 거리
        int[] minCostFromX = dijkstra(graph);
        // 모든 노드에서 X로 가는 최단 거리
        int[] minCostToX = dijkstra(reverseGraph);

        int maxCost = 0;
        for (int i = 1; i <= N; i++) {
            // 왕복 시간 계산
            int totalCost = minCostFromX[i] + minCostToX[i];
            if (totalCost > maxCost) {
                maxCost = totalCost;
            }
        }

        System.out.println(maxCost);

    }

    private static int[] dijkstra(ArrayList<Node>[] graph){
        //최단거리들 저장 배열
        int[] minCostArr = new int[N+1];
        Arrays.fill(minCostArr, Integer.MAX_VALUE);
        minCostArr[X] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();

            if (minCostArr[current.to] < current.cost) {
                continue;
            }

            //graph[X.to] //X의 인접리스트 순회
            for (Node next : graph[current.to]) {
                int newCost = minCostArr[current.to] + next.cost;
                if (newCost < minCostArr[next.to]) {
                    //최단거리갱신
                    minCostArr[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
            }
        }
        return minCostArr;
    }

    static class Node implements Comparable<Node> {

        public int to;
        public int cost;

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

        public Node(
                int to,
                int cost
        ) {
            this.to = to;
            this.cost = cost;
        }
    }
}
