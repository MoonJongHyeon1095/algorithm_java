import java.util.Scanner;

public class AdjacencyMatrixDFS {

    static int edge;
    static int vertex;
    static int [][] matrix;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        vertex = sc.nextInt();
        edge = sc.nextInt();
        matrix = new int[vertex + 1][vertex + 1];
        visit = new boolean[vertex + 1];

        for(int i=0; i<edge; i++){
            int start = sc.nextInt();
            int next = sc.nextInt();

            matrix[start][next] = 1;
            matrix[next][start] = 1;
        }

        dfs(1);
    }

    public static void dfs(int start){
        visit[start] = true;
        System.out.print(start + " ");

        for(int i = 1; i < vertex + 1; i++){
            if(matrix[start][i] == 1 && !visit[i]){
                dfs(i);
            }
        }
    }
}
