package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 14604kb
 * 136ms
 * PQ에서 힙정렬을 시킬지, 0과 1로 구분하여 직접 분기를 만들지에 따라
 * Deque을 이용한 0-1 BFS : O(V+E)
 * PQ를 이용한 다익스트라: O((V + E) log V)
 */
public class BOJ1261알고스팟 {
    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] matrix;
    static int[][] cost;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        matrix = new int[N+1][M+1];
        cost = new int[N+1][M+1];
        initMatrix(br);
        bfs(1,1); //1,1에서 출발
        System.out.println(cost[N][M]);

    }

    private static void bfs(int startRow, int startColumn){
        Deque<Node> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        cost[startRow][startColumn] = 0;
        q.add(new Node(startRow, startColumn, 0));

        while(!q.isEmpty()){
            Node current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (nr >= 1 && nr <= N && nc >= 1 && nc <= M) {
                    int newCost = current.cost + matrix[nr][nc];

                    if (newCost < cost[nr][nc]) {
                        cost[nr][nc] = newCost;
                        Node newNode = new Node(nr, nc, newCost);

                        //aka 0-1 BFS
                        if (matrix[nr][nc] == 1) {
                            q.addLast(newNode); // 벽을 부수면 뒤에 추가
                        } else {
                            q.addFirst(newNode); // 벽을 부수지 않으면 큐 앞에 추가(우선순위 높음)
                        }
                    }
                }
            }
        }
    }

    private static void initMatrix(BufferedReader br) throws IOException {
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                matrix[i][j] = str.charAt(j-1)-'0';
            }
        }
    }

    private static class Node implements Comparable<Node> {

        int r, c;
        int cost;

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }

        Node(
                int r,
                int c,
                int cost
        ) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
}
