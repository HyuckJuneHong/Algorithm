package sort;

import java.io.*;
import java.util.PriorityQueue;

public class Heap_sort {

    static int arr[];
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<n; i++){
            heap.add(arr[i]);
        }

        for(int i=0; i<n; i++){
            arr[i] = heap.poll();
            bw.write(arr[i] + "\n");

        }
        bw.flush();
        bw.close();
    }

}
