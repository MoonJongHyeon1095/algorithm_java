public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // (low + high) / 2와 같지만, overflow 방지

            if (arr[mid] == target) {
                return mid; // 타겟을 찾은 경우
            } else if (arr[mid] < target) {
                low = mid + 1; // 타겟이 중간값보다 크면, 왼쪽 범위를 무시
            } else {
                high = mid - 1; // 타겟이 중간값보다 작으면, 오른쪽 범위를 무시
            }
        }

        return -1; // 타겟을 찾지 못한 경우
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
        int target = 13;

        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}
