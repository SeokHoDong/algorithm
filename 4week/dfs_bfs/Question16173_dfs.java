package algorithm.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question16173_dfs {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static boolean reached = false;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            n = Integer.parseInt(reader.readLine());

            map = new int[n][n];
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                String[] tokens = reader.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            dfs(0, 0);

            System.out.println(reached ? "HaruHaru" : "Hing");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y]) return;

        visited[x][y] = true;

        if (map[x][y] == -1) {
            reached = true;
            return;
        }

        int jump = map[x][y];
        dfs(x + jump, y); // down
        dfs(x, y + jump); // right
    }

}
