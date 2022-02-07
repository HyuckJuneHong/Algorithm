package sort;

/** Bubble Sort (버블 정렬)
 * -> 옆에 있는 값과 비교해 더 작은 값을 앞으로 보내는 버블 정렬
 * -> 뒤에서부터 정렬이 된다.
 * -> 구현하기에는 가장 쉽지만 효율성이 가장 떨어지는 알고리즘
 *빅오 표기법 시간 복잡도
 * -> 10 + 9 + 8 + ... + 1
 * -> N * (N + 1) / 2
 * -> O(N^2)
 * -> 선택정렬과 시간복잡도는 같지만, 버블정렬이 더 비효율적인 이유는
 *    자리를 바꾸기 위해 3개의 명령어를 매번 사용하기 때문에 더 비효율적이다.
 */
public class Bubble_sort {

    public static void main(String[] args) {

        int temp;
        int[] array = new int[]{1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        for(int i=0; i<10; i++){
            for(int j=0; j< 9-i; j++){

                //옆에 있는 값과 비교해 교환
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        //오름차순 출력
        for(int i=0; i<10; i++){
            System.out.println(array[i]);
        }
    }
}
