import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** HashMap
 * 메모리 61604kb
 * 시간 1512ms
 */
/** TreeMap
 * 메모리 58784kb
 * 시간 1448ms
 */

/**
 * HashMap: 키에 대한 해시 함수를 사용하여 값을 저장하는데, 이 때문에 요소들이 정렬되지 않습니다. 따라서 키-값 쌍을 추가, 삭제, 검색할 때 일관된 시간 복잡도인 O(1)을 기대할 수 있습니다. 하지만 최악의 경우(모든 키가 같은 해시 값을 가질 때) 시간 복잡도는 O(n)이 될 수 있습니다.
 * TreeMap: 내부적으로 레드-블랙 트리(Red-Black Tree)라는 균형 이진 검색 트리를 사용하여 요소를 저장합니다. 이로 인해 모든 키-값 쌍이 자동으로 키에 따라 정렬됩니다. 일반적인 연산(추가, 삭제, 검색)의 시간 복잡도는 O(log n)입니다.
 */
public class P20291파일정리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        //Map<String, Integer> extensionMap = new HashMap<>();
        Map<String, Integer> extensionMap = new TreeMap<>();

        for(int i=0; i<length; i++) {
            String[] parts = br.readLine().split("\\.");
            String extension = parts[parts.length - 1]; //혹시 .이 여러개 있을까 해서 마지막 부분 불러옴
            extensionMap.put(extension, extensionMap.getOrDefault(extension, 0) + 1);
            // 맵의 put 및 getOrDefault 연산은 평균적으로 O(1)이므로, 전체적으로 O(N)의 시간이 소요

        }

//        Set<String> extensionSet = extensionMap.keySet();
//        //맵의 키셋을 리스트로 변환 (O(N)): 확장자의 개수를 N이라 할 때, 이 작업 역시 O(N)의 시간 복잡도
//
//        List<String> extensionList = new ArrayList<>(extensionSet);
//        Collections.sort(extensionList);
//        //리스트 정렬 (O(N log N))

//        for(String e : extensionList){
//            System.out.println(e + " " + extensionMap.get(e));
//            //결과 출력 (O(N)):
//        }
        for(String e : extensionMap.keySet()){
            System.out.println(e + " " + extensionMap.get(e));
        }
    }
}
