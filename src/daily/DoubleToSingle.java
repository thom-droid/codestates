package daily;

public class DoubleToSingle {
    public static String convertDoubleSpaceToSingle(String str) {
        // TODO:
        // 반복문으로 문자열을 순회하면서 제거하는 방법

        // api로 바로 제거하는 방법 replace를 써볼까

//        str = str.replace("  ", " ");
        String[] arr = str.split("  ");

        return String.join(" ", arr);
    }

    public static void main(String[] args) {
        System.out.println(convertDoubleSpaceToSingle("make my  day"));
    }
}
