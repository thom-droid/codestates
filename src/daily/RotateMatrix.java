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

        int K = 1;

        rotateMatrix(matrix, 1);
    }

    public static int[][] rotateMatrix(int[][] matrix, int K) {
        // TODO: K에 따라 M,N 바꿔주는 것, 예외 처리가 필요
        int M = matrix[0].length;
        int N = matrix.length;

        int[][] rotated;

        List<LinkedList<Integer>> stacks = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            LinkedList<Integer> stack = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                stack.push(matrix[j][i]);
            }
            stacks.add(stack);
        }

        rotated = new int[N][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                rotated[i][j] = stacks.get(i).pop();
            }
        }

        Arrays.stream(rotated).forEach(x -> System.out.println(Arrays.toString(x)));

        return matrix;
    }
}
