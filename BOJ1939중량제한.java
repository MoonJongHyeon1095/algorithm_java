import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 63104kb
 * 608ms
 * 1. 그래프 구현 관련
 * 처음에는 섬을 노드로, 다리를 간선으로 만들었으나 지나치게 복잡해짐
 * (그래프 간선 가중치의 깔끔한 구현방법 알아볼 것)
 * 섬이 아니라 다리를 대신 노드로 사용
 *
 * 2.간선 가중치 처리 방법
 * 배열 안에 ArrayList로 저장 (ArrayList<Bridge>[] bridgeList)
 * DFS로 검사시 가중치 조건에 따라 타고 들어가거나 더 들어가지 못하도록 한다
 *
 * 3. 탐색 기능 관련
 * DFS의 결과를 이분탐색에서 반을 접는 조건으로 활용
 * 이진탐색 O(log 입력된최대중량)
 * DFS O(섬의 개수 + 다리의 개수)
 * 전체 시간복잡도 O(log 최대중량 * (V + E))
 */
public class BOJ1939중량제한 {
    static int N, M;
    //static ArrayList<Bridge>[] bridgeList;
    static int startIsland, destIsland;
    static boolean[] visited;

    private static class Bridge {
        int to;
        long weight;

        Bridge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 섬의 개수
        M = Integer.parseInt(st.nextToken()); // 다리의 개수
        visited = new boolean[N + 1]; // 섬 번호가 1부터 시작하므로 N+1로 초기화
        ArrayList<Bridge>[] bridgeList = new ArrayList[N+1]; // 섬 번호가 1부터 시작하므로 N+1로 초기화
        //ArrayList<Bridge>[] bridgeList = (ArrayList<Bridge>[]) new ArrayList[N + 1]; // 섬 번호가 1부터 시작하므로 N+1로 초기화
        for (int i = 0; i <= N; i++) {
            bridgeList[i] = new ArrayList<>();
        }

        long left = 1, right = 0, mid = 0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());

            //양방향
            //배열 안에 ArrayList사용했기 때문에 같은 인덱스라도 덮어써지지 않는다
            //섬 1과 섬 2 사이에 중량제한이 각각 10인 다리와 20인 다리가 있다면
            //bridgeList[1]에는 Bridge(2, 10)과 Bridge(2, 20)이라는 두 개의 다른 Bridge 객체가 추가
            bridgeList[a].add(new Bridge(b, weight));
            bridgeList[b].add(new Bridge(a, weight));

            right = Math.max(right, weight);
        }

        st = new StringTokenizer(br.readLine());
        startIsland = Integer.parseInt(st.nextToken());
        destIsland = Integer.parseInt(st.nextToken());
        br.close();

        //이진탐색 O(log 최대무게중량)
        long maxWeight = 0;
        while (left <= right) {
            mid = left + (right - left)/2;

            //dfs 전에 방문배열 초기화 //이거 안해서 계속 틀림
            Arrays.fill(visited, false);

            //해당 무게제한으로 목적지 도달 가능하면 //왼쪽 버리고 무게 늘리기
            if (dfs(startIsland, mid, bridgeList)) {
                maxWeight = mid;
                left = mid + 1;
            } else {
                //해당 무게제한으로 목적지 도달 안되면 //오른쪽 버리고 무게 줄이기
                right = mid - 1;
            }
        }

        System.out.println(maxWeight);
    }

    //O(섬의 개수 + 다리 개수)
    //해당 중량으로 찾아지는지
    private static boolean dfs(int currentIsland, long weightLimit, ArrayList<Bridge>[] bridgeList) {
        if (currentIsland == destIsland) return true;
        visited[currentIsland] = true;

        for (Bridge next : bridgeList[currentIsland]) {
            //다음 다리 중량제한이 지금 중량보다 크거나 같으면
            if (!visited[next.to] && next.weight >= weightLimit) {
                if (dfs(next.to, weightLimit, bridgeList)) return true;
            }
        }

        return false;
    }
}
