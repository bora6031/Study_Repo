import java.io.*;
import java.util.*;

class BOJ_14940 {
    //쉬운 최단거리 
    static int dx[] = {0, 0, 1, -1}, dy[] = {-1, 1, 0, 0};
    static int n, m, distance = 0;
    static int[][][] map;
    static int[][] answer;
    static Point start;

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m][2];
        answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
                map[i][j][1] = 0;
                if (map[i][j][0] == 2) {
                    start = new Point(i, j);
                }
            }
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        map[start.x][start.y][1] = 1;
        answer[start.x][start.y] = distance++;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                Point cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }
                    if (map[nx][ny][1] == 1) {
                        continue;
                    }
                    if (map[nx][ny][0] != 0) {
                        map[nx][ny][1] = 1;
                        q.offer(new Point(nx, ny));
                        answer[nx][ny] = distance;
                    }
                }
            }
            distance++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j][1] == 0 && map[i][j][0] != 0) {
                    answer[i][j] = -1;
                }
            }
        }
    }
}
