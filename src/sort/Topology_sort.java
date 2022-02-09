package sort;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Topology Sort Algorithm (위상 정렬)
 * - 순서가 정해져있는 작업을 차례로 수행해야할 때, 그 순서를 결정해주기 위해 사용하는 알고리즘.
 * - 그래프의 흐름은 조건으로 해석할 수 있다.
 *   (Ex: 대학생 되기 -> 4학년 되기 -> 기사자격증 따기 -> 취업하기(네카라쿠배당토))
 * - DAG(Directed Acyclic Graph)에만 적용이 가능하다.
 *   -> DAG : 사이클이 발생하지 않는 방향 그래프를 의미
 *   -> 즉, 사이클이 발생할 경우 위상 정렬 수행 불가.
 *   -> 이유 : 시작점이 존재해야 하는데, 사이클이 있으면 시작점을 찾을 수 없기 때문.
 *
 *위상 정렬 특징
 * 1. 두 가지 해결책을 낸다.
 *  -> 현재 그래프는 위상 정렬이 가능한지.
 *  -> 위상 정렬이 가능하다면, 그 결과는 무엇인지
 *  -> 하나는 스택을 이용한 방식이고 다른 하나는 큐를 이용한 방식이다.
 *
 *Queue를 이용한 순서
 * 1. 진입 차수가 0인 정점을 큐에 삽입
 * 2. 큐에서 원소를 꺼내 연결된 모든 간선 제거
 * 3. 간선 제거 이후 진입 차수가 0이 된 정점을 큐에 삽입
 * 4. 큐가 빌 때까지 2~3번 과정 반복
 * 5. 모든 원소 방문 전 큐가 빈다면, 사이클이 존재하는 것이고
 *    모든 원소를 방문했다면, 큐에서 꺼낸 순서가 위상 정렬의 결과이다.
 *
 *시간 복잡도
 * - O(V+E) : 정점의 갯수 + 간선의 갯수
 * - 즉, 매우 빠른 알고리즘 중 하나
 */
public class Topology_sort {

    static int edge[] = new int[7];    //진입차수 저장 배열
    static ArrayList<ArrayList<Integer>> graph;     //그래프
    static Queue<Integer> q; //큐

    public static void main(String[] args) throws IOException {

        graph = new ArrayList<>();
        for(int i=0; i<7; i++){
            graph.add(new ArrayList<Integer>());
            edge[i] = 0;
        }
        //그래프 각 노드별 인접한 노드 정보 초기화 및 진입 차수 초기화
        graph.get(0).add(1);
        edge[1]++;
        graph.get(0).add(4);
        edge[4]++;
        graph.get(1).add(2);
        edge[2]++;
        graph.get(2).add(3);
        edge[3]++;
        graph.get(3).add(5);
        edge[5]++;
        graph.get(4).add(5);
        edge[5]++;
        graph.get(5).add(6);
        edge[6]++;

        topology();
    }

    public static void topology() throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        q = new LinkedList<>();

        //진입차수가 0인 값 큐에 삽입
        for(int i=0; i< edge.length; i++){
            if(edge[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){

            int nodeIndex = q.poll();

            //꺼낸 노드번호 정렬 결과값에 저장
            bw.write(String.valueOf(nodeIndex) + " ");
            //꺼낸 노드의 인접한 노드 찾기
            List<Integer> list = graph.get(nodeIndex);

            for(int i=0; i<list.size(); i++){
                //인접 노드 진입차수 갱신
                edge[list.get(i)]--;
                //진입차수 0이면 큐에 노드 넣기
                if(edge[list.get(i)] == 0){
                    q.offer(list.get(i));
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
