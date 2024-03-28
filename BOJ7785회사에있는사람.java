import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 메모리 54472 kb
 * 시간 1496ms
 */

public class BOJ7785회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        Map<String, Boolean> employeeMap = new HashMap<>();
        ArrayList<String> namesArr = new ArrayList<>();

        for(int i=0; i<length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            boolean isEntered = st.nextToken().equals("enter");
            employeeMap.put(name,isEntered);
        }

        for (String key : employeeMap.keySet()) {
            //HashMap의 경우 평균적으로 O(1) 시간 복잡도를 가지므로, 전체 순회 과정도 O(N)
            if (employeeMap.get(key)) {
                namesArr.add(key);
            }
        }

        Collections.sort(namesArr, Collections.reverseOrder());
        for(String name : namesArr) {
            System.out.println(name);
        }

    }
}
