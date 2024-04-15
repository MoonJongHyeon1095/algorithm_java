import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 14352kb
 * 124ms
 * 재귀 : 최악의 경우 O(N^2)
 */
public class BOJ12919A와B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        System.out.println(isTransformable(S, T) ? 1 : 0);
    }

    private static boolean isTransformable(String s, String t) {

        if (t.equals(s)) {
            return true;
        }

        if (t.length() <= s.length()) {
            return false;
        }


        // 끝에서 A를 제거하고 재귀 호출
        if (t.charAt(t.length() - 1) == 'A') {
            if (isTransformable(s, t.substring(0, t.length() - 1))) {
                return true;
            }
        }

        // 앞에서 B를 제거하고 뒤집고 재귀호출
        if (t.charAt(0) == 'B') {
            String reversed = new StringBuilder(t.substring(1)).reverse().toString();
            if (isTransformable(s, reversed)) {
                return true;
            }
        }
        return false;
    }
}

