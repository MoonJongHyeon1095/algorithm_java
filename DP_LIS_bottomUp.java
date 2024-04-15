public class DP_LIS_bottomUp {
    public static int longestIncreasingSubsequence(int[] input) {
        int n = input.length;
        int[] intArr = new int[n];

        // Initialize LIS values for all indexes
        for (int i = 0; i < n; i++) {
            intArr[i] = 1;
        }

        // Compute optimized LIS values in a bottom up manner
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //input[0] < input[1] 증가해야한다 && intArr[1] < intArr[0] + 1 기존 길이보다 더 큰 값이면
                if (input[j] < input[i] && intArr[i] < intArr[j] + 1) {
                    intArr[i] = intArr[j] + 1; //intArr[1] = intArr[0] + 1 최대값 갱신
                }
            }
        }

        // Pick the maximum of all LIS values
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < intArr[i]) {
                max = intArr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println("Length of LIS is " + longestIncreasingSubsequence(arr));
    }
}
