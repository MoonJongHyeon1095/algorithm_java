import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ1157단어공부 {
    public class Main{
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine().toUpperCase();
            Map<Character, Integer> countMap = new HashMap<>();
            for (char c : input.toCharArray()) {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }

            char answerChar = findChar(countMap);

            System.out.println(answerChar);

        }

        private static char findChar(Map<Character, Integer> countMap){
            int maxCount = 0;
            char maxChar = '?';
            for (char key : countMap.keySet()) {
                int count = countMap.get(key);
                if (count > maxCount) {
                    maxCount = count;
                    maxChar = key;
                } else if (count == maxCount) {
                    maxChar = '?'; // 가장 많이 등장한 문자가 여러 개인 경우
                }
            }
            return maxChar;
        }
    }
}
