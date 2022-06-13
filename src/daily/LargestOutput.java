package daily;

import java.util.Arrays;

public class LargestOutput {

    public static int solution(int[] arr) {
        // 음수 배열과 양수 배열을 나누고
        // 각 배열을 정렬한다.
        // 음수가 하나면 양수 배열에서만 곱하면 되고
        // 이외에는
        // 음수랑 양수의 크기를 비교해가며 곱한다.

        // counter example: 모두 음수거나 모두 양수일 때

        int sum = 1;

        // 3자리면 바로 리턴
        if (arr.length == 3) {
            for (int j : arr) {
                sum *= j;
            }
            return sum;
        }

        int[] plusList = Arrays.stream(arr).filter(value -> value > 0).sorted().toArray();
        
        // 어차피 -의 개수가 중요하지 값 자체는 안 중요하므로 절대값으로 정렬
        int[] minusList = Arrays.stream(arr).filter(value -> value < 0).map(Math::abs).sorted().toArray();

        // 음수가 하나거나 없다면 양수 쪽에서 다 곱해서 리턴하면 된다.
        if (minusList.length <= 1) {
            return getMaxMultiplication(plusList);
        }

        // 양수가 없는 경우 음수들의 값은 가장 작은 것부터 계산해야 한다.
        if (plusList.length <= 0) {
            return -(minusList[0] * minusList[1] * minusList[2]);
        }

        // 2개이상이라면 (양수 제일 큰값 하나 * 음수 값 2개) 과 (양수 세 개만 곱한 값)을 비교해서 리턴하면 된다.
        int num1 = minusList[minusList.length - 1] * minusList[minusList.length - 2] * plusList[plusList.length - 1];

        // 플러스 배열이 2개 뿐이라면 음수를 곱하는 순간 가장 작은 값이 되므로 무조건 3개 이상일 때만 값을 비교해야 한다.
        if (plusList.length >= 3) {
            int num2 = getMaxMultiplication(plusList);
            return Math.max(num1, num2);
        }

        // 그 외에는 음수끼리의 값을 곱해서 리턴
        return num1;

    }

    private static int getMaxMultiplication(int[] arr) {
        int sum = 1;
        for (int i = arr.length - 3; i < arr.length; i++) {
            sum *= arr[i];
        }

        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{2, 3, 1, -5, -7, 8}));
//        System.out.println(solution(new int[]{-1, 2, -5, 7}));
        System.out.println(solution(new int[]{-5, -4, -3, -2, -1}));
    }
}
