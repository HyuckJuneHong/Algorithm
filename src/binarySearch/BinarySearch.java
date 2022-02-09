package binarySearch;

/**Binary Search (이분 탐색, 이진 탐색)
 * - 저장 데이터를 탐색하는 방법은 크게 순차 탐색과 이분 탐색으로 나뉜다.
 *   -> 이 2가지는 컴퓨터 자료구조 및 알고리즘 영역에서 자주 사용.
 * - 이미 데이터가 정렬이 되어 있는 상황에서 범위를 반씩 좁혀가며 데이터를 빠르게 탐색하는 알고리즘
 * - 맨 처음 혹은 중간 위치에서 출발한다는 특징이 있다.
 * - 찾을 범위를 반씩 줄여, 실제 탐색 속도가 매우 빨라 AVL 트리, B트리, 분할 정복 등에서 사용
 *
 *시간복잡도
 * - O(Log₂N)의 시간복잡도를 가짐
 *
 *순차 탐색(Linear Search)
 * - 데이터의 정렬 유무에 상관 없이 앞에서부터 데이터를 하나씩 확인하여 탐색하는 알고리즘
 */
public class BinarySearch {

    static int arr[] = new int[]{
            1, 3, 5, 7, 9, 11, 14, 15, 18, 19, 25, 28
    };

    public static void main(String[] args){

        int result = binarySearch(1, 0, arr.length-1);

        if(result != -1)
            System.out.println(result+1 + "번째");
    }

    public static int binarySearch(int key, int low, int high){

        if(low > high) return -1;
        int mid = (low + high)/2;

        // 탐색 성공
        if(key == arr[mid]) return mid;
        else if(key < arr[mid]) return binarySearch(key ,low, mid-1);
        else return binarySearch(key, mid+1, high);
    }
}
