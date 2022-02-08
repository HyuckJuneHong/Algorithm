package floyd_warshall;

/** Floyd_Warshall_Algorithm
 * - 모든 정점에서 모든 정점으로의 최단 경로를 구하는 알고리즘
 * - 기본적으로 거쳐가는 정점을 기준으로 알고리즘을 수행한다.
 * - 기본적으로 다이나믹 프로그래밍 기술에 의거한다.
 */
public class Floyd_Warshall_Algorithm {

    public static int N = 4;
    public static int INF = 10000000;

    public static int[][] dp = new int[][]{
            {0, 5, INF, 8},
            {7, 0, 9, INF},
            {2, INF, 0, 4},
            {INF, INF, 3, 0}
    };

    public static void main(String[] args) {
        floydWarshall();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void floydWarshall() {

        // k : 거쳐가는 노드
        for (int k = 0; k < N; k++) {
            // i : 출발 노드
            for (int i = 0; i < N; i++) {
                // j : 도착 노드
                for (int j = 0; j < N; j++) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }
    }
}
