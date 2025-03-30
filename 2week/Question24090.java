package algorithm.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question24090 {

    static int K; // K번째 교환
    static int swapCount = 0; // 현재까지의 교환 횟수

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = reader.readLine().split(" ");
            int N = Integer.parseInt(firstLine[0]);
            K = Integer.parseInt(firstLine[1]);

            int[] array = new int[N];
            String[] elements = reader.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(elements[i]);
            }

            quickSort(array, 0, N - 1);

            if(swapCount < K){
                System.out.println("-1"); // K번째 교환이 없으면 -1 출력
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        if (i+1 != right) {
            swap(array, i + 1, right);
        }

        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        swapCount++;
        if (swapCount == K) {
            System.out.println(array[i] + " " + array[j]);
        }
    }
}
