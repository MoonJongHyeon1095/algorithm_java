import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 메모리 226776kb
 * 시간 732ms
 */

public class P11478서로다른부분문자열의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = recursiveSubstring(input);
        System.out.println(answer);

    }
//시간초과
//    private static void combination(String input){
//        if (input.isEmpty()) {
//            return;
//        }
//        strSet.add(input);
//
//        String sub1 = input.substring(0, input.length()-2);
//        String sub2 = input.substring(1, input.length()-1);
//
//        combination(sub1);
//        combination(sub2);
//
//    }

    private static int recursiveSubstring(String input) {
        Set<String> substringSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                substringSet.add(input.substring(i, j));
            }
        }
        return substringSet.size();
    }
}
