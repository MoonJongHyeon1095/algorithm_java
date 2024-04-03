import java.io.*;
import java.util.*;

/**
 * 16680kb
 * 160ms
 * 사용된 개념과 접근법, 어떻게 풀지에 대해 서술하고 시작한다.
 --------------------------------------------------
 * 정규식 비교로 문자열을 빼낸다.
 * 위 작업을 재귀 알고리즘으로 수행한다.
 * 시간복잡도는 O(n^2)이다.
 * 안좋은 예시도 필요할 것 같아 처음 푼 그대로 남겨봅니다.
 --------------------------------------------------
 */
public class BOJ9012괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            //StringTokenizer st = new StringTokenizer(br.readLine());
            String result = recursiveReplace(br.readLine());
            System.out.println(result.length() == 0 ? "YES" : "NO");
        }
    }

    /**
     * replaceAll 메서드의 시간 복잡도는 입력 문자열 str의 길이에 대해 선형적
     * 각 단계마다 최소 한쌍 괄호 제거, 대략 O(n/2) = O(n)
     * 재귀호출 수를 곱하면, 최악의 경우 O(n^2)
     */
    private static String recursiveReplace(String str){
        String replaced = str.replaceAll("\\(\\)", "");
        if (str.equals(replaced)) {
            return str;
        }
        return recursiveReplace(replaced);
    }
}
