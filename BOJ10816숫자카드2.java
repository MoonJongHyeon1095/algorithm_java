import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 메모리 167104kb
 * 시간 1044ms
 */
public class BOJ10816숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] numberArr = br.readLine().split(" ");
        Map<String, Integer> numberMap = new HashMap<>();

        for(String s : numberArr){
            numberMap.put(s, numberMap.getOrDefault(s, 0)+1);
        }

        int m = Integer.parseInt(br.readLine());
        String[] keyArr = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for(String k : keyArr){
            sb.append(numberMap.getOrDefault(k, 0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
