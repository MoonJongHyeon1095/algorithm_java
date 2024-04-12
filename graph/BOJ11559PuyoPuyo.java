package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 14252kb
 * 128ms
 */
public class BOJ11559PuyoPuyo {
    private static char[][] matrix = new char[12][6];
    private static boolean[][] visited;
    //상하좌우
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<12; i++){
            String str = br.readLine();
            for(int j=0; j<6; j++){
                matrix[i][j] = str.charAt(j);
            }
        }
        br.close();

        int count = 0;
        boolean isPuyo = true; // 최소 한번 while문이 실행되도록

        while(isPuyo) {
            visited = new boolean[12][6]; // 매번 초기화
            isPuyo = false;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    //R, G, B, P, Y
                    if (matrix[i][j] != '.' && !visited[i][j]) {
                        if (bfs(i, j, matrix[i][j])) {
                            isPuyo = true;
                        }
                    }
                }
            }

            if (isPuyo) {
                count++;
                dropPuyo(); //떨어뜨리기
            }
        }

        System.out.println(count);
    }

    //bfs 에서 가능한 구슬들이 터지고 '.'으로 교체된 이후 호출
    private static void dropPuyo(){
        //왼쪽 칼럼의 가장 아래부터 큐에 넣기
        for (int col = 0; col < 6; col++) {
            Queue<Character> dropQueue = new LinkedList<>();
            for (int row = 11; row >= 0; row--) {
                //단순히 모두 넣으면 중간에 '.'이 있는 경우 처리 못함
                if (matrix[row][col] != '.') {
                    dropQueue.add(matrix[row][col]);
                }
            }

            for (int row = 11; row >= 0; row--) {
                if (!dropQueue.isEmpty()) {
                    matrix[row][col] = dropQueue.poll();
                } else {
                    // 큐가 비었다면 나머지는 빈 칸('.')으로 채움
                    matrix[row][col] = '.';
                }
            }
        }
    }

    private static boolean bfs(int r, int c, char color){
        Queue<Point> q = new LinkedList<>();
        //visited 배열을 순회하여 찾으려 했으나, 큐 하나를 더 만드는 것이 더 효율적
        Queue<Point> popQueue = new LinkedList<>();
        q.add(new Point(r, c));
        visited[r][c] = true;

        while(!q.isEmpty()){
            Point current = q.poll();
            popQueue.add(current);

            for(int i=0; i<4; i++){
                int nextRow = current.row + dr[i];
                int nextColumn = current.column + dc[i];

                //행렬 벗어남
                if (nextRow < 0 || nextColumn < 0 || nextRow >= 12 || nextColumn >= 6) continue;
                //이미 탐색함
                if(visited[nextRow][nextColumn]) continue;
                //같은 색 검사
                if(matrix[nextRow][nextColumn] == matrix[current.row][current.column]){
                    q.add(new Point(nextRow, nextColumn));
                    visited[nextRow][nextColumn] = true;
                }

            }
        }

        if (popQueue.size() >= 4) {
            while (!popQueue.isEmpty()) {
                Point p = popQueue.poll();
                matrix[p.row][p.column] = '.';
            }
            return true;
        }
        return false;

    }

    private static class Point {
        int row, column;

        Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
