package graph;

import java.util.Scanner;

/**
 * 메모리 18376kb
 * 시간 256ms
 */
public class BOJ15650N과M2 {
    static int[] output;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        output = new int[M];
        visited = new boolean[N+1];
        dfs(1, 0);
    }

    public static void dfs(int currentInt, int depth) {
        //백트래킹 방법1, 목표도달시 중단
        if (depth == M) {
            for (int val : output) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = currentInt; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                dfs(i + 1, depth + 1);

                //백트래킹 방법2, 다른 경로 탐색위해 되돌리기
                visited[i] = false;
            }
        }
    }
}
