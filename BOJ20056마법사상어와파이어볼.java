import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 160572kb
 * 732ms
 */
public class BOJ20056마법사상어와파이어볼 {
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N, M, K;
    static ArrayList<FireBall>[][] matrix;

    static class FireBall {
        int r, c, m, s, d;

        FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        matrix = new ArrayList[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());
            int mass = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            matrix[row][column].add(new FireBall(row, column, mass, speed, direction));
        }

        for (int k = 0; k < K; k++) {
            moveBalls();
            mergeAndDivideBalls();
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (FireBall ball : matrix[i][j]) {
                    answer += ball.m;
                }
            }
        }

        System.out.println(answer);
    }

    private static void moveBalls() {
        ArrayList<FireBall>[][] newMatrix = new ArrayList[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                newMatrix[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (FireBall ball : matrix[i][j]) {
                    int nr = (i + dr[ball.d] * ball.s % N + N) % N;
                    int nc = (j + dc[ball.d] * ball.s % N + N) % N;
                    if (nr == 0) nr = N; //인덱스 1시작이므로, 0이 나오면 끝으로 이동
                    if (nc == 0) nc = N;
                    newMatrix[nr][nc].add(new FireBall(nr, nc, ball.m, ball.s, ball.d));
                }
            }
        }
        matrix = newMatrix;
    }

    private static void mergeAndDivideBalls() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (matrix[i][j].size() > 1) {
                    int sumMass = 0, sumSpeed = 0;
                    boolean allEven = true, allOdd = true;
                    int howManyFuckingBall = matrix[i][j].size();

                    for (FireBall ball : matrix[i][j]) {
                        sumMass += ball.m;
                        sumSpeed += ball.s;

                        //방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7
                        if (ball.d % 2 == 0) allOdd = false;
                        else allEven = false;
                    }

                    int newMass = sumMass / 5;
                    int newSpeed = howManyFuckingBall == 0 ? 0 : sumSpeed / howManyFuckingBall;
                    matrix[i][j].clear();
                    if (newMass > 0) {
                        for (int d = 0; d < 8; d += 2) {
                            // 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7
                            if (allEven || allOdd) matrix[i][j].add(new FireBall(i, j, newMass, newSpeed, d));
                            else matrix[i][j].add(new FireBall(i, j, newMass, newSpeed, d + 1));
                        }
                    }
                }
            }
        }
    }

}

