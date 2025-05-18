package algorithm.week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question11657 {
    static class Edge {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }


    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = reader.readLine().split(" ");
            int N = Integer.parseInt(firstLine[0]); // 도시 수
            int M = Integer.parseInt(firstLine[1]); // 버스 수

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                String[] line = reader.readLine().split(" ");
                int from = Integer.parseInt(line[0]);
                int to = Integer.parseInt(line[1]);
                int cost = Integer.parseInt(line[2]);
                edges.add(new Edge(from, to, cost));
            }

            long[] dist = new long[N + 1];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[1] = 0;

            boolean updated = false;

            for (int i = 1; i <= N; i++) {
                updated = false;
                for (Edge edge : edges) {
                    if (dist[edge.from] != Long.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.cost) {
                        dist[edge.to] = dist[edge.from] + edge.cost;
                        updated = true;
                        if (i == N) {
                            System.out.println("-1");
                            return;
                        }
                    }
                }
                if (!updated) break;
            }

            for (int i = 2; i <= N; i++) {
                System.out.println(dist[i] == Long.MAX_VALUE ? -1 : dist[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
