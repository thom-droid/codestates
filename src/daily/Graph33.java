package daily;

import java.util.LinkedList;

public class Graph33 {
    static int COL,ROW;

    static int time = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0,};

    public static void main(String[] args) {
        int[][] room = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0}
        };

        int[] src = new int[]{4, 2};
        int[] dst = new int[]{2, 2};

        System.out.println(robotPath(room, src, dst));
    }
    public static int robotPath(int[][] room, int[] src, int[] dst) {
        // 목표지점까지 도달하는 데에 걸리는 최소시간
        ROW = room.length;
        COL = room[0].length;

        boolean[][] visited = new boolean[room.length][room[0].length];
        LinkedList<Node> queue = new LinkedList<>();

        queue.push(new Node(src[0], src[1], 0));
        visited[src[0]][src[1]] = true;

        bfs(room, dst, visited, queue);
        return room[dst[0]][dst[1]];
    }

    private static void bfs(int[][] room, int[] dst, boolean[][] visited, LinkedList<Node> queue) {

        while (queue.size() != 0) {
            Node vertex = queue.poll();
            int row = vertex.x;
            int col = vertex.y;
            visited[row][col] = true;

//            time = Math.min(time, vertex.time);

            if (row == dst[0] && col == dst[1] || room[dst[0]][dst[1]] != 0) {
                return ;
            }

            for (int i = 0; i < 4; i++) {
                int x = row + dx[i];
                int y = col + dy[i];

                if (x >= ROW || y >= COL || x < 0 || y < 0) {
                    continue;
                }

                if (!visited[x][y] && room[x][y] != 1) {
                    visited[x][y] = true;
                    room[x][y] = room[row][col] + 1;
                    queue.add(new Node(x, y, vertex.time + 1));
                }

            }


        }

    }

    private static class Node {
        int x;
        int y;
        int time;
        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
