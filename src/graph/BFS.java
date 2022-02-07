package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** 너비 우선 탐색(Bread First Search, BFS)
 * - 탐색 시 너비를 우선으로 하여 탐색을 수행하는 알고리즘
 * - 최단 길이를 보장해야할 때 자주 사용
 * - 준비물: 큐, 그래프
 */
public class BFS {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt(); //정점
//        int m = sc.nextInt(); //간선
        int start = sc.nextInt(); //시작 노드

        boolean visited[] = new boolean[9];
//        int[][] graph = new int[size][size];

        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};


        System.out.println(bfs(start, graph, visited));
    }

    public static String bfs(int start, int[][] graph, boolean[] visited){

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            sb.append(node + "->");
            for(int i=0; i<graph[node].length; i++){
                int temp = graph[node][i];
                System.out.println("temp: " + temp);
                if(!visited[temp]){
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
        }
        return sb.toString();
    }
}
