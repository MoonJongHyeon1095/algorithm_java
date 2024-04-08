import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 16496kb
 * 160ms
 * O(Vertex + Edge) 노드의 수 + 간선의 수
 * 상수항 뺀 전체 시간복잡도 O(n)
 */
public class BOJ10026적록색약 {
    //상하좌우
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static boolean[][] visitedForWeak;
    private static char[][] matrix;
    private static char[][] matrixForWeak;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+2][N+2];
        visitedForWeak = new boolean[N+2][N+2];
        matrix = new char[N+2][N+2]; //인덱스1~N까지 사용
        matrixForWeak = new char[N+2][N+2];
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=N; j++){
                matrix[i][j] = str.charAt(j-1); // str 인덱스는 0부터 시작
                matrixForWeak[i][j] = (str.charAt(j-1) == 'G' ? 'R' : str.charAt(j-1)); //글자 바꾸
            }
        }
        br.close();

        int normalCount = countBlocks(matrix, visited);
        int weakCount = countBlocks(matrixForWeak, visitedForWeak);
        System.out.println(normalCount + " " + weakCount);
    }


    private static int countBlocks(char[][] matrix, boolean[][] visited) {
        int blockCount = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j]) {
                    bfsSameColor(matrix, visited, i, j);
                    blockCount+=1;
                }
            }
        }
        return blockCount;
    }

    private static void bfsSameColor(char[][] matrix, boolean[][] visited, int startRow, int startColumn){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startRow, startColumn));
        visited[startRow][startColumn] = true;

        while(!q.isEmpty()){
            Point current = q.poll();

            for(int i=0; i<4; i++){
                int nextRow = current.row + dr[i];
                int nextColumn = current.column + dc[i];

                //행렬 벗어남
                if(nextRow > N || nextColumn > N || nextRow <1 || nextColumn <1) continue;
                //이미 탐색함
                if(visited[nextRow][nextColumn]) continue;
                //같은 색 검사
                if(matrix[nextRow][nextColumn] == matrix[current.row][current.column]){
                    q.add(new Point(nextRow, nextColumn));
                    visited[nextRow][nextColumn] = true;
                }

            }
        }

    }

    private static class Point {
        int row, column;

        Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

}
