import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 메모리 38396kb
 * 시간 364ms
 */

public class P27160할리갈리 {
    public class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] countArr = new int[4];

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String fruitName = st.nextToken();
                int fruitNum = Integer.parseInt(st.nextToken());

                switch (fruitName) {
                    case "STRAWBERRY": countArr[0]+=fruitNum; break;
                    case "BANANA": countArr[1]+=fruitNum; break;
                    case "LIME": countArr[2]+=fruitNum; break;
                    case "PLUM": countArr[3]+=fruitNum; break;
                }
            }

            for (int i = 0; i < 4; i++)
                if (countArr[i] == 5) {
                    System.out.println("YES");
                    return;
                }
            System.out.println("NO");
        }
    }
}
