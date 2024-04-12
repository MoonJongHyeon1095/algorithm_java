package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 148360kb
 * 600ms
 */
public class BOJ14502연구소 {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static List<Point> zeroIndex = new ArrayList<>();
    static int maxSafeArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    zeroIndex.add(new Point(i, j));
                }
            }
        }
        br.close();

        boolean[][] selected = new boolean[N][M];
        combination(0, 0, selected);
        System.out.println(maxSafeArea);
    }

    private static void combination(int start, int depth, boolean[][] selected) {
        if (depth == 3) {
            int[][] tempMap = deepCopy(map);
            // 선택된 벽 위치를 tempMap에 적용
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (selected[i][j]) {
                        tempMap[i][j] = 1; // 벽 세우기
                    }
                }
            }

            // 바이러스 퍼트리고 안전 영역 계산
            int[][] contaminatedMap = contaminateBFS(tempMap);
            int safeArea = calculateSafeArea(contaminatedMap);
            maxSafeArea = Math.max(maxSafeArea, safeArea);
            return;
        }

        for (int i = start; i < zeroIndex.size(); i++) {
            Point point = zeroIndex.get(i);
            selected[point.row][point.column] = true;
            combination(i + 1, depth + 1, selected);
            selected[point.row][point.column] = false;
        }
    }


    private static int[][] contaminateBFS(int[][] tempMap) {
        //상하좌우
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        //int spreadCount = 0;

        Queue<Point> queue = new LinkedList<>();
        // 바이러스 위치를 찾아 큐에 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = current.row + dr[i];
                int nextColumn = current.column + dc[i];

                // 인덱스 벗어남
                if (nextRow < 0 || nextColumn < 0 || nextRow >= N || nextColumn >= M) continue;

                if (tempMap[nextRow][nextColumn] == 0) {
                    tempMap[nextRow][nextColumn] = 2;
                    queue.add(new Point(nextRow, nextColumn));
                    //spreadCount++;
                }
            }
        }

        return tempMap;
    }

    private static int[][] deepCopy(int[][] original){
        if (original == null) {
            return null;
        }

        int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = new int[original[i].length];
            for (int j = 0; j < original[i].length; j++) {
                result[i][j] = original[i][j];
            }
        }
        return result;
    }

    private static int calculateSafeArea(int[][] map) {
        int safeAreaCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    safeAreaCount++;
                }
            }
        }
        return safeAreaCount;
    }

    private static class Point {
        int row, column;

        Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

}
