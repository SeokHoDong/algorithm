package algorithm.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Question2606 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int N = Integer.parseInt(reader.readLine()); // 컴퓨터 수
            int M = Integer.parseInt(reader.readLine()); // 연결 수

            graph = new ArrayList[N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                String[] input = reader.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                graph[a].add(b);
                graph[b].add(a); // 양방향 연결
            }

            dfs(1); // 1번 컴퓨터에서 시작
            System.out.println(count - 1); // 자기 자신 제외

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        count++;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

}
