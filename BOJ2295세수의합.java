import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 57508kb
 * 396ms
 * x+y+z=k 를 구할 것이 아니라 x+y=k-z를 하면 됨. 그런데 이런 아이디어를 어떻게 떠올리지요...
 * 집합 조건은 Set 사용
 * 정렬은 그냥 List의 sort 사용
 * List.sort() 메소드는 TimSort 알고리즘을 사용합니다.
 * TimSort는 병합 정렬(Merge Sort)과 삽입 정렬(Insertion Sort)의 장점을 결합한 정렬 알고리즘으로, 최악의 경우 시간 복잡도는 O(n log n)입니다.
 *
 */
public class BOJ2295세수의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> sumSet = new HashSet<>();
        //Set<Integer> U = new HashSet<>();
        TreeSet<Integer> U = new TreeSet<>();

        //N개의 줄에 차례로 U의 원소가 하나씩 주어진다. 주어진 U는 집합이 되므로 입력되는 두 수가 같아서는 안 된다
        for(int i=0; i<N; i++){
            U.add(Integer.parseInt(br.readLine()));
            //intArr[i] = Integer.parseInt(br.readLine());
        }

        for(int x : U){
            for(int y : U){
                sumSet.add(x + y);
            }
        }

        List<Integer> numList = new ArrayList<>(U);
        //Collections.sort(numList); //TreeSet사용

        int answer =0;
        outerLoop:
        for(int k=numList.size()-1; k>=0; k--){
            for(int z=0; z<numList.size(); z++){
                    if (sumSet.contains(numList.get(k) - numList.get(z))) {
                        answer =numList.get(k);
                        break outerLoop;
                    }
            }
        }

        System.out.println(answer);
    }
}
