package sort;

/** Selection Sort (선택 정렬)
 * -> 가장 작은 값을 선택해 앞으로 보내는 선택 정렬
 * -> 앞에서부터 정렬이 된다.
 * -> 비효율적이지만 간단한 알고리즘
 *빅오 표기법 시간 복잡도
 * -> N * (N+1)/2
 * -> O(N^2)
 */
public class Selection_sort {

    public static void main(String[] args) {

        int temp, min, index = 0;
        int[] array = new int[]{1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        for(int i=0; i<10; i++){
            min = 9999;

            //가장 작은 값을 선택
            for(int j=i; j<10; j++){
                if(array[j] < min){
                    min = array[j];
                    index = j;
                }
            }

            //현재 값과 작은 값을 교환
            temp = array[i];
            array[i] = min;
            array[index] = temp;
        }

        //오름 차순 정렬
        for(int i=0; i<10; i++){
            System.out.println(array[i]);
        }
    }
}
