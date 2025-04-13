package algorithm.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Question1012_bfs {

    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // 좌우
    static int[] dy = {-1, 1, 0, 0}; // 상하
    static int m, n;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int t = Integer.parseInt(reader.readLine());

            while (t-- > 0) {
                String[] line = reader.readLine().split(" ");
                m = Integer.parseInt(line[0]);
                n = Integer.parseInt(line[1]);
                int k = Integer.parseInt(line[2]);

                field = new int[n][m];
                visited = new boolean[n][m];

                for (int i = 0; i < k; i++) {
                    String[] pos = reader.readLine().split(" ");
                    int x = Integer.parseInt(pos[0]);
                    int y = Integer.parseInt(pos[1]);
                    field[y][x] = 1;
                }

                int count = 0;
                for (int y = 0; y < n; y++) {
                    for (int x = 0; x < m; x++) {
                        if (field[y][x] == 1 && !visited[y][x]) {
                            bfs(x, y);
                            count++;
                        }
                    }
                }

                System.out.println(count);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (field[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
