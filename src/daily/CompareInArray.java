package daily;

public class CompareInArray {
    public static boolean superIncreasing(int[] arr) {

        // 재귀로 풀 수 있을 것 같은데
        // 누적합을 저장한 배열을 만들고
        // 그 배열과 각 번지를 비교하면 될 것 같다.
        int[] sums = new int[arr.length - 1]; // arr: [1,2,3,4],

        // 누적합 배열
        for (int i = 0; i < arr.length - 1; i++) {// sums : [1, 3, 6]
            sums[i] = recursion(arr, i);
        }

        // compare elements to each other
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] <= sums[i - 1]) {
                return false;
            }
        }

        return true;
    }

    private static int recursion(int[] arr, int index) {

        if (index == 0) {
            return arr[0];
        }

        return arr[index] + recursion(arr, index - 1);
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 6, 13, 54};
        int[] input2 = new int[]{1, 3, 5, 9};
        System.out.println(superIncreasing(input2));
    }

    // 그냥 합만 더해주면 풀 수 있다.
    public boolean reference(int[] arr) {
        if (arr.length == 0) return false;
        int sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= sum) {
                return false;
            }
            sum = sum + arr[i];
        }
        return true;
    }
}
