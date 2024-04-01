import java.io.*;
import java.util.*;

/**
 * 16544kb
 * 172ms
 */

public class BOJ1652누울자리찾아라 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String[] strArr = new String[N];
        int horizontalCount = 0;
        int verticalCount = 0;


        for (int i = 0; i < N; i++) {
            strArr[i] = br.readLine();
        }


        for(int i = 0; i<N; i++) {
            String[] parts = strArr[i].split("X");
            for (String part : parts) {
                if (part.length() >= 2) {
                    horizontalCount++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            StringBuilder column = new StringBuilder();
            for (int j = 0; j < N; j++) {
                column.append(strArr[j].charAt(i));
            }
            String[] parts = column.toString().split("X");
            for (String part : parts) {
                if (part.length() >= 2) {
                    verticalCount++;
                }
            }
        }
        System.out.println(horizontalCount + " " + verticalCount);
    }
}
