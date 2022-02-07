package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Kruskal Algorithm, (크루스칼 알고리즘)
 * - 가장 적은 비용으로 모든 노드를 연결하기 위해 사용하는 알고리즘
 * - 최소 비용 신장 트리를 만들기 위해 사용하는 대표 알고리즘
 * - 흔히 여러 개의 도시가 있을 때 도시를 도로를 이용해 연결하고자
 *   할 때 비용을 최소한으로 하고자 할 때 적용되는 알고리즘
 * - 최소 스패닝 트리(MST, Minimum Spanning Tree)를 찾음으로서
 *   간선의 가중치의 합이 최솟값이 되도록 하는 알고리즘이라고도 할 수 있습니다.
 *Kruskal의 핵심 개념
 * - 간선을 거리가 짧은 순서대로 그래프에 포함시키면 어떨지,
 *   -> 최대한 적은 비용으로 연결만하면 되기 때문에, 간선 정보를 오름차순으로
 *      정렬한 뒤 비용이 적은 간선부터 그래프에 포함시키면 된다.
 *순서
 * 1. 정렬된 순서에 맞게 그래프에 포함시킴
 * 2. 포함시키기 전 사이클 테이블을 확인
 * 3. 사이클을 형성하는 경우 간선 포함 X
 *시간복잡도
 * - 사실상 정렬알고리즘과, Union-Find 알고리즘의 합이라 할 수 있으므로 정렬 알고리즘 시간 복잡도와 동일하다 생각해도 큰 지장 없음.
 *용어
 * - 노드 = 정점 = 도시 : 그래프에서 동그라미에 해당하는 부분
 * - 간선 = 거리 = 비용 : 그래프에서 선에 해당하는 부분
 * - 사이클 = 그래프가 서로 연결되어 사이클을 형성하는 경우
 *         -> 최소 비용 신장 트리에서는 사이클이 발생하면 안된다.
 *         최소 비용 신장 트리를 찾는 알고리즘입니다.
 * - 스패닝 트리 : 그래프에서 일부 간선을 선택해서 만든 트리.
 * - 최소 스패닝 트리 : 스패닝 트리 중에 선택한 간선의 가중치의 합이 최소인 트리.
 */
public class Kruskal {

    public static void main(String[] args){

        int arr[] = new int[7];
        List<Edge> edgeList = new ArrayList<>();

        edgeList.add(new Edge(1,7,12));
        edgeList.add(new Edge(1,4,28));
        edgeList.add(new Edge(1,2,67));
        edgeList.add(new Edge(1,5,17));
        edgeList.add(new Edge(2,4,24));
        edgeList.add(new Edge(2,5,62));
        edgeList.add(new Edge(3,5,20));
        edgeList.add(new Edge(3,6,37));
        edgeList.add(new Edge(4,7,13));
        edgeList.add(new Edge(5,6,45));
        edgeList.add(new Edge(5,7,73));

        for(int i=0; i<7; i++) {
            arr[i] = i;
        }

        Collections.sort(edgeList);

        int sum = 0;
        for(int i=0; i<edgeList.size(); i++) {

            Edge edge = edgeList.get(i);

            if(!findParent(arr, edge.node[0]-1, edge.node[1]-1)) {
                sum += edge.distance;
                unionParent(arr, edge.node[0]-1, edge.node[1]-1);
            }
        }

        System.out.println(sum);
    }

    public static class Edge implements Comparable<Edge>{

        int node[] = new int[2];
        int distance;

        public Edge(int a, int b, int distance){
            this.node[0] = a;
            this.node[1] = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            //음수면 o.distance > this //양수면 this > o.distance
            return this.distance-o.distance;
        }
    }

    //특정 정점의 부모 정점을 찾는다.
    public static int getParent(int arr[], int x){

        if(arr[x] == x) return x;

        return arr[x] = getParent(arr, arr[x]);
    }

    //Union 연산으로, 각 정점의 부모 노드를 찾은 후, 작은 값을 큰 값의 부모노드로 저장
    public static void unionParent(int arr[], int a, int b){
        a = getParent(arr, a);
        b = getParent(arr, b);

        if(a<b) arr[b] = a;
        else arr[a] = b;
    }

    //두 정점이 연결됐는지 확인 (연결 = 1, 연결 X = 0)
    public static boolean findParent(int arr[], int a, int b){
        a = getParent(arr, a);
        b = getParent(arr, b);

        if(a==b) return true;
        else return false;
    }
}
