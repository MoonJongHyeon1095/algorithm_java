import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ28432끝말잇기 {
    static String prevStr;
    static String nextStr;
    static String startChar;
    static String lastChar;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        List<String> strArr = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            strArr.add(br.readLine());
        }

        int caseNum = validateIndex(strArr);
        List<String> candidates = new ArrayList<>();
        int candidateLength = Integer.parseInt(br.readLine());

        //
        if(length==1){
            System.out.println(br.readLine());
            return;
        }

        switch (caseNum) {
            case 1: // "?"가 첫 번째 위치에 있을 때
                for (int i = 0; i < candidateLength; i++) {
                    String target = br.readLine();
                    String[] parts = target.split("");
                    if(strArr.contains(target)) continue;
//                    if (target.charAt(target.length()-1) == lastChar) {
//                        System.out.println(target);
//                    }
                    if(parts[parts.length-1].equals(lastChar)){
                        System.out.println(target);
                    }
                }
                break;

            case 2: // "?"가 마지막 위치에 있을 때
                for (int i = 0; i < candidateLength; i++) {
                    String target = br.readLine();
                    String[] parts = target.split("");
                    if(strArr.contains(target)) continue;
                    if (parts[0].equals(startChar)) {
                        System.out.println(target);
                    }
                }
                break;

            case 3: // "?"가 중간에 위치할 때
                for (int i = 0; i < candidateLength; i++) {
                    String target = br.readLine();
                    String[] parts = target.split("");
                    if(strArr.contains(target)) continue;
                    if (parts[0].equals(startChar) && parts[parts.length-1].equals(lastChar)) {
                        System.out.println(target);
                    }
                }
                break;
        }
//        System.out.println(candidates.get(0));

    }

    private static int validateIndex(List<String> strArr){
        int idx = strArr.indexOf("?");
        //?가 처음이나 끝에 있을 떄
        if (idx == 0 ) {
            nextStr = strArr.get(idx+1);
            lastChar = String.valueOf(nextStr.charAt(0));
            return 1;
        }else if(idx == strArr.size() - 1){
            prevStr = strArr.get(idx-1);
            startChar = String.valueOf(prevStr.charAt(prevStr.length()-1));
            return 2;
        }else{
           prevStr = strArr.get(idx-1);
           nextStr = strArr.get(idx+1);
           startChar = String.valueOf(prevStr.charAt(prevStr.length()-1));
           lastChar = String.valueOf(nextStr.charAt(0));
           return 3;
        }

    }

}
