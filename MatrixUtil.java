
import java.io.*;
import java.util.*;


public class MatrixUtil {
    static int N, M;
    static int[][] matrix;
    public static void main(String[] args) {

    }
    private static boolean isOutOfIndex(int ny, int nx) {
        return ny < 0 || ny >= N || nx < 0 || nx >= M;
    }

    private static void initMatrix(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}
