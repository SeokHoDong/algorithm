package algorithm.week5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question2720 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            int testCases = Integer.parseInt(reader.readLine());
            StringBuilder builder = new StringBuilder();

            int[] coins = {25, 10, 5, 1};

            while (testCases-- > 0) {
                int change = Integer.parseInt(reader.readLine());
                int[] counts = new int[4];

                for (int i = 0; i < coins.length; i++) {
                    counts[i] = change / coins[i];
                    change %= coins[i];
                }

                // 결과를 저장
                builder.append(counts[0]).append(" ")  // Quarters
                        .append(counts[1]).append(" ")  // Dimes
                        .append(counts[2]).append(" ")  // Nickels
                        .append(counts[3]).append("\n"); // Pennies
            }

            // 출력
            System.out.print(String.valueOf(builder));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
