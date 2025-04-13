package algorithm.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question3273 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(reader.readLine());

            int[] array = new int[n];
            String[] tokens = reader.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(tokens[i]);
            }

            int target = Integer.parseInt(reader.readLine());
            System.out.println(countPairsWithSum(array, target));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[] readInput(BufferedReader reader, int size) throws IOException {
        int[] array = new int[size];
        String[] tokens = reader.readLine().split(" ");

        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(tokens[i]);
        }

        return array;
    }

    public static int countPairsWithSum(int[] arr, int target) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                count++;
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

}
