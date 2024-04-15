package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 16120kb
 * 152ms
 * 0일 때만 큐에 넣어서 이동, 한겹씩만 녹이기
 *
 */
public class BOJ2636치즈 {
    static int r,c;
    static int[][] matrix;
    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        matrix = new int[r][c];
        initMatrix(br);


        int time = 0;
        int lastCheeseCount = 0;

        while (true) {
            int count = countCheese();
            if (count == 0) break;

            //마지막 meltOnce 바로 전의 count
            lastCheeseCount = count;

            meltOnce();

            time++;
        }

        System.out.println(time); // 몇번 녹여야 하나
        System.out.println(lastCheeseCount); //

    }

    private static void meltOnce(){
        boolean[][] visited = new boolean[r][c];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
           Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = current.row + dr[i];
                int nextColumn = current.column + dc[i];

                // 인덱스 벗어남
                if (nextRow < 0 || nextColumn < 0 || nextRow >= r || nextColumn >= c) continue;
                //방문한곳
                if (visited[nextRow][nextColumn]) continue;

                //그냥 바깥에서부터 녹이기
                if (matrix[nextRow][nextColumn] == 0) {
                    queue.add(new Point(nextRow, nextColumn));
                    visited[nextRow][nextColumn] = true;
                } else if (matrix[nextRow][nextColumn] == 1) {
                    matrix[nextRow][nextColumn] = 0;
                    visited[nextRow][nextColumn] = true;
                }
            }
        }
    }

    private static int countCheese() {
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 1) count++;
            }
        }
        return count;
    }

    private static void initMatrix(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static class Point {
        int row, column;

        Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
