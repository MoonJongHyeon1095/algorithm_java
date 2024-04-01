import java.io.*;
import java.util.*;

/**
 * 15864kb
 * 152ms
 */
public class BOJ1018체스판다시칠하기 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        char[][] matrix = new char[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();

            for(int j = 0; j < M; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        int answer = 2500;

        for(int i = 0; i <= N-8; i++){
            for(int j = 0; j <= M-8; j++){
                int resultCount = needPaint(matrix, i, j);

                if(answer > resultCount){
                    answer = resultCount;
                }
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    private static int needPaint(char[][] matrix, int n, int m){
//        String whiteLine = "WBWBWBWB";
//        String blackLine = "BWBWBWBW";
        int whiteStartCount = 0;
        int blackStartCount = 0;

        for(int i = n; i < n + 8; i++) {
            for(int j =  m; j < m + 8; j++) {
                if((i + j) % 2 == 0) { // wbwb...일 때 짝수는 w, bwbw...일때 짝수는 b
                    if(matrix[i][j] != 'W') whiteStartCount++; // W로 시작하는 경우, B를 W로 칠해야 함
                    if(matrix[i][j] != 'B') blackStartCount++; // B로 시작하는 경우, W를 B로 칠해야 함
                } else { // wbwb...일 때 홀수는 b, bwbw...일때 홀수는 w
                    if(matrix[i][j] != 'B') whiteStartCount++; // W로 시작하는 경우, W를 B로 칠해야 함
                    if(matrix[i][j] != 'W') blackStartCount++; // B로 시작하는 경우, B를 W로 칠해야 함
                }

            }
        }
        return Math.min(whiteStartCount, blackStartCount);
    }
}
