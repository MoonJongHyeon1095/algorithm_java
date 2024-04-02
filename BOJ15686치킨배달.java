import java.io.*;
import java.util.*;

public class BOJ15686치킨배달 {
    //좌, 하, 우, 상
    static int[] dRow = {0, 1, 0, -1};
    static int[] dColumn = {-1, 0, 1, 0};
    static int[][] map;
    static int maxRow, maxColumn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //for(int i = 0; i )
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        maxRow = N;
        maxColumn = N;
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j] == 1){
                    int distance = getDistanceFromHome(i,j);
                    pq.add(distance);
                }
            }
        }

        //최소값 M개 더하기
        int answer = 0;
        for(int i = 0; i < M; i++){
            answer += pq.poll();
        }

        System.out.println(answer);


    }

//    private static int getDistanceFromHome(int row, int column) {
//        for (int i = 0; i < 4; i++) {
//            if(!validateIdx(row + dRow[i], column + dColumn[i])) continue;
//            if (map[row + dRow[i]][column + dColumn[i]] != 2) {
//                return 1 + getDistanceFromHome(row + dRow[i], column + dColumn[i]);
//            }
//        }
//        return 1;
//    }

    //DFS사용시 stack overflow
//    private static int getDistanceFromChicken(int row, int column) {
//        for (int i = 0; i < 4; i++) {
//            if(!validateIdx(row + dRow[i], column + dColumn[i])) continue;
//            if (map[row + dRow[i]][column + dColumn[i]] != 1) {
//                return 1 + getDistanceFromChicken(row + dRow[i], column + dColumn[i]);
//            }
//        }
//        return 1;
//    }
    private static int getDistanceFromHome(int row, int column) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(row, column));

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();

                // 치킨집을 찾으면 거리 반환
                if (map[current.row][current.column] == 2) {
                    return distance;
                }

                // 4방향 탐색
                for (int j = 0; j < 4; j++) {
                    int nRow = current.row + dRow[j];
                    int nColumn = current.column + dColumn[j];

                    if (!validateIdx(nRow, nColumn)) continue;

                    queue.offer(new Point(nRow, nColumn));
                }
            }
            distance++;
        }

        return -1; // 모든 경우를 탐색했지만 집을 찾지 못한 경우 (이론상 발생하지 않음)
    }

    private static boolean validateIdx(int row, int column) {
        return row >= 0 && column >= 0 && row < maxRow && column < maxColumn;
    }

    static class Point {
        int row, column;
        Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

}
