package sort.baekjoon;

import java.io.*;
import java.util.Scanner;

public class Sort_2751_시간초과 {

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

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];


        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        quickSort(arr, 0, n-1);

        for(int i=0; i<n; i++){
            bw.write(arr[i] + "\n");
            bw.flush();
        }
        bw.close();

    }
}
