import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 189080kb
 * 2328ms
 * 레드블랙트리(TreeSet) 정렬, O(N log N)
 * 이진탐색, O(N log N)
 */
public class BOJ18870좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] intArr = new int[N];
        TreeSet<Integer> sortedSet = new TreeSet();

        for(int i=0; i<N; i++){
             int num = Integer.parseInt(st.nextToken());
             intArr[i] = num;
             //서로 다른 좌표의 개수이므로, 중복없는 집합을 만든다.
             sortedSet.add(num);//정렬 O(N log N)
        }

        //toArray(T[] a) : 입력 배열의 크기가 컬렉션 크기보다 작을 경우, 메서드는 새로운 배열을 할당
        //toArray(new Integer[0] : 컬렉션을 배열로 변환할 때 널리 사용되는 관습적인 방법
        //정확한 배열의 크기를 넘기는 것이 나을 것 같지만, 사실 이 차이는 대부분의 상황에서 미미
        Integer[] sortedArr = sortedSet.toArray(new Integer[0]);

        StringBuilder sb = new StringBuilder();
        //O(n log n)
        for(int i=0; i<N; i++){
            sb.append(binarySearch(intArr[i], sortedArr)).append(" ");
        }
        System.out.println(sb);

    }

    //그냥 제너릭 메서드를 만들어보고 싶었습니다.
    //O(N log N)
    private static <T extends Comparable<T>> int binarySearch(T target, T[] sortedArr) {
        int low = 0;
        int high = sortedArr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // (low+high)/2와 같지만, low+high가 int 범위 초과하는 overflow 방지

            if (sortedArr[mid].compareTo(target) == 0) {
                return mid;
            } else if (sortedArr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0; // 타겟을 찾지 못한 경우 // 0을 출력하는 건 문제요구사항
    }
}
