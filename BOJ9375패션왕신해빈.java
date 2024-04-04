import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 14152kb
 * 128ms
 * HashMap 사용, 메서드 하나당 O(1), 전체 시간복잡도 O(N)
 */
public class BOJ9375패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            Map<String, Integer> dressMap = new HashMap<>();

            int n = Integer.parseInt(br.readLine());
            for(int j=0; j<n; j++){
                String dressType = br.readLine().split(" ")[1];
                dressMap.put(dressType, dressMap.getOrDefault(dressType, 0)+1); //O(1)
            }

            //가진 의상이 없는 경우
            if(dressMap.keySet().size()==0){
                sb.append(0).append("\n");
            }

            //가진 의상종류가 한가지인 경우 그냥 map의 value값 출력
            if(dressMap.keySet().size()==1){
                for(String dressType : dressMap.keySet()){
                    sb.append(dressMap.get(dressType)).append("\n");
                }
                //가능한 의상조합 경우의 수
            } else if(dressMap.keySet().size() > 1) {
                int count = 1;
                for(String dressType : dressMap.keySet()){
                    //해당 종류를 안입는 경우까지 카운트하고, 아무것도 안입는 경우만 빼기
                    count *= dressMap.get(dressType) + 1;
                }
                sb.append(count - 1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
