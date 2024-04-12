/**
 * 순열의 시간복잡도: `**O(n!)**`
 *
 * 조합의 시간복잡도: `**O(2^n)**`
 *
 * </aside>
 */

public class Combination {

    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];

        for(int c = 1; c <= n; c++) {
            System.out.println(n + "개 중에서 " + c + "개 뽑기");
            combination(arr, visited, 0, n, c);
            System.out.println("");
        }
    }

    public static void combination(
            int[] arr,
            boolean[] visited,
            int start,
            int n,
            int r
    ) {
        if (r == 0) {
            for (int i =0; i<n; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println("");
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}

