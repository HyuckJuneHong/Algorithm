package Dijkstra;

import java.io.*;
import java.util.*;

/**Dijkstra Algorithm (Shortest Path)
 * - 최단 경로 탐색 알고리즘이다.
 * - 흔히 인공위성 GPS 소프트웨어 등에서 가장 많이 사용된다.
 * - 특정한 하나의 정점에서 다른 모든 정점으로 가는 최단 경로를 알려준다.
 *   -> 다만, 음의 간선을 포함할 수는 없다.
 *   -> 때문에, 현실 세계엔 음의 간선이 존재하지 않으니, 현실 세계에 가장 적합한 알고리즘이다.
 *
 *다이나믹 프로그래밍의 문제라고 불리는 이유
 * - 최단 거리는 여러 개의 최단 거리로 이루어져 있기 때문이다.
 *   -> 즉, 작은 문제가 큰 문제의 부분 집합에 속해 있다고 볼 수 있다.
 *특징
 * - 하나의 최단 거리를 구할 때 그 이전까지 구했던 최단 거리 정보를 그대로 사용한다.
 *
 *과정
 * 1. 출발 노드를 설정한다.
 * 2. 출발 노드를 기준으로 각 노드의 최소 비용을 저장한다.
 * 3. 방문하지 않은 노드 중에서 가장 비용이 적은 노드를 선택한다.
 * 4. 해당 노드를 거쳐 특정한 노드로 가는 경우를 고려하여 최소 비용을 갱신한다.
 * 5. 위 과정에서 3~4번을 반복한다.
 *
 *시간 복잡도 - 우선 순위 큐 방식 (선호 방법)
 * - O(N * logN)
 * - 이 방식일 경우 정점에 비해 간선의 갯수가 비정상적으로 적어도 안정적으로 처리할 수 있다.
 */
public class Dijkstra_Algorithm {

    public static final int INF = Integer.MAX_VALUE;
    public static List<List<Node>> graph;
    public static int d[];
    public static int edge;     //간선
    public static int vertices; //정점


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //정점, 간선 설정
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertices = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        //시작인덱스 입력
        int startIndex = Integer.parseInt(br.readLine());

        //최단거리 배열d INF로 초기화
        d = new int[vertices+1];
        Arrays.fill(d, INF);

        //그래프 생성
        graph = new ArrayList<>();
        for(int i=0; i<=vertices+1; i++){
            graph.add(new ArrayList<>());
        }

        //입력값에 따른 그래프 초기화
        for(int i=0; i<edge; i++){

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        dijkstra(startIndex);
        for(int i=1; i<vertices+1; i++){
            if(d[i] == INF) bw.write("INF");
            else bw.write(d[i] + "");

            bw.newLine();
        }
        bw.flush();
        bw.close();

    }

    private static void dijkstra(int index) {

        PriorityQueue<Node> pq = new PriorityQueue<>(); //최단거리 갱신된 노드 담을 큐
        d[index] = 0; //시작지점노드 값 0으로 지정
        pq.offer(new Node(index, d[index]));

        while (!pq.isEmpty()){

            Node node = pq.poll();
            int nodeIndex = node.index;
            int nodeCost = node.cost;

            if(d[nodeIndex] < nodeCost) continue;

            for(Node linkNode : graph.get(nodeIndex)){
                int nowNode = linkNode.index;
                int nextCost = nodeCost + linkNode.cost;

                if(nextCost < d[nowNode]){
                    d[nowNode] = nextCost;
                    pq.offer(new Node(nowNode, nextCost));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int index;
        int cost;

        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {

            //this < o.cost : -1 / this==o.cost: 0 / this>o.cost: 1
            return Integer.compare(this.cost, o.cost);
        }
    }
}
