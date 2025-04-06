package algorithm.week3;

import java.io.*;
import java.util.*;

public class Question2620 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        String[] inputArr = reader.readLine().split(" ");
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        Arrays.sort(arr); // 이진 탐색을 위해 정렬

        int M = Integer.parseInt(reader.readLine());
        String[] targetArr = reader.readLine().split(" ");
        int[] targets = new int[M];

        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(targetArr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(arr, targets[i]) ? "1\n" : "0\n");
        }

        System.out.print(sb);
    }


    public static boolean binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] < key){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
