import java.util.*;

public class Graph {
    static class Node {
        int id;
        boolean isVisited;
        List<Node> adjacent; // 인접 노드 리스트

        public Node(int id) {
            this.id = id;
            this.isVisited = false;
            this.adjacent = new ArrayList<>();
        }

        // 인접 노드 추가 메소드
        public void addAdjacentNode(Node node) {
            this.adjacent.add(node);
        }
    }

    private Node[] nodes; // 노드 배열

    public Graph(int vertices) {
        nodes = new Node[vertices];
        for (int i = 0; i < vertices; i++) {
            nodes[i] = new Node(i); // 각 노드 초기화
        }
    }

    public void addEdge(int src, int dest) {
        Node srcNode = nodes[src];
        Node destNode = nodes[dest];

        srcNode.addAdjacentNode(destNode); // 단방향; src에서 dest로
        // 무방향 그래프인 경우, 다음 줄 추가
        // destNode.addAdjacentNode(srcNode);
    }

    public void DFS(int startId) {
        Node startNode = nodes[startId];
        DFSHelper(startNode);
    }

    private void DFSHelper(Node node) {
        if (node.isVisited) return;

        node.isVisited = true;
        System.out.print(node.id + " ");

        for (Node adj : node.adjacent) {
            if (!adj.isVisited) {
                DFSHelper(adj);
            }
        }
    }

    public void BFS(int startId) {
        Node startNode = nodes[startId];
        Queue<Node> queue = new LinkedList<>();

        startNode.isVisited = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.id + " ");

            for (Node adj : node.adjacent) {
                if (!adj.isVisited) {
                    adj.isVisited = true;
                    queue.add(adj);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        // g.addEdge(3, 3); // 자기 자신으로의 에지는 필요에 따라 추가

        System.out.println("Depth First Traversal starting from vertex 0:");
        g.DFS(0);

        // 그래프의 탐색을 다시 수행하기 전에 모든 노드의 isVisited를 false로 초기화해야 합니다.
        System.out.println("\nBreadth First Traversal starting from vertex 0:");
        for (Node n : g.nodes) {
            n.isVisited = false;
        }
        g.BFS(0);
    }
}
