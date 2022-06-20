package daily;

public class BalancedBrackets {
    public static boolean balancedBrackets(String str) {
        if (str.length() == 0) {
            return true;
        }

        // ( ) 괄호의 쌍이 맞아야 true
        // 열림 닫힘이 순서대로 나와야 함
        // 괄호가 여러 번 나오는 경우는 없나? 예시를 보면 없는 것 같다. -> 열린만큼 닫혀야 된다는 걸 보면, 여러 번 나올 수도 있는 것 같다.
        // 1. 정규식 활용? 정규식에는 순서를 정할 수 없잖아.
        // 2. 이중 반복문으로 열림 괄호가 나오면 닫힘 괄호가 뒤에 나오는지 확인하면 된다.

        boolean[] checked = new boolean[str.length()];
        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < str.length(); i++) {
            // i == ( 일 때  카운트 증가
            if (str.charAt(i) == 40) {
                leftCount++;

                // ( 이후에 )가 있는지 확인 (( ) 와 같은 경우를 방지하기 위해 boolean 배열 사용
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == 41 && !checked[j]) {
                        checked[j] = true;
                        break;
                    }
                }
            }

        }

        // right parenthesis 개수 카운트
        for (boolean b : checked) {
            if (b) {
                rightCount++;
            }
        }
        
        // 둘 중 하나라도 0이면 false;
        if (leftCount == 0 || rightCount == 0) {
            return false;
        }
        
        return leftCount == rightCount;
    }

    public static void main(String[] args) {
        System.out.println(balancedBrackets("()()()("));
        System.out.println(balancedBrackets("()(w)(asd)"));
        System.out.println(balancedBrackets("awd((w)(asd)"));
    }
}
