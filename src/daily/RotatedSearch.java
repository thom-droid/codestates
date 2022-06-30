package daily;

public class RotatedSearch {

    public static int rotatedArraySearch(int[] rotated, int target) {

        // 값이 변하는 구간을 찾자
        // 이진 탐색을 하면서 0번지부터 n/2번지를 했을 때 오름차순이 아니라면
        // 오름차순이 될 때까지 n/2 - 1 를 해나감
        // 왼편의 가장 큰 값을 찾고 이걸 기준으로 target이랑 비교

        int left = 0;
        int right = rotated.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (rotated[middle] == target) {
                return middle;
            }
            // {4, 5, 6, 0, 1, 2, 3}, 2)
            if (rotated[left] < rotated[middle]) {

                if (rotated[left] < target && target < rotated[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }

            } else {

                if (rotated[right] > target && target > rotated[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }

        }


        return -1;
    }

    public static void main(String[] args) {
//        int output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 100);

    }
}
