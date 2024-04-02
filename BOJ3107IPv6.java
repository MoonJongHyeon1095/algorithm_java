import java.io.*;
import java.util.*;

public class BOJ3107IPv6 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(":", -1);

        List<String> strList = fillZeroArr(strArr);
        StringBuilder sb = new StringBuilder();
        for(String str : strList){
            sb.append(leftConcat(str)).append(':');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static String leftConcat(String input){
        StringBuilder sb = new StringBuilder();
        while (sb.length() + input.length() < 4) {
            sb.append('0');
        }
        return sb.append(input).toString();
    }

    private static List<String> fillZeroArr(String[] strArr){
        List<String> strList = new ArrayList<>(Arrays.asList(strArr));

        int emptyIndex = -1;
        boolean isEmptyFound = false;

        for (int i = 0; i < strList.size(); i++) {
            if (strList.get(i).isEmpty()) {
                if (!isEmptyFound) { // 빈 경우 (::) 를 찾으면 넘어가자
                    emptyIndex = i;
                    isEmptyFound = true;
                    strList.remove(i); // 이후 이 위치에 "0000"을 삽입할 예정
                    i--; // 요소를 제거했으니 인덱스 조정
                }
            }
        }

        int missingCount = 8 - strList.size();
        for (int i = 0; i < missingCount; i++) {
            if (emptyIndex != -1) {
                strList.add(emptyIndex, "0000");
            } else {
                strList.add("0000");
            }
        }

        return strList;
    }
}
