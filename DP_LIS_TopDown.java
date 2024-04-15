public class DP_LIS_TopDown {
    // 메모이제이션을 위한 배열 선언
    private static int[] memo;

    public static int longestIncreasingSubsequence(int[] input) {
        int n = input.length;
        memo = new int[n];
        int maxLen = 0;

        // 메모이제이션 배열 초기화
        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }

        // 각 요소에서 시작하는 LIS의 길이를 계산
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, lisFrom(i, input));
        }

        return maxLen;
    }

    // 재귀 함수를 사용하여 해당 인덱스에서 시작하는 LIS의 길이를 계산
    private static int lisFrom(int index, int[] input) {
        // 메모이제이션 확인
        if (memo[index] != -1) {
            return memo[index];
        }

        int maxLen = 1; // 최소 길이는 자기 자신을 포함하므로 1
        for (int i = index + 1; i < input.length; i++) {
            //증가하면
            if (input[i] > input[index]) {
                //최대값 갱신
                maxLen = Math.max(maxLen, 1 + lisFrom(i, input));
            }
        }

        // 계산된 길이를 저장
        memo[index] = maxLen;
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println("Length of LIS is " + longestIncreasingSubsequence(arr));
    }
}
