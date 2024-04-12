import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 15956kb
 * 204ms
 */
public class BOJ21610마법사상어와비바라기 {
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[][] matrix;
    static boolean[][] cloud;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N+1][N+1];
        cloud = new boolean[N+1][N+1];
        initMatrix(br);
        비바라기();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            moveAndRain(d,s);
            물복사버그();
            구름재생성();
        }

        int sum = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void 비바라기(){
        cloud[N][1] = cloud[N][2] = cloud[N-1][1] = cloud[N-1][2] = true;
    }

    private static void moveAndRain(int d, int s) {
        boolean[][] newCloud = new boolean[N+1][N+1];
        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= N; c++) {
                if(cloud[r][c]) {
                    //r-1, c-1: 인덱스 0부터 델타거리 더하기
                    //d-1 : d값 입력도 1부터 들어와서, 델타 배열 인덱스로 넣을 때는 -1
                    // +N: dr[d]*s가 양수면 제자리, 음수면 양수방향으로 전환
                    // +1: 인덱스 1 다시 더하기
                    int nr = ((r-1) + dr[d-1]*s % N + N) % N + 1;
                    int nc = ((c-1) + dc[d-1]*s % N + N) % N + 1;
                    newCloud[nr][nc] = true;
                    matrix[nr][nc]+=1;
                }
            }
        }
        cloud = newCloud;
    }

    private static void 물복사버그() {
        int[] diagonalR = {-1, -1, 1, 1};
        int[] diagonalC = {-1, 1, -1, 1};
        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= N; c++) {
                //moveAndRain에서 물이 증가한 칸에 물복사버그 적용
                if(cloud[r][c]) {
                    int count = 0;//물이 있는 바구니 수
                    for(int d = 0; d < 4; d++) {
                        int nr = r + diagonalR[d];
                        int nc = c + diagonalC[d];
                        //인덱스 벗어남
                        if(isOutOfIndex(nr, nc)) continue;
                        if(matrix[nr][nc] > 0) {
                            count++;
                        }
                    }
                    matrix[r][c] += count;
                }
            }
        }
    }

    private static void 구름재생성() {
        boolean[][] newCloud = new boolean[N+1][N+1];
        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= N; c++) {
                // 물의 양이 2 이상인 모든 칸 //구름이 생기는 칸은 이전 구름이 사라진 칸이 아니어야 한다
                if(matrix[r][c] >= 2 && !cloud[r][c]) {
                    newCloud[r][c] = true;
                    matrix[r][c] -= 2;
                }
            }
        }
        cloud = newCloud;
    }

    private static boolean isOutOfIndex(int nr, int nc) {
        return nr < 1 || nr > N || nc < 1 || nc >N;
    }

    private static void initMatrix(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
