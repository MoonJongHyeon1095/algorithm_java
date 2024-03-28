import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Scanner 사용
 * 메모리 18460kb
 * 시간 248ms
 */

/**
 *  BufferedReader 사용
 *  메모리 14356kb
 *  시간 128ms
 */
public class BOJ1546평균 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int length = sc.nextInt();
//        int[] arr = new int[length];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

//        for(int i=0; i<length; i++){
//            arr[i]= sc.nextInt();
//        }
        int sum = 0;
        int max = 0;

        //최대값 방법1
//        for(int i=0; i<length; i++){
//            if(arr[i] > max){
//                max = arr[i];
//            }
//            sum = sum + arr[i];
//        }

        for(int i = 0; i < length; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n > max) {
                max = n;
            }
            sum += n;
        }

        //최대값 방법2
//        Arrays.sort(arr);
//        max= arr[arr.length-1]; // 최대값
        //min = arr[0]

        //최대값 방법3
//        max = Arrays.stream(arr).max().getAsInt();
//        sum = Arrays.stream(arr).sum();

        System.out.println(sum * 100.0 / max / length); //100.0 으로 곱하면, double 형으로 자동으로 계산

    }
}
