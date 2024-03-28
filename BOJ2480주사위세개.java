import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ2480주사위세개 {
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Map<Integer, Integer> m = new HashMap<Integer, Integer>();
            int maxNum = 0;

            for(int i = 0; i < 3; i++){
                int num = sc.nextInt();
                int count = m.getOrDefault(num, 0);
                m.put(num, count + 1);

                if (num > maxNum) maxNum = num;
            }

            int answer = 0;
            for(Map.Entry<Integer, Integer> entry : m.entrySet()) {
                int k = entry.getKey();
                int v = entry.getValue();

                switch(v) {
                    case 3:
                        answer = 10000 + k * 1000;
                        break; // 같은 눈 3개
                    case 2:
                        answer = 1000 + k * 100;
                        break; // 같은 눈 2개
                    default:
                        break;
                }

                if (answer > 0) break;

            }

            //다 다른 경우
            if (answer == 0) {
                answer = maxNum * 100;
            }

            System.out.println(answer);

        }
    }
}
