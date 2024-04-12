import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 20736kb
 * 260ms
 * 방문배열을 쓰지 않는 것이 맞을지?
 *
 * 다익스트라 : O((V+E)log(V+E))
 */
public class BOJ4485녹색옷입은애가젤다지 {
    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] matrix;
    //static boolean[][] visited;
    static int[][] cost;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            matrix = new int[N][N];
            cost = new int[N][N];
            //visited = new boolean[N][N];
            initMatrix(br);

            System.out.println("Problem " + count + ": " + dijkstra(0, 0));
            count++;
        }

        br.close();

    }

    public static int dijkstra(int startRow, int startColumn) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        cost[startRow][startColumn] = matrix[startRow][startColumn];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startRow, startColumn, matrix[startRow][startColumn]));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.r == N - 1 && current.c == N - 1) {
                return current.weight; // 도착점에 도달했을 때 비용 반환
            }

//            if (visited[current.r][current.c]) continue;
//            visited[current.r][current.c] = true;

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    int sumCost = current.weight + matrix[nr][nc];
                    if (sumCost < cost[nr][nc]) {
                        cost[nr][nc] = sumCost;
                        pq.offer(new Node(nr, nc, sumCost)); //O log N
                    }
                }
            }
        }
        return -1; // 경로가 존재하지 않는 경우

    }

    private static void initMatrix(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class Node implements Comparable<Node> {

        int r, c;
        int weight;

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        public Node(
                int r,
                int c,
                int cost
        ) {
            this.r = r;
            this.c = c;
            this.weight = cost;
        }
    }
}
