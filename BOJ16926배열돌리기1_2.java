import java.io.*;
import java.util.*;

public class BOJ16926배열돌리기1_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken()) % ((N+M-2)*2);

        int[][] matrix = new int [N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // R번 수행
        for(int i=0; i<R; i++) {
            // 가장 큰 사각형부터 안으로 한 번씩 돌리기
            for(int j=0; j< Math.min(N, M)/2; j++) {

                int temp = matrix[j][j];  //각 사각형의 왼쪽 위 값 저장

                // left
                for(int k=j; k<M-j-1; k++) {
                    matrix[j][k] = matrix[j][k+1];
                }
                // up
                for(int k=j; k<N-1-j; k++) {
                    matrix[k][M-j-1] = matrix[k+1][M-j-1];
                }
                // right
                for(int k=M-j-1; k>j; k--) {
                    matrix[N-1-j][k] = matrix[N-1-j][k-1];
                }
                // down
                for(int k=N-j-1; k>j; k--) {
                    matrix[k][j] = matrix[k-1][j];
                }
                matrix[j+1][j] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb.toString());

    }


}
