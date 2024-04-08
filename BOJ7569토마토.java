import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 123980kb
 * 720ms
 * 패턴에 익숙해져 아무 생각 없이 풀게 되는데, 일단 통과가 되긴 하지만 괜찮은 건지 모르겠습니다
 */
public class BOJ7569토마토 {
    static int[] dh = {1, -1, 0, 0, 0, 0}; // 높이(위아래)
    static int[] dr = {0, 0, 1, -1, 0, 0}; // 행(앞뒤)
    static int[] dc = {0, 0, 0, 0, 1, -1}; // 열(좌우)
    static int[][][] tomatoMatrix;
    static boolean[][][] visited;
    static int height;
    static int column;
    static int row;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        column = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        tomatoMatrix = new int[height][row][column];
        visited = new boolean[height][row][column];
        Queue<Point> q = new LinkedList<>();
        for(int h=0; h<height; h++){
            for(int r=0; r<row; r++){
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<column; c++){
                    //토마토 익은 곳 아무데나 잡고 시작
                    int value = Integer.parseInt(st.nextToken());
                    if(value==1) {
                        q.add(new Point(h, r, c));
                        visited[h][r][c] = true; // 익은 토마토를 방문 처리
                    }
                    tomatoMatrix[h][r][c] = value;
                }
            }
        }
        br.close();

        bfs(q);
        int days = 0;
        for (int h = 0; h < height; h++) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    if (tomatoMatrix[h][r][c] == 0) { // 아직 안 익은 토마토가 있는 경우
                        System.out.println(-1);
                        return;
                    }
                    days = Math.max(days, tomatoMatrix[h][r][c]);
                }
            }
        }
        System.out.println(days-1); //익은 숫자 1부터 누적했기 때문에 1을 빼야 함
    }

    private static void bfs(Queue<Point> q){
        while (!q.isEmpty()) {
            Point current = q.poll();
            int currentH = current.height;
            int currentR = current.row;
            int currentC = current.column;

            // 6가지 방향으로 이동
            for (int i = 0; i < 6; i++) {
                int nextH = currentH + dh[i];
                int nextR = currentR + dr[i];
                int nextC = currentC + dc[i];

                //인덱스 범위
                if(nextH<0 || nextH>=height || nextR<0 || nextR >= row || nextC<0 || nextC>=column )continue;
                //토마토 없음
                if(tomatoMatrix[nextH][nextR][nextC]==-1) continue;
                // 배열 범위를 벗어나지 않고, 방문하지 않은 위치인 경우
                if (!visited[nextH][nextR][nextC]) {
                    tomatoMatrix[nextH][nextR][nextC] = tomatoMatrix[currentH][currentR][currentC]+1; //일수 누적
                    visited[nextH][nextR][nextC] = true;
                    q.add(new Point(nextH, nextR, nextC));
                }
            }
        }
    }

    private static class Point {
        int row, column, height;

        Point(int height, int row, int column) {
            this.row = row;
            this.column = column;
            this.height = height;
        }

    }
}
