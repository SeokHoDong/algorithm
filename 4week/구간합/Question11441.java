package algorithm.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question11441 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(reader.readLine());
            String[] numbers = reader.readLine().split(" ");

            int[] prefixSum = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(numbers[i - 1]);
            }

            int m = Integer.parseInt(reader.readLine());

            for (int i = 0; i < m; i++) {
                String[] line = reader.readLine().split(" ");
                int left = Integer.parseInt(line[0]);
                int right = Integer.parseInt(line[1]);

                int sum = prefixSum[right] - prefixSum[left - 1];
                System.out.println(sum);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
