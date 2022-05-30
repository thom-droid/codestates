package ds.graph_tree;

import java.util.Arrays;

public class AdjacentMatrix {

    public static int[][] createMatrix(int[][] edges) {

        int max = 0;

        // 리턴할 배열 크기는 어떻게 구하지?
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] > max) {
                max = edges[i][0];
            }

            if (edges[i][1] > max) {
                max = edges[i][1];
            }
        }

        int[][] result = new int[edges.length][max + 1];
        // [[0,0,0,0] , [0,0,0,0], [0,0,0,0]]
        //

        for (int i = 0; i < edges.length; i++) { // length == 4;
            result[edges[i][0]][edges[i][1]] = 1; // result[2][4] = 1;

            if (edges[i][2] == 1) { // 양방향
                result[edges[i][1]][edges[i][0]] = 1; // result[4][2] = 1;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 2, 0},
                {2, 4, 1},
                {1, 3, 1},
                {2, 1, 0}};

        System.out.println(Arrays.deepToString(createMatrix(arr)));
    }
}
