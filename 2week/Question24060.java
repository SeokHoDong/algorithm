package algorithm.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question24060 {
    static int[] temp;
    static int K, count = 0, result = -1;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] s = reader.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            K = Integer.parseInt(s[1]);

            int[] array = new int[N];
            String[] elements = reader.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(elements[i]);
            }

            temp = new int[N];  // 병합 정렬을 위한 임시 배열
            mergeSort(array, 0, N - 1);

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1, t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        while (j <= right) {
            temp[t++] = arr[j++];
        }

        for (i = left, t = 0; i <= right; i++, t++) {
            arr[i] = temp[t];
            count++;
            if (count == K) {
                result = arr[i];
                return;
            }
        }
    }
}
