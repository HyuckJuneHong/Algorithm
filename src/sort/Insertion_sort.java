package sort;

/** Insertion Sort 삽입 정렬)
 * - 각 숫자를 적절한 위치에 삽입하는 방법.
 *   즉, 버블정렬과 선택정렬처럼 무조건적이 아닌, 필요할 때만 위치를 바꿈.
 * - 선택 정렬과 버블 정렬의 시간복잡도와 동일하지만 훨씬 효율적이다.
 *빅오 표기법 시간 복잡도
 * -> 10 + 9 + 8 + ... + 1
 * -> N * (N + 1) / 2
 * -> O(N^2)
 * -> 삽입 정렬의 큰 특징 중 하나는 거의 정렬된 상태에서의 삽입 정렬 알고리즘은
 *    이미 정렬된 값들에서 별다른 연산이 일어나지 않고 지나갈 수 있다.
 *    때문에, 이미 거의 정렬된 상태에 한해서 어떤 알고리즘보다 빠르다.
 */
public class Insertion_sort {
    public static void main(String[] args){

        int temp;
        int[] array = new int[]{1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        for(int i=0; i<9; i++){
            int j=i;
            while(array[j] > array[j+1]){
                temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                j--;
            }
        }

        //오름 차순 정렬
        for(int i=0; i<10; i++){
            System.out.println(array[i]);
        }
    }
}
