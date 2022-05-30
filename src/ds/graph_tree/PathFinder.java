package ds.graph_tree;

import java.util.LinkedList;

public class PathFinder {
    // ㅇ 문제에서는 매개변수를 정해놓았다. 재귀로 풀게되면 방문을 확인하는 배열을 넘겨줄 수가 없다.
    public static boolean getDirections(int[][] matrix, int from, int to) {

        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(from);

        boolean[] isVisited = new boolean[matrix.length];

        isVisited[from] = true;

        while (queue.size() > 0) {

            int current = queue.poll();

            if (current == to) {
                return true;
            }

            for (int next = 0; next < matrix[current].length; next++) {
                if (matrix[current][next] == 1 && !isVisited[next]) {
                    isVisited[next] = true;
                    queue.add(next);
                }

            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}
        };
//        System.out.println(getDirections(arr, 0, 2));

        int[][] arr2 = new int[][]{
                {0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {1, 1, 1, 1, 0}
        };
        System.out.println(getDirections(arr2,1 ,4));

    }


}
