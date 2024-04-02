import java.io.*;
import java.util.*;

/**
 * 16072kb
 * 148ms
 */
public class BOJ2615오목 {
    static int[][] board = new int [19][19];
    //static boolean[][][] visited = new boolean[19][19][4];
    //오른쪽, 아래, 오른쪽아래, 오른쪽위
    static int[] dRow = {0, 1, 1, -1};
    static int[] dColumn = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i<19; i++){
            for(int j=0; j<19; j++){
                if (board[i][j] != 0) {
                    //dir 순회
                    for(int k =0; k<4; k++){
                        int count = dfs(i, j, k, board[i][j]); //row, column, dir, 돌색깔
                        if (count == 5) {
                            if (validate5(i, j, k, board[i][j])) {
                                System.out.println(board[i][j]);
                                System.out.println((i + 1) + " " + (j + 1));
                                return;
                            }
                        }
                    }
                }
            }
        }
        //다섯이 안된 경우 도달
        System.out.println(0);

    }

    private static int dfs(int row, int column, int dir, int color) {
        if (!validateIdx(row, column) || board[row][column] != color) {
            return 0;
        }
        //visited[row][column][dir] = true;
        return 1 + dfs(row + dRow[dir], column + dColumn[dir], dir, color);
    }

    private static boolean validateIdx(int row, int column) {
        return row >= 0 && column >= 0 && row < 19 && column < 19;
    }

    private static boolean validate5(int row, int column, int dir, int color) {
        int prevRow = row - dRow[dir];
        int prevColumn = column - dColumn[dir];
        if (validateIdx(prevRow, prevColumn) && board[prevRow][prevColumn] == color) {
            return false;
        }

        int nextRow = row + dRow[dir] * 5;
        int nextColumn = column + dColumn[dir] * 5;
        if (validateIdx(nextRow, nextColumn) && board[nextRow][nextColumn] == color) {
            return false;
        }

        return true;
    }
}
