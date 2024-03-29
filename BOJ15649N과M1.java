
import java.util.Scanner;

public class BOJ15649N과M1 {

    static int n, m;
    static int[] output; // 수열을 저장할 배열
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        output = new int[m];
        visited = new boolean[n];
        dfs(0);
    }

    private static void dfs(int depth){
        if(depth == m){
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }

            System.out.println(sb);
            sb.setLength(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i+1; //일단 1부터 시작

                dfs(depth + 1);

                visited[i] = false; // 재귀가 끝나면 방문하지 않은 상태로 복원
            }
        }
    }
}

