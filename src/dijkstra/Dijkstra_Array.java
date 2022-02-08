package dijkstra;

/**
 * 선형 탐색 다익스트라 알고리즘은 시간 복잡도가 N*N 이기 때문에,
 * 좋지 않은 방법이다.
 */

public class Dijkstra_Array {

    public static int inf = Integer.MAX_VALUE;
    public static int arr[][] = new int[][]{
            {0, 2, 5, 1, inf, inf},
            {2, 0, 3, 2, inf, inf},
            {5, 3, 0, 3, 1, 5},
            {1, 2, 3, 0, 1, inf},
            {inf, inf, 1, 1, 0, 2},
            {inf, inf, 5, inf, 2, 0}
    };

    public static boolean visited[] = new boolean[6];
    public static int d[] = new int[6];

    public static void main(String[] args){

        dijkstra(0);
        for(int i=0; i<6; i++){
            System.out.println(d[i]);
        }
    }

    public static int getSmallIndex(){
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i=0; i<6; i++){
            if(d[i] < min && !visited[i]){
                min = d[i];
                index = i;
            }
        }

        return index;
    }

    public static void dijkstra(int start){
        for(int i=0; i<6; i++){
            d[i] = arr[start][i];
        }

        visited[start] = true;
        for(int i=0; i<4; i++){
            int current = getSmallIndex();
            visited[current] = true;

            for(int j=0; j<6; j++){
                if(!visited[j]){
                    if(d[current] + arr[current][j] < d[j]){
                        d[j] = d[current] + arr[current][j];
                    }
                }
            }
        }


    }

}
