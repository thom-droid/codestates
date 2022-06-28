package daily;

public class RotatedSearch {

    public static int rotatedArraySearch(int[] rotated, int target) {

        // 이진 탐색을 하다 0을 만나면 0을 리턴
        // 타겟보다 값이 크면 0의 왼편으로 넘어가서 검색
        // 값이 작으면 0의 오른편에서 검색
        return 0;
    }

    private static int findZeroInRightHalf(int[] rotated) {
        //find 0

        int size = rotated.length;
        int left = 0;
        int right = size - 1;
        while (right < size && left < size) {
            int pivot = (right + left) / 2;

            if (rotated[pivot] == 0) {
                return pivot;
            }

            right = pivot;
        }
        
        return -1;
    }

    public static void main(String[] args) {
//        int output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 100);

    }
}
