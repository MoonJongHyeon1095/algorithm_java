public class ParametricSearchExample {

    public static void main(String[] args) {
        // 나무의 높이 예시
        int[] trees = {20, 15, 10, 17};
        // 원하는 나무 길이의 총합
        int M = 7;

        System.out.println("필요한 최소 높이: " + findMinHeight(trees, M));
    }

    public static int findMinHeight(int[] trees, int M) {
        int low = 0; // 가능한 최소 높이
        int high = 0; // 가능한 최대 높이

        // 나무 중에서 가장 높은 나무를 찾는다.
        for (int tree : trees) {
            high = Math.max(high, tree);
        }

        // 이진 탐색 시작
        while (low <= high) {
            int mid = (low + high) / 2;
            long sum = 0; // 잘린 나무 길이의 총합

            // 현재 높이(mid)로 나무들을 잘라본다.
            for (int tree : trees) {
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }

            // 잘린 나무 길이의 총합이 M 이상인지 확인
            if (sum >= M) {
                low = mid + 1; // 조건을 만족하면 더 높은 높이를 탐색
            } else {
                high = mid - 1; // 조건을 만족하지 않으면 더 낮은 높이를 탐색
            }
        }

        // high는 조건을 만족하는 최대 높이이므로, high를 반환
        return high;
    }
}
