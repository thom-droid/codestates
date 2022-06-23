package daily;

public class BalancedBrackets {
    private static final char[] leftBrackets = {'(', '{', '['};
    public static boolean balancedBrackets(String str) {

        int[] counts = new int[6];

        if (str.length() == 0) {
            return true;
        }

        // ( ) 괄호의 쌍이 맞아야 true
        // 열림 닫힘이 순서대로 나와야 함
        // 괄호가 여러 번 나오는 경우는 없나? 예시를 보면 없는 것 같다. -> 열린만큼 닫혀야 된다는 걸 보면, 여러 번 나올 수도 있는 것 같다.
        // 1. 정규식 활용? 정규식에는 순서를 정할 수 없잖아.
        // 2. 이중 반복문으로 열림 괄호가 나오면 닫힘 괄호가 뒤에 나오는지 확인하면 된다.
        // 3. 괄호의 종류가 여러 가지이고, 열고 닫힘의 균형이 맞아야 한다. (()){} 는 참이지만 ({)}는 거짓을 리턴해야 한다. 괄호가 열렸을 떄 먼저 닫히는 것을 확인해야 할까?
        // 어떤 괄호가 차례대로 열렸을 때, 차례대로 닫히는지 봐야 한다. 큐로 다른 문자열 제거
        // 괄호가 열린다 -> 괄호가 닫힐 때 현재 괄호와 다른 종류의 괄호가 열리는지 확인 (({)}  ... (({{}})) 다른 괄호가 열린다면 바로 false.
        // 아니라면

        // 그냥 메서드로 만들어버리자.

        return isBalanced(str, leftBrackets[0]) && isBalanced(str, leftBrackets[1]) && isBalanced(str, leftBrackets[2]);


    }

    private static boolean isBalanced(String str, char leftBracket) {
        int rightBracket;

        if (leftBracket == 40) {
            rightBracket = 41;
        } else {
            rightBracket = leftBracket + 2;
        }

        boolean[] checked = new boolean[str.length()];
        int leftCount = 0;
        int rightCount = 0;

        for (int i = 0; i < str.length(); i++) {
            // i == ( 일 때  카운트 증가
            if (str.charAt(i) == leftBracket) {
                leftCount++;

                // ( 이후에 )가 있는지 확인 (( ) 와 같은 경우를 방지하기 위해 boolean 배열 사용
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == rightBracket && !checked[j]) {

                        // 닫히는 괄호 앞에 다른 열린 괄호가 있다? 바로 리턴
                        for (char bracket : leftBrackets) {
                            if (bracket != str.charAt(j - 1)) {
                                return false;
                            }
                        }

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
