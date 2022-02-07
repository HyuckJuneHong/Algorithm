package graph;

/** 깊비 우선 탐색(Depth First Search, BFS)
 * - 탐색 시 깊이를 우선으로 하여 탐색을 수행하는 알고리즘
 * - 컴퓨터는 구조적으로 항상 스택의 원리를 사용하기 때문에
 *   사실 스택을 사용하지 않아도 구현이 가능하다는 특징이 있다.
 *   즉, 재귀함수를 써서 사용하는 경우가 더 간단하기 때문에 자주 나온다.
 * - 준비물: 스택, 그래프
 */
public class DFS_recursion {

    static boolean visited[] = new boolean[9];
    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

    public static void main(String[] args){

        dfs(1);
    }

    public static void dfs(int nodeIndex){

        visited[nodeIndex] = true;
        System.out.print(nodeIndex + "->");

        for(int node: graph[nodeIndex]){
            if(!visited[node]){
                dfs(node);
            }
        }

    }
}
