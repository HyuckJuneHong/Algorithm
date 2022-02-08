package sort;

import java.util.Scanner;

public class Sort_2751 {

    public static void quickSort(int arr[], int left, int right){

        if(left >= right){
            return;
        }

        int temp, pivot = left;
        int l = left, r = right;

        while (l <= r){

            while (l <= right && arr[pivot] >= arr[l]){
                l++;
            }
            while(r > left && arr[pivot] <= arr[r]){
                r--;
            }
            if(l > r){
                temp = arr[r];
                arr[r] = arr[pivot];
                arr[pivot] = temp;
            }else{
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        quickSort(arr, left, r-1);
        quickSort(arr, r+1, right);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int arr[] = new int[size];


        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, size-1);

        for(int i=0; i<size; i++){
            System.out.println(arr[i]);
        }

    }
}
