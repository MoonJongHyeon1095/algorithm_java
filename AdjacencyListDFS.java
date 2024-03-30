import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AdjacencyListDFS {
    static ArrayList<Integer>[] adjList; //배열의 배열들
    static boolean[] visited;
    static ArrayList<Integer> output = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        int startVertex = sc.nextInt();

        adjList = new ArrayList[vertex + 1]; //편의상 인덱스를 1부터 쓰기 위해 길이를 하나 늘림

        //adjList 안에 각각 인접리스트 생성
        for(int i=0; i< adjList.length; i++){
            adjList[i] = new ArrayList<>();
        }

        visited = new boolean[vertex + 1];

        for(int i=0; i<edge; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            adjList[x].add(y);
            adjList[y].add(x);
        }

        for(int i=1; i<vertex+1; i++){
            Collections.sort(adjList[i]);
        }

        dfs(startVertex);

        for(Integer i : output){
            System.out.print(i + " ");
        }
        System.out.println();

    }

    private static void dfs(int x){
        if(visited[x]){
            return;
        }
        visited[x] = true;
        output.add(x);
        for(int y : adjList[x]){
            if(!visited[y]){
                dfs(y);
            }
        }
    }


}
