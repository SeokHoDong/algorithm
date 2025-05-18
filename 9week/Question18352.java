package algorithm.week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Question18352 {
    static class Node implements Comparable<Node> {
        int city, dist;
        Node(int city, int dist) {
            this.city = city;
            this.dist = dist;
        }
        public int compareTo(Node other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] firstLine = reader.readLine().split(" ");
            int N = Integer.parseInt(firstLine[0]);
            int M = Integer.parseInt(firstLine[1]);
            int K = Integer.parseInt(firstLine[2]);
            int X = Integer.parseInt(firstLine[3]);

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                String[] edge = reader.readLine().split(" ");
                int from = Integer.parseInt(edge[0]);
                int to = Integer.parseInt(edge[1]);
                graph.get(from).add(to);
            }

            int[] dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[X] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(X, 0));

            while (!pq.isEmpty()) {
                Node current = pq.poll();
                if (current.dist > dist[current.city]) continue;

                for (int neighbor : graph.get(current.city)) {
                    if (dist[neighbor] > current.dist + 1) {
                        dist[neighbor] = current.dist + 1;
                        pq.offer(new Node(neighbor, dist[neighbor]));
                    }
                }
            }

            boolean found = false;
            for (int i = 1; i <= N; i++) {
                if (dist[i] == K) {
                    System.out.println(i);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("-1");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
