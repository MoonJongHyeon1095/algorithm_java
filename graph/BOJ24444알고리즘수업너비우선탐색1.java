package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 101344kb
 * 920ms
 * 차라리 처음 배울 때의 그래프 모양 그대로 만들고 싶어서 Node 클래스를 만들어봤습니다
 * 인접 노트리스트 오름차순 정렬유지에 TreeSet 사용 : O(N log N)
 * 인접 리스트만 사용하는 경우 BFS 시간복잡도 : O(N + E) (E는 인접 노드의 수)
 * TreeSet으로 정렬을 유지하는 BFS 시간복잡도 : O( E * log N) (E는 인접 노드의 수)
 * 단순히 모든 인접 노드를 방문하는 것이 목표라면, 인접 리스트는 그냥 배열이나 List 사용하는 것이 낫다
 */
public class BOJ24444알고리즘수업너비우선탐색1 {
    private static int count = 1;//방문순서
    private static int N, M, R;
    private static int[] sequenceArr;
    private static Node[] nodeArr;

    private static class Node {
        int id;
        boolean isVisited;
        TreeSet<Node> adjacent; // 인접 노드 리스트

        Node(int id) {
            this.id = id;
            this.isVisited = false;
            this.adjacent = new TreeSet<>(Comparator.comparingInt(node -> node.id));
        }

        // 인접 노드 추가 메소드
        private void addAdjacentNode(Node node) {
            this.adjacent.add(node);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        nodeArr = new Node[N + 1]; // 노드 ID가 1부터 시작한다고 가정
        for (int i = 1; i <= N; i++) {
            nodeArr[i] = new Node(i);
        }
        sequenceArr = new int[N + 1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            //무방향 그래프
            nodeArr[start].addAdjacentNode(nodeArr[dest]);
            nodeArr[dest].addAdjacentNode(nodeArr[start]);
        }
        br.close();

        bfs(nodeArr[R]);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<sequenceArr.length; i++){
            sb.append(sequenceArr[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(Node startNode){
        Queue<Node> q = new LinkedList<>();
        startNode.isVisited = true; // 시작 노드 방문표시
        q.add(startNode);

        while(!q.isEmpty()){
            Node vertex = q.poll();
            sequenceArr[vertex.id] = count++; // 방문 순서

            for(Node adj : vertex.adjacent){
                if(!adj.isVisited){
                    adj.isVisited = true;
                    q.add(adj);
                }
            }
        }
    }
}
