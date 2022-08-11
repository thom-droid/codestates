package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] matrix2 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15}
        };

        int K = 1;

//        Arrays.stream(rotateMatrix(matrix, 4)).forEach(r -> System.out.println(Arrays.toString(r)));
        Arrays.stream(rotateMatrix(matrix2, 2)).forEach(r -> System.out.println(Arrays.toString(r)));
    }

    public static int[][] rotateMatrix(int[][] matrix, int K) {
        // TODO: K에 따라 M,N 바꿔주는 것, 예외 처리가 필요

        if (matrix == null) {
            return null;
        }

        if (K % 4 == 0) {
            return matrix;
        }

        if (K > 4) {
            K -= 4;
        }

        int M = matrix.length;
        int N = matrix[0].length;
        int[][] rotated;

        for (int k = 0; k < K; k++) {
            List<LinkedList<Integer>> stacks = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                LinkedList<Integer> stack = new LinkedList<>();
                for (int j = 0; j < M; j++) {
                    stack.push(matrix[j][i]);
                }
                stacks.add(stack);
            }

            int tmp = N;
            N = M;
            M = tmp;

            rotated = new int[M][N];

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    rotated[i][j] = stacks.get(i).pop();
                }
            }

            matrix = rotated;

//            Arrays.stream(rotated).forEach(x -> System.out.println(Arrays.toString(x)));


        }

        return matrix;
    }
}
