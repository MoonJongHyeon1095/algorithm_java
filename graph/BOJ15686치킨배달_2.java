package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 16044kb
 * 218ms
 */
public class BOJ15686치킨배달_2 {

    static List<Point> homeList = new ArrayList<>();
    static List<Point> chickenList = new ArrayList<>();
    static int minCityDistance = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int n = Integer.parseInt(st.nextToken());
                if(n==1){
                    homeList.add(new Point(i, j));
                }else if(n==2){
                    chickenList.add(new Point(i, j));
                }
            }
        }


        visited = new boolean[chickenList.size()];

        dfs(0, chickenList.size(), M);
        System.out.println(minCityDistance);

    }

    static void dfs(int start, int chickenListSize, int remainChicken){
        if(remainChicken ==0){
            //true 표기된 인덱스들에 대해 계산
            minCityDistance = Math.min(minCityDistance, getCityDistance());
            return;
        }
        for (int i = start; i < chickenListSize; i++) {
            visited[i] = true;
            dfs(i + 1, chickenListSize, remainChicken-1);
            visited[i] = false; //초기화 //백트래킹
        }
    }


    private static int getCityDistance(){
        int cityDistance = 0;
        for (Point home : homeList) {
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < chickenList.size(); i++) {
                if (visited[i]) {
                    Point chicken = chickenList.get(i);
                    int distance = getDistance(home, chicken);
                    minDistance = Math.min(minDistance, distance);
                }
            }
            cityDistance += minDistance;
        }
        return cityDistance;
    }

    private static int getDistance(Point current, Point dest){
        return Math.abs(current.row - dest.row) + Math.abs(current.column - dest.column);
    }

    static class Point {
        int row, column;
        Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
