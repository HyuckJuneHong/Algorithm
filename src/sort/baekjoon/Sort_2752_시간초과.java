package sort.baekjoon;

import java.util.Scanner;

public class Sort_2752_시간초과 {

    public static void main(String[] args){

        int temp;
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[3];

        for(int i=0; i<3; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<3; i++){
            for(int j=i; j<3; j++){
                if(arr[i]> arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }

        for(int i=0; i<3; i++){
            System.out.println(arr[i]);
        }
    }
}
