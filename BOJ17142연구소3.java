
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 41944kb
 * 292ms
 * 1.조합 시간복잡도 O(n^k) (n은 virusList의 size, k는 M)
 * 2.BFS 시간복잡도 O(V+E)
 * 전체 시간복잡도는 위 2개의 곱
 *
 - 카운트(시간)를 증가시킬 때의 조건이 다소 복잡하여 어려움을 겪음.
 - 증가 조건이 까다롭다면, 감소시킬 수 있는 일관된 조건이 없는지 확인해볼 것(이 문제의 경우는 빈 공간 개수)
 --------
 끝까지 안됐던 반례 기록
 4 1
 1 1 1 1
 1 2 1 1
 1 1 1 1
 1 1 2 0
 */
public class BOJ17142연구소3 {
    static int[][] map;
    static List<Point> virusList= new ArrayList<>();
    private static List<List<Point>> combinationList = new ArrayList<>();
    static int N, M;
    static int originalEmptySpace =0;
    static int minTime = Integer.MAX_VALUE;
    //상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        initMatrix(br); //virusList 입력

        //빈 공간 없으면 바로 0 return
        if (originalEmptySpace == 0) {
            System.out.println(0);
            return;
        }

        boolean[] selected = new boolean[virusList.size()];
        combination(0, 0, selected); //combinationList 입력 //바이러스의 개수 중 M개 조합

        for(List<Point> combination : combinationList){
            contaminateBFS(combination, originalEmptySpace);
        }
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);

    }

    private static void contaminateBFS(List<Point> combination, int emptySpace) {
        boolean[][] visited = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();
        for (Point virus : combination) {
            queue.add(new Point(virus.row, virus.column, 0));
            visited[virus.row][virus.column] = true;
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = current.row + dr[i];
                int nextColumn = current.column + dc[i];

                // 인덱스 벗어남
                if (nextRow < 0 || nextColumn < 0 || nextRow >= N || nextColumn >= N) continue;
                //벽이 있는 곳, 방문한곳
                if (map[nextRow][nextColumn] == 1 || visited[nextRow][nextColumn]) continue;


                visited[nextRow][nextColumn] = true;
                int nextTime = current.time + 1;
                queue.add(new Point(nextRow, nextColumn, nextTime));

                if (map[nextRow][nextColumn] == 0) {
                    emptySpace--;

                }
                if (emptySpace == 0) {
                    minTime = Math.min(minTime, nextTime);
                    return; // 모든 빈 칸이 채워지면 함수 종료
                }
            }
        }
    }


    private static void combination(int start, int depth, boolean[] selected) {
        if (depth == M) {
            List<Point> comb = new ArrayList<>();
            for (int i = 0; i < selected.length; i++) {
                if (selected[i]) {
                    Point selectedVirus = virusList.get(i);
                    comb.add(selectedVirus);
                }
            }
            combinationList.add(comb);
            return;
        }

        for (int i = start; i < virusList.size(); i++) {
            selected[i] = true;
            combination(i + 1, depth + 1, selected);
            selected[i] = false;
        }
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


    private static void initMatrix(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input= Integer.parseInt(st.nextToken());
                if(input==0) originalEmptySpace++;
                if(input==2) virusList.add(new Point(i,j,0));
                map[i][j] = input;
            }
        }
    }

    private static class Point {
        int row, column, time;

        Point(int row, int column, int time) {
            this.row = row;
            this.column = column;
            this.time = time;
        }
    }
}
