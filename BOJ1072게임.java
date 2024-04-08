import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 14320kb
 * 124ms
 * 시간초과가 난 단순한 방법 : O(N)
 * 이분탐색 : O(log N)
 */
public class BOJ1072게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        br.close();

        //99% 여도 결코 1%는 안올라감
        //long Z = Y / X * 100; //이거 Y/X 의 정수값에다 100을 곱해버림. 즉 Y/X가 1이 아니면 다 0이 됨.
        long Z = (Y * 100) / X;
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        //시간초과
//        long i = 0;
//        while ((Y + i) / (X + i) * 100 < 1) {
//            i++;
//        }
//        System.out.println(i+1);

        long left = 0;
        long right = 100000000000L; //임의의 값 1000억
        while(left<=right){
            long mid = left + (right - left) / 2;
            long newZ = (Y+mid) * 100 / (X+mid);
            if(newZ == Z){ //1%가 안늘면
                left = mid +1; //왼쪽 버리기
            }else{
                //1% 이상 늘면
                right = mid -1; //오른쪽 버리기
            }
        }
        //left > right가 되는 순간 탈출합니다.
        System.out.println(left);

    }
}
