import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 86836kb
 * 336ms
 */
public class BOJ1107리모컨 {
    //인덱스가 필요하지 않으므로 배열대신 set 사용
    static Set<Integer> malBtnSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine()); //0~50만
        int malNum = Integer.parseInt(br.readLine()); //0~10
        if(malNum>0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) malBtnSet.add(Integer.parseInt(st.nextToken()));
        }
        br.close();

        // 100번 채널에서 시작하는 경우
        int minClicks = Math.abs(target - 100);

        // 백만번 검사...
        for (int i = 0; i <= 1000000; i++) {
            String channel = String.valueOf(i);
            if (validateMalfunction(channel)) {
                int clicks = Math.abs(target - i) + channel.length();
                minClicks = Math.min(minClicks, clicks);
            }
        }

        //시간초과
//        if (malNum != 10) {
//            int nearestChannel = findNearest(target);
//            int clicks = Math.abs(target - nearestChannel) + String.valueOf(nearestChannel).length();
//            minClicks = Math.min(minClicks, clicks);
//        }

        System.out.println(minClicks);
    }

    private static boolean validateMalfunction(String channel) {
        for (char ch : channel.toCharArray()) {
            if (malBtnSet.contains(ch - '0')) { //-48
                return false;
            }
        }
        return true;
    }

    //시간초과
    private static int findNearest(int target) {
        for (int i = 1; i <= 1000000; i++) {
            if (validateMalfunction(String.valueOf(target + i))) {
                return target + i;
            } else if (target - i >= 0 && validateMalfunction(String.valueOf(target - i))) {
                return target - i;
            }
        }
        return target; //여기 도달할 일은 없다. 숫자 버튼이 다 고장나면 여기 도달하지만 그 전에 분기처리를 하고 있다.
    }
}

