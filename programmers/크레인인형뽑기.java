package programmers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 크레인인형뽑기 {
    public int solution(int[][] board, int[] moves) {
        List<List<Integer>> arr = new ArrayList<>();

        for (int j = 0; j < board[0].length; j++) {
            //세로 위치
            List<Integer> column = new ArrayList<>();
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    column.add(board[i][j]);
                }
            }
            arr.add(column);
        }

        int count = 0;
        List<Integer> result = new ArrayList<>();

        for (int move : moves) {
            List<Integer> column = arr.get(move - 1);

            if (column.isEmpty()) continue;

            int popped = column.remove(column.size() - 1);

            if (!result.isEmpty() && popped == result.get(result.size() - 1)) {
                result.remove(result.size() - 1);
                count += 2;
            } else {
                result.add(popped);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        크레인인형뽑기 solution = new 크레인인형뽑기();
        int[][] board = {
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 2, 1, 0, 0},
                {0, 2, 1, 0, 0},
                {0, 2, 1, 0, 0}
        };
        int[] moves = {1, 2, 3, 3, 2, 3, 1};
        int count = solution.solution(board, moves);
        System.out.println(count);
    }
}

