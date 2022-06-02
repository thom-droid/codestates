package algo.greedy;

public class BoardGame {

    private static int[] coordinates = {0,0}; // (x,y) like coordinates
    private static int score = 0;
    private static int boardSize = 0;

    public static Integer boardGame(int[][] board, String operation) {
        // 방향대로 움직이는 메서드
        // 해당 위치의 값을 확인하고 점수를 처리하는 공통 메서드
        // 점수를 저장하는 변수

        // 보드를 벗어났을 때  null 리턴
        // 보드를 움직일 때마다 확인해야함.
        boardSize = board.length - 1;
        // 좌우로 움직일 때는 같은 배열 내 인덱스 변경
        // 상하로 움직일 때는 다른 배열로 이동

        for (int i = 0; i < operation.length(); i++) {

            // move to the right
            if (operation.charAt(i) == 'R') {
                coordinates[0]++;
            }
            if (operation.charAt(i) == 'L') {
                coordinates[0]--;
            }
            if (operation.charAt(i) == 'U') {
                coordinates[1]--;
            }
            if (operation.charAt(i) == 'D') {
                coordinates[1]++;
            }

            if (!isInBoard()) {
                return null;
            }

            score(board);

        }

        return score;
    }


    private static boolean isInBoard() {
        return coordinates[0] <= boardSize && (coordinates[1] <= boardSize)
                && coordinates[0] >=0 && coordinates[1] >=0;
    }

    private static void score(int[][] board) {
        int x = coordinates[0];
        int y = coordinates[1];
        score += board[y][x];
    }

    public static void main(String[] args) {
        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };

        String operation = "RRDLLD";


//        System.out.println(boardGame(board1, operation));


        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };

//        System.out.println(boardGame(board3, "DDRRRUDUDUD"));

        int[][] board2 = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        System.out.println(boardGame(board2, "UUUDD"));

    }

}
