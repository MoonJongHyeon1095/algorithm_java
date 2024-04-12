import java.io.*;
import java.util.*;

/**
 * 18912kb
 * 164ms
 * BlockGroup 인스턴스의 행과 열을 최대값 N으로 초기화, BFS 안에서 더 낮은 행과 열로 기준 블록 갱신
 * setter 를 사용해서 조금이라도 직관적으로 해보려고 했는데, setter 안에 분기를 넣어도 되는지는 의문
 */
public class BOJ21609상어중학교 {
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    // |r1 - r2| + |c1 - c2| = 1
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int totalScore = 0;

    static class BlockGroup {
        ArrayList<int[]> blocks; // 블록 그룹에 포함된 모든 블록
        int startBlockRow; // 기준 블록의 row
        int startBlockColumn; // 기준 블록의 column
        int rainbowCount; // 무지개 블록의 개수

        BlockGroup() {
            this.blocks = new ArrayList<>();
            //기준 블록은 무지개 블록이 아닌 블록 중에서 행의 번호가 가장 작은 블록, 그러한 블록이 여러개면 열의 번호가 가장 작은 블록
            this.startBlockRow = N; // 기준 블록 row 최대값 초기화
            this.startBlockColumn = N; // 기준 블록 column 최대값 초기화
            this.rainbowCount = 0;
        }

        private void addBlock(int r, int c) {
            blocks.add(new int[]{r, c});
        }

        //무지개 블록이 아닌 블록 중에서 행의 번호가 가장 작은 블록, 그러한 블록이 여러개면 열의 번호가 가장 작은 블록
        //가장 위 //가장 위가 여러개면 그중 가장 왼쪽
        private void setStartBlock(int r, int c) {
            if (r < startBlockRow || (r == startBlockRow && c < startBlockColumn)) {
                startBlockRow = r;
                startBlockColumn = c;
            }
        }

        // 무지개 블록 개수 증가
        private void increaseRainbowCount() {
            rainbowCount++;
        }

        private int getSize() {
            return blocks.size();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        initMatrix(br);

        while (true) {
            visited = new boolean[N][N];
            BlockGroup maxGroup = findLargestGroup();
            if (maxGroup.blocks.size() < 2) break;
            removeBlockGroup(maxGroup);
            gravity();
            rotate();
            gravity();
        }

        System.out.println(totalScore);
    }

    private static void rotate() {
        int[][] temp = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                //90도 왼쪽으로 돌렸을 때
                temp[N - 1 - c][r] = map[r][c];
            }
        }
        for (int r = 0; r < N; r++) {
            //arrayCopy( 원본배열, 원본배열 시작위치, 목적지 배열, 목적지 배열 시작위치, 복사할 원소 개수 )
            System.arraycopy(temp[r], 0, map[r], 0, N);
        }
    }

    //가장 밑 혹은 검은 블록 만날 때 까지 떨어짐
    private static void gravity() {
        for (int c = 0; c < N; c++) {
            for (int r = N-1; r >= 0; r--) { // 아래에서부터 위로
                if (map[r][c] >= 0) { // 빈 칸(제거된 블록)이 아니고, 검은색 블록도 아닌 경우
                    int nr = r;
                    while (nr + 1 < N && map[nr + 1][c] == -2) { // 아래 칸이 빈 칸일 경우만 이동
                        nr++;
                    }
                    if (nr != r) {
                        map[nr][c] = map[r][c];  //이동을 행렬에 저장
                        map[r][c] = -2; // 원래 위치를 빈 칸으로
                    }
                }
            }
        }
    }


    private static void removeBlockGroup(BlockGroup maxGroup) {
        // 블록 그룹에 포함된 모든 블록을 순회하며 게임 보드에서 제거
        for (int[] block : maxGroup.blocks) {
            int r = block[0];
            int c = block[1];
            map[r][c] = -2; // 제거된 블록을 표시
        }

        // 제거된 블록의 개수를 기반으로 점수 계산
        int score = maxGroup.getSize() * maxGroup.getSize(); // B^2 점을 획득한다는 규칙에 따라 계산
        totalScore += score; // 전역 변수인 총 점수에 추가
    }

    private static BlockGroup findLargestGroup(){
        BlockGroup maxGroup = new BlockGroup();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] > 0) { // 방문하지 않은 일반 블록인 경우
                    BlockGroup group = bfs(i, j);
                    if (validateNewGroup(group, maxGroup)) {
                        maxGroup = group;
                    }
//                    for (int[] block : group.blocks) {
//                        if (map[block[0]][block[1]] == 0) {
//                            visited[block[0]][block[1]] = false;
//                        }
//                    }
                }
            }
        }

        return maxGroup;

    }

    private static BlockGroup bfs(int r, int c) {
        BlockGroup group = new BlockGroup();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        group.addBlock(r, c);
        if (map[r][c] != 0) { // 무지개 블록이 아니라면 기준 블록 설정
            group.setStartBlock(r, c);
        }
        int color = map[r][c]; // 현재 탐색 중인 블록의 색상

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int curR = pos[0];
            int curC = pos[1];

            for (int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                // 범위 내에 있고 아직 방문하지 않은 위치
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    // 인접한 칸이 같은 색상의 일반 블록이거나 무지개 블록인 경우 탐색
                    if (map[nr][nc] == color || map[nr][nc] == 0) {
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        group.addBlock(nr, nc);
                        if (map[nr][nc] == 0) { // 무지개 블록인 경우
                            group.increaseRainbowCount();
                        } else if (map[r][c] != 0) { // 무지개 블록이 아닌 경우 기준 블록 갱신
                            group.setStartBlock(nr, nc);
                        }
                    }
                }
            }
        }

        //block[0]][block[1] 블록의 row column
        // 블록 그룹 중 무지개 블록만 방문 초기화
        for (int[] block : group.blocks) {
            if (map[block[0]][block[1]] == 0) {
                visited[block[0]][block[1]] = false;
            }
        }

        return group;
    }

    private static boolean validateNewGroup(BlockGroup newGroup, BlockGroup maxGroup) {
        if (newGroup.getSize() > maxGroup.getSize()) {
            return true;
        } else if (newGroup.getSize() == maxGroup.getSize()) {
            if (newGroup.rainbowCount > maxGroup.rainbowCount) {
                return true;
            } else if (newGroup.rainbowCount == maxGroup.rainbowCount) {
                if (newGroup.startBlockRow > maxGroup.startBlockRow) {
                    return true;
                } else if (newGroup.startBlockRow == maxGroup.startBlockRow && newGroup.startBlockColumn > maxGroup.startBlockColumn) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void initMatrix(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
