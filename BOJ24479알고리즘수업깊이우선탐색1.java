import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 93632kb
 * 936ms
 * 행렬로 그래프의 간선 정보를 관리하는 방법이 모두 메모리 초과
 * 차라리 처음 배울 때의 그래프 모양 그대로 만들고 싶어서 Node 클래스를 만들어봤습니다
 * 인접 노트리스트 오름차순 정렬에 TreeSet 사용 : O N log N
 * 재귀 DFS :  O N log N
 */
public class BOJ24479알고리즘수업깊이우선탐색1 {
    private static int count = 1;//방문순서
    private static int N, M, R;
    //메모리 초과 십만*십만 짜리 행렬이 되어버림
    //private static int[][] graph;
    //private static boolean[] visited;
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

        recursiveNodeDFS(nodeArr[R]);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<sequenceArr.length; i++){
            sb.append(sequenceArr[i]).append("\n");
        }
        System.out.println(sb);
    }

        private static void recursiveNodeDFS(Node node){
            if (node.isVisited) return; // 이미 방문한 노드는 건너뜀

            node.isVisited = true; // 현재 노드 방문 처리
            sequenceArr[node.id] = count++; // 방문 순서 기록


            for (Node adjacentNode : node.adjacent) { // 인접 노드 탐색
                recursiveNodeDFS(adjacentNode);
            }
    }

    //메모리 초과
//    private static void recursiveDFS(int strart){
//        visited[strart] = true;
//        sequenceArr[strart] = count++;
//
//        for (int i = 1; i <= N; i++) {
//            if (graph[strart][i] == 1 && !visited[i]) {
//                recursiveDFS(i);
//            }
//        }
//    }

    //메모리 초과
//    private static void stackDFS(int start) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(start);
//        visited[start] = true;
//        //sequenceArr[start]=count;
//
//        while (!stack.isEmpty()) {
//            int vertex = stack.pop();
//            if (sequenceArr[vertex] == 0) {
//                sequenceArr[vertex] = count++;
//            }
//
//            //역순으로 넣어야 나올때 오름차순으로 나온다
//            for (int i = graph.length - 1; i >= 1; i--) {
//                if (graph[vertex][i] == 1 && !visited[i]) {
//                    stack.push(i);
//                    visited[i] = true;
//                }
//            }
//        }
//    }
}
