package programmers;

public class LV1_행렬의덧셈 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }


        return answer;
    }

//    public static void main(String[] args) {
//        int[][] arr1 = {{1, 2}, {3, 4}};
//        int[][] arr2 = {{5, 6}, {7, 8}};
//
//        int[][] result = solution(arr1, arr2);
//
//        for (int i = 0; i < result.length; i++) {
//            for (int j = 0; j < result[i].length; j++) {
//                System.out.print(result[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
}
