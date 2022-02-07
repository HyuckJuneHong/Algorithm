package graph;

/** Union Find Algorith (합집합 찾기 or 서로소 집합, Disjoint_Set Algorithm)
 * - 여러 노드가 존재할 때, 두 개의 노드를 선택해서, 현재 두 노드가 서로 같은 그래프에 속하는지 판별하는 알고리즘
 * - 두 개의 노드의 부모 노드를 확인하여 현재 같은 집합에 속하는지 확인하는 알고리즘
 * - 다른 고급 그래프 알고리즘의 베이스가 된다.
 *2가지 연산으로 이루어짐
 * - Find : x가 어떤 집합에 포함돼 있는지 찾는 연산
 * - Union : x와 y가 포함되어 있는 집합을 합치는 연산
 */
public class Union_Find {

    public static void main(String[] args){

        int arr[] = new int[11];

        for(int i=0; i<10; i++){
            arr[i] = i;
        }
        unionParent(arr, 1, 2);
        unionParent(arr, 2, 3);
        unionParent(arr, 3, 4);
        unionParent(arr, 5, 6);
        unionParent(arr, 6, 7);
        unionParent(arr, 7, 8);

        System.out.println("0, 5 연결 됐나요? =>" + findParent(arr, 1, 5));
        unionParent(arr, 1, 5);
        System.out.println("0, 5 연결 됐나요? =>" + findParent(arr, 1, 5));

    }

    //특정 정점의 부모 정점을 찾는다.
    public static int getParent(int arr[], int x){

        if(arr[x] == x){
            return x;
        }

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
    public static int findParent(int arr[], int a, int b){
        a = getParent(arr, a);
        b = getParent(arr, b);

        if(a==b) return 1;
        else return 0;
    }

}
