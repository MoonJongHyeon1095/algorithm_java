import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 64036kb
 * 696ms
 */
public class BOJ2108통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for(int i=0; i<N; i++){
            int current = Integer.parseInt(br.readLine());
            sum+=current;
            arr[i] = current;
            map.put(current, map.getOrDefault(current, 0)+1);
        }

        //산술평균
        System.out.println(Math.round((double)sum / N ));

        //중앙값
        Arrays.sort(arr);
        System.out.println(arr[N/2]); //N은 1이상의 홀수라는 조건 때문

        //최빈값 //너무 막무가내로 풀어서, 더 좋은 방법이 있을 것.
        int maxValue = map.values().stream().max(Integer::compare).orElse(-1);
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) {
                list.add(entry.getKey());
            }
        }
        list.sort((a,b)->a-b);
        if(list.size()==1){
            System.out.println(list.get(0));
        }else{
            System.out.println(list.get(1));
        }

        //범위
        System.out.println(arr[N-1]-arr[0]);
    }
}
