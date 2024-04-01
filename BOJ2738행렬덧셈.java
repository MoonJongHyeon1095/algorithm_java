import java.util.Scanner;

/**
 * 35552kb
 * 452ms
 */
public class BOJ2738행렬덧셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] matrix = new int [N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(matrix[i][j] + sc.nextInt()).append(" ");
            }
            System.out.println(sb);
            sb.setLength(0); //이 방법은 내부 버퍼를 재사용하기 때문에 새 객체를 생성하는 것보다 효율적
        }

    }
}
