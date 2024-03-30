import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * 14348kb
 * 128ms
 */
public class BOJ1213팰린드롬 {
    static TreeMap<Character, Integer> charMap = new TreeMap<>();
    static char middleChar = '\0'; //빈값으로 명시해야 함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        for(char c : input){
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        boolean isValidated = validateOdd(charMap, input.length);

        if(isValidated){
            StringBuilder frontHalf = new StringBuilder();
            StringBuilder result = new StringBuilder();

            for (char key : charMap.keySet()) {
                int count = charMap.get(key) / 2;
                for (int i = 0; i < count; i++) {
                    frontHalf.append(key); // 앞쪽 절반에 추가
                }
            }

            StringBuilder reverseHalf = new StringBuilder(frontHalf).reverse(); // frontHalf의 뒤집힌 복사본

            //StringBuilder에 '\0' (null 문자)를 추가하면, 이는 "없는 문자"로 처리되지 않고 실제로 null 문자가 결과 문자열에 포함
            if (middleChar != '\0') {
                result.append(frontHalf).append(middleChar).append(reverseHalf);
            } else {
                result.append(frontHalf).append(reverseHalf);
            }
            System.out.println(result);
        }else{
            System.out.println("I'm Sorry Hansoo");
        }


    }

    private static boolean validateOdd(Map<Character, Integer> charMap, int inputLength){
        int oddCount = 0;

        for(char key : charMap.keySet()){
            int count = charMap.get(key);
            if (count % 2 != 0) {
                oddCount++;
                middleChar = key;
            }

            if ((inputLength % 2 == 0 && oddCount > 0) || oddCount > 1) {

                return false;
            }

        }
        return true;
    }
}
