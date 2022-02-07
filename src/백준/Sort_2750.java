package 백준;

import java.util.Scanner;

public class Sort_2750 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int temp;
        int size = sc.nextInt();
        int arr[] = new int[size];

        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<size; i++){
            for(int j=i; j<size; j++){
                if(arr[i]> arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }

        for(int i=0; i<size; i++){
            System.out.println(arr[i]);
        }
    }
}
