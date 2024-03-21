package programmers;

public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

            for(int i = 0; i < n; i++){
                String binaryString1 = Integer.toBinaryString(arr1[i]);
                String binaryString2 = Integer.toBinaryString(arr2[i]);
                binaryString1 = leftPad(binaryString1, n);
                binaryString2 = leftPad(binaryString2, n);

                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    char char1 = binaryString1.charAt(j);
                    char char2 = binaryString2.charAt(j);

                    if (char1 == '1' || char2 == '1') {
                        sb.append('#');
                    } else {
                        sb.append(' ');
                    }
                }

                answer[i] = sb.toString();
            }


        return answer;
    }
    private String leftPad(String str, int length) {
        return String.format("%" + length + "s", str).replace(' ', '0');
    }
}
