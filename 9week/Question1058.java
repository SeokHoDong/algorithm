package algorithm.week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question1058 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());
            final int INF = 1000;

            int[][] dist = new int[N][N];

            // 초기화
            for (int i = 0; i < N; i++) {
                String line = reader.readLine();
                for (int j = 0; j < N; j++) {
                    if (i == j) dist[i][j] = 0;
                    else dist[i][j] = (line.charAt(j) == 'Y') ? 1 : INF;
                }
            }

            // 플로이드-워셜
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }

            int maxCount = 0;
            for (int i = 0; i < N; i++) {
                int count = 0;
                for (int j = 0; j < N; j++) {
                    if (i != j && dist[i][j] <= 2) {
                        count++;
                    }
                }
                maxCount = Math.max(maxCount, count);
            }

            System.out.println(maxCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
