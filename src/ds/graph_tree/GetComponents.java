package ds.graph_tree;

import java.util.LinkedList;

public class GetComponents {

    public static int connectedVertices(int[][] edges) {
        // let say we have matrix such as below:
        // [0,1,0,0,0,0] [1,0,1,0,0,0] [0,1,0,0,0,0] [0,0,0,0,1,1] [0,0,0,1,0,0] [0,0,0,1,0,0]

        // the length of the boolean array should be as long as the number of vertices
        int length = 0;

        for (int[] edge : edges) {
            for (int i : edge) {
                if (length < i) {
                    length = i;
                }
            }
        }

        boolean[] isVisited = new boolean[length + 1];

        int[][] matrix = new int[length + 1][length + 1];
        
        // variable to store the number of components
        int count = 0;

        // build a matrix from edges
        for (int[] edge : edges) {
            int row = edge[0];
            int col = edge[1];
            matrix[row][col]++;
            matrix[col][row]++;
        }

        for (int vertex = 0; vertex < isVisited.length; vertex++) {
            if (!isVisited[vertex]) {
                count++;

                // vertices already visited are checked
                // as a result of bfs method, isVisited looks like = [true, true, true, false, false, false]
                // which means 0, 1, 2 vertices are connected, all adding up to a component
//                isVisited = bfs(matrix, isVisited, vertex);
                isVisited = dfs(matrix, isVisited, vertex);
            }

        }
        return count;
    }

    private static boolean[] bfs(int[][] matrix, boolean[] isVisited, int from) {
        // create a queue and set the first as 0 since we are searching from the beginning
        LinkedList<Integer> queue = new LinkedList<>();
        int size = matrix.length;

        queue.add(from);

        while (queue.size() > 0) {

            int current = queue.poll();
            isVisited[current] = true;

            // this way, we can get the boolean array with all the visited vertex checked
            for (int to = 0; to < size; to++) {
                if (matrix[current][to] == 1 && !isVisited[to]) {
                    isVisited[to] = true;
                    queue.add(to); // in first loop, we have [1] in the queue. on the next, we will have [2]
                }
            }

        }

        return isVisited;
    }

    private static boolean[] dfs(int[][] matrix, boolean[] isVisited, int from) {

        // turn visited
        isVisited[from] = true;

        for (int to = 0; to < matrix[from].length; to++) {

            // any edge that is caught in the loop, call dfs recursively
            if (matrix[from][to] == 1 && !isVisited[to]) {
                dfs(matrix, isVisited, to);
            }
        }

        return isVisited;
    }

    public static void main(String[] args) {
        int result = connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {3, 4},
                {3, 5},
        });
        System.out.println(result);
    }
}
