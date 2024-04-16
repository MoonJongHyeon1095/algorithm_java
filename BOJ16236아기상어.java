import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 22224kb
 * 180ms
 */
public class BOJ16236아기상어 {
    static int N, M;
    static int[][] matrix;
    static Point startPoint;
    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        initMatrix(br);

        int sharkSize = 2;
        int eatCount = 0;
        int timeCount =0;

        while (true) {
            Point foundFish = findNearestFish(startPoint, sharkSize);
            if (foundFish == null) break;

            //냠냠
            matrix[foundFish.row][foundFish.column] = 0;
            startPoint = foundFish;
            timeCount += foundFish.moves;

            eatCount++;
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(timeCount);
    }

    private static Point findNearestFish(Point startPoint, int sharkSize) {
        boolean[][] visited = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startPoint.row, startPoint.column, 0));
        visited[startPoint.row][startPoint.column] = true;

        Point lastPoint = null;
        int minDistance = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = current.row + dr[i];
                int nextColumn = current.column + dc[i];

                // 인덱스 벗어남
                if (nextRow < 0 || nextColumn < 0 || nextRow >= N || nextColumn >= N) continue;
                //방문한곳
                if (visited[nextRow][nextColumn]) continue;
                //자신이 몸집보다 크면 못지나감
                if(matrix[nextRow][nextColumn] > sharkSize) continue;

                visited[nextRow][nextColumn] = true;
                if (matrix[nextRow][nextColumn] != 0 && matrix[nextRow][nextColumn] < sharkSize) {
                    if (current.moves + 1 <= minDistance) {
                        if (validatePoint(lastPoint, nextRow, nextColumn, current.moves+1, minDistance )) {
                            lastPoint = new Point(nextRow, nextColumn, current.moves + 1);
                            minDistance = current.moves + 1;
                        }
                    }
                }

                queue.add(new Point(nextRow, nextColumn, current.moves + 1));
            }
        }
        return lastPoint;
    }

    private static boolean validatePoint(Point lastPoint, int nr, int nc, int newMoves, int minDistance) {
        //순서대로
        //첫 먹이발견인 경우 //거리가 더 가까운 것 //거리가 같은게 많다면 가장 위 //그런 물고기도 많다면 가장 왼쪽
        return lastPoint == null || newMoves < minDistance || nr < lastPoint.row || (nr == lastPoint.row && nc < lastPoint.column);
    }

    private static void initMatrix(BufferedReader br) throws IOException {
        StringTokenizer st;
        M = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 9) {
                    startPoint = new Point(i, j, 0);
                    matrix[i][j] = 0; //행렬에 9를 0으로 넣어야 함
                } else {
                    matrix[i][j] = input;
                    if (input != 0) M++;
                }
            }
        }
    }
    private static class Point {
        int row, column, moves;

        Point(int row, int column, int moves) {
            this.row = row;
            this.column = column;
            this.moves = moves;
        }
    }
}
