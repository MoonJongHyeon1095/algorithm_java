package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 23696kb
 * 296ms
 * 시간초과한 방법 O(N^2)
 * 스택을 사용한 방법 O(N)
 */
public class BOJ16120PPAP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //String result = recursiveReplace(br.readLine());
        //System.out.println(result.length() == 0 || result.contains("A") ? "NP" : "PPAP");

        System.out.println(validatePPAP(br.readLine()) ? "PPAP" : "NP");

    }

    //시간복잡도 O(N^2) //역시 시간초과
//    private static String recursiveReplace(String str){
//        String replaced = str.replaceAll("PPAP", "P");
//        if (str.equals(replaced)) {
//            return str;
//        }
//        return recursiveReplace(replaced);
//    }

    private static boolean validatePPAP(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 'P'를 만날 경우 스택에 추가
            if (c == 'P') {
                stack.push(c);
            } else if (c == 'A') {
                // 스택에 PP 두글자 있을 것 && 문자열의 A 다음 문자가 P일 것
                //i < str.length() - 1 조건 먼저 넣어야 인덱스 범위 안벗어남
                if (stack.size() >= 2 && i < str.length() - 1 && str.charAt(i + 1) == 'P') {
                    stack.pop(); //P를 하나만 남김
                    i++; // 'A' 다음 'P'를 건너뛰어야 PPAP가 P로 치환된 것과 같음
                } else {
                    return false;
                }
            }
        }

        return stack.size() == 1; // 유효한 PPAP 문자열이면, 스택에 'P' 하나만 남음
    }
}
