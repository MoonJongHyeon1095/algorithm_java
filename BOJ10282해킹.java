
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 148896kb
 * 856ms
 */
public class BOJ10282해킹 {
    static int T, n, edgeSize, hackedNum;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //1 ≤ n ≤ 10,000
            edgeSize = Integer.parseInt(st.nextToken()); //1 ≤ d ≤ 100,000
            hackedNum = Integer.parseInt(st.nextToken()); //1 ≤ c ≤ n
            List<Edge>[] graph = new ArrayList[n + 1];
            //컴퓨터 번호 1~n
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            for(int j=0; j<edgeSize; j++){
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                graph[from].add(new Edge(to, time));
            }
            String result = dijkstra(graph, hackedNum);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static String dijkstra(List<Edge>[] graph, int start){
        boolean[] visited = new boolean[n + 1];

        //timeArr의 인덱스가 컴퓨터 번호 1~n
        int[] timeArr = new int[n + 1];
        Arrays.fill(timeArr, Integer.MAX_VALUE);
        timeArr[start]=0; //시작 시간은 0

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0)); //감염된 채로 시작, 시간0

        while(!pq.isEmpty()){
            Edge current = pq.poll();

            if(visited[current.to]) continue; // 이미 방문한 노드라면 스킵
            visited[current.to] = true;

            for (Edge edge : graph[current.to]) {
                int newTime = current.time + edge.time;
                if (newTime < timeArr[edge.to] && !visited[edge.to]) {
                    timeArr[edge.to] = newTime;
                    pq.add(new Edge(edge.to, newTime));
                }
            }
        }

        int computerCount = 0;
        int maxTime = 0;
        //컴퓨터 번호 1~n
        for (int i = 1; i <= n; i++) {
            if (timeArr[i] != Integer.MAX_VALUE) {
                computerCount++;
                maxTime = Math.max(maxTime, timeArr[i]);
            }
        }
        return computerCount + " " + maxTime;
    }

    private static class Edge implements Comparable<Edge>{
        int to, time;
        Edge(int to, int time){
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.time - edge.time;
        }
    }
}
