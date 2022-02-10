package sort;

import java.util.*;

/** Quick Sort (퀵 정렬)
 * - 특정한 값을 기준으로 큰 숫자와 작은 숫자로 나누는 방법
 *   예시) 일반적으로 퀵 정렬엔 기준 값이 있는데, 이를 피벗(Pivot)이라 한다.
 *         1. 보통 첫 번째 원소를 피벗 값으로 설정한다.
 *         2. 피벗보다 왼쪽에서부터 큰 값과 오른쪽에서부터 작은 값을 찾는다.
 *         3. 큰 값과 작은 값을 교환한다.
 *         4. 반복하다가, 작은 값이 큰 값 인덱스보다 작은 경우. 즉, 엇갈린 경우 피벗과 작은 값을 교환한다.
 *         5. 피벗 기준으로 왼쪽은 피벗보다 작은 값으로 오른쪽은 큰값으로 분할이 됐다.
 *         6. 왼쪽에서 맨 앞 오른쪽에서 맨 앞 값을 피벗으로 삼고, 위처럼 각자 반복한다.
 *         7. 1~6을 반복한다.
 * - 버블, 선택, 삽입 정렬은 시간 복잡도가 N^2이기 때문에, N의 값이 클 경우
 *   일반적인 상황에선 사용하기 어려운 알고리즘이다. 때문에, 퀵정렬이 나왔다.
 * - 퀵 정렬은 대표적인 분할 정복 알고리즘으로 평균 속도가 O(N*logN)이다.
 *빅오 표기법 시간 복잡도
 * - 평균 시간 복잡도 : O(N*logN)
 * - 최악 시간 복잡도 : O(N^2)
 */

public class Quick_sort {

    public static void quickSort(int arr[], int left, int right){

        //원소가 한개 이거나 left가 더 클 경우
        if(left >= right){
            return;
        }

        int pivot = left;
        int l = left, r = right;

        while (l <= r){
            while (l<=right && arr[pivot] >= arr[l]){
                l++;
            }
            while(r>left && arr[pivot] <= arr[r]){
                r--;
            }

            if(l>r){            //엇갈릴 경우
                int temp = arr[r];
                arr[r] = arr[pivot];
                arr[pivot] = temp;
            }else{            //엇갈리지 않을 경우
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        quickSort(arr, left, r-1);
        quickSort(arr, r+1, right);
    }

    public static void main(String[] args){

       int arr[] = new int[]{1, 10, 5, 8, 7, 6, 4, 3, 2, 9};

        quickSort(arr, 0, arr.length-1);

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }
}
