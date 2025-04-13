package algorithm.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Question1260_dfs_bfs {
    static boolean[] visited;
    static List<Integer>[] graph;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] input = reader.readLine().split(" ");
            int N = Integer.parseInt(input[0]); // number of nodes
            int M = Integer.parseInt(input[1]); // number of edges
            int V = Integer.parseInt(input[2]); // starting node

            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                String[] edge = reader.readLine().split(" ");
                int u = Integer.parseInt(edge[0]);
                int v = Integer.parseInt(edge[1]);
                graph[u].add(v);
                graph[v].add(u);
            }

            for (int i = 1; i <= N; i++) {
                Collections.sort(graph[i]);
            }

            // DFS
            visited = new boolean[N + 1];
            dfs(V);
            System.out.println();

            // BFS
            visited = new boolean[N + 1];
            bfs(V);
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
