package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 73432kb
 * 308ms
 * BFS 시간복잡도 : 최악의 경우 O(N) (모든 노드를 탐색해도 모든 노드를 한번만 방문)
 */
public class BOJ7562나이트의이동 {
    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

    static int length;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            length = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int startColumn = Integer.parseInt(st.nextToken());
            Point startPoint = new Point(startRow, startColumn);

            st = new StringTokenizer(br.readLine());
            int destRow = Integer.parseInt(st.nextToken());
            int destColumn = Integer.parseInt(st.nextToken());
            Point destPoint = new Point(destRow, destColumn);

            int[][] board = new int[length][length];
            boolean[][] visited = new boolean[length][length];

            int count = bfs(startPoint, destPoint, board, visited);
            System.out.println(count);
        }
    }

    private static int bfs(Point startPoint, Point destPoint,int[][] board, boolean[][] visited) {
        //입력값이 움직일 필요 없는 경우 바로 반환
        if(startPoint.row==destPoint.row && startPoint.column==destPoint.column) return 0;

        Queue<Point> q = new LinkedList<>();
        q.add(startPoint);
        visited[startPoint.row][startPoint.column] = true;

        while (!q.isEmpty()) {
            Point current = q.poll();
            //현재 위치와 목적지 같으면 보드에 적힌 숫자(움직인 누적 카운트) 반환
            if(current.row== destPoint.row && current.column==destPoint.column) return board[current.row][current.column];

            for (int i = 0; i < 8; i++) {
                int nextRow = current.row + dr[i];
                int nextColumn = current.column + dc[i];
                //인덱스 벗어남
                if(nextRow <0 || nextRow >= length || nextColumn<0 || nextColumn>=length) continue;

                if (!visited[nextRow][nextColumn]) {
                    q.add(new Point(nextRow, nextColumn));
                    board[nextRow][nextColumn] = board[current.row][current.column] + 1; //움직임 횟수 누적
                    visited[nextRow][nextColumn] = true;
                }

            }
        }
        return -1; //목적지 도달 못함
    }

    private static class Point {
        int row, column;

        Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
