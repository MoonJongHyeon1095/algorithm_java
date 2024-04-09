package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 14276kb
 * 128ms
 * 참 과정이 장황하면서도, 아무 생각 없이 풀게 되는 듯 합니다.
 */
public class BOJ3055탈출 {
    //상하좌우
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static char[][] map;
    private static int R,C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        Queue<Point> moveQueue = new LinkedList<>();
        Queue<Point> waterQueue = new LinkedList<>();
        for(int r=0; r<R; r++){
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                if (line.charAt(c) == 'S') {
                    moveQueue.add(new Point(r, c));
                    visited[r][c] = true;
                } else if (line.charAt(c) == '*') {
                    waterQueue.add(new Point(r, c));
                }
            }
        }

        String answer = bfs(moveQueue, waterQueue);
        System.out.println(answer);

    }

    private static String bfs(Queue<Point> moveQueue, Queue<Point> waterQueue){
        int moves = 0;
        while (!moveQueue.isEmpty()) {
            moves++;

            //먼저 물이 이동
            int waterSize = waterQueue.size();
            for (int i = 0; i < waterSize; i++) {
                Point current = waterQueue.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nextRow = current.row + dr[dir];
                    int nextColumn = current.column + dc[dir];
                    //인덱스 벗어남
                    if(nextRow<0 || nextRow >=R || nextColumn<0 || nextColumn >=C ) continue;
                    //돌이나 물은 채우지 않음
                    if (map[nextRow][nextColumn] == '.' || map[nextRow][nextColumn] == 'S') {
                        map[nextRow][nextColumn] = '*';
                        waterQueue.add(new Point(nextRow, nextColumn));
                    }
                }
            }

            //고슴도치 이동
            int moveQueueSize = moveQueue.size();
            for (int i = 0; i < moveQueueSize; i++) {
                Point current = moveQueue.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nextRow = current.row + dr[dir];
                    int nextColumn = current.column + dc[dir];
                    //인덱스 벗어남
                    if(nextRow<0 || nextRow >=R || nextColumn<0 || nextColumn >=C ) continue;

                    //도달하면 탈출
                    if (map[nextRow][nextColumn] == 'D') {
                        return String.valueOf(moves);
                    }

                    if (!visited[nextRow][nextColumn] && map[nextRow][nextColumn] == '.') {
                        visited[nextRow][nextColumn] = true;
                        moveQueue.add(new Point(nextRow, nextColumn));
                    }

                }
            }
        }

        //'D'에 도달하지 못함
        return "KAKTUS";
    }

    private static class Point {
        int row, column;

        Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        Point(){}
    }
}
