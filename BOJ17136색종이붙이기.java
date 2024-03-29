import java.util.Scanner;

public class BOJ17136색종이붙이기 {
    static int[][] board = new int[10][10];
    static int nextRow;
    static int nextCol;

    public static void main(String[] args) {
        // 예를 들어, 사용자 입력을 받는 경우
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

    }

    public static boolean isValid(int row, int col, int size) {
        if (row + size > 10 || col + size > 10) return false;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
               if (board[row + r][col + c] == 0) return false;
            }
        }
        return true;
    }

    public static void fill(int row, int col, int size, int color) { for (int r = 0; r < size; r++) {
        for (int c = 0; c < size; c++) { board[row + r][col + c] = color;
        } }
    }

    public static void findNext(int row, int col) {
        for (int r = row; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (board[r][c] == 1) {
                nextRow = r;
                nextCol = c;
                return;
            }
        }
    }
        nextRow = -1;
        nextCol = -1;
    }
}
