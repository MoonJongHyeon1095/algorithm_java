import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 16416kb
 * 212ms
 */
public class BOJ2212센서 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //센서 개수
        int K = Integer.parseInt(br.readLine()); //집중국 개수

        //거리 연산 필요 없는 경우
        if (K >= N) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) arr[i]= Integer.parseInt(st.nextToken());
        Arrays.sort(arr);//오름 차순 정렬

        Integer[] difference = new Integer[N-1];
        for (int i = 0; i < N-1; i++) {
            difference[i] = arr[i+1] - arr[i];
        }

        //오름차순 정렬, 뒤에서 K-1개 빼고 더하기
        Arrays.sort(difference);
        int sum = 0;
        for (int i = 0; i < difference.length - (K-1); i++) {
            sum += difference[i];
        }
        System.out.println(sum);
    }
}
