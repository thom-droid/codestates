package daily;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class BalancedBrackets_Revision {

    public static boolean balancedBrackets(String str){

        // stack 에 넣었다 빼면서 순서를 유지
        LinkedList<Character> stack = new LinkedList<>();

        String rightBrackets = ")}]";

        // hashmap으로 get, contains 시간복잡도 최소화,
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (brackets.containsKey(c)) {
                stack.push(c);
                // stack 에 값이 남아있고, 닫힘 괄호일 때 (이외의 문자열이 아닐 때)
            } else if (stack.size() > 0 && rightBrackets.contains(String.valueOf(c))) {

                // 스택에서 가져온 열림괄호와 그 열림괄호에 매핑되어 있는 밸류값(닫힘괄호)이 같은지 확인
                // 예를 들어 현재 반복에서 ) 이 나왔다면, 스택에서 마지막 괄호를 가져와서 그 괄호의 닫힘괄호가 )와 같은지 확인
                char top = stack.pop();
                char rightBracket = brackets.get(top);

                if (c != rightBracket) {
                    return false;
                }

                // 이외의 일반 문자열인 경우 무시
            } else if (!rightBrackets.contains(String.valueOf(c))){
                continue;

            } else {
                // 반복 중에 stack이 비어있는데 즉 열린괄호가 없는데, 다른 닫힘 괄호가 왔을 때
                return false;
            }
        }

        // 순회가 끝났는데 스택이 비어 있는 경우는 true, 아닌 경우 열림괄호들이 남아있다는 의미이므로 false
        return stack.size() == 0;

    }

    public static void main(String[] args) {
        System.out.println(balancedBrackets("()()()("));
        System.out.println(balancedBrackets("()(w)(asd)"));
        System.out.println(balancedBrackets("awd((w)(asd)"));

        System.out.println(balancedBrackets2("()(w)(asd)"));
    }

    public static boolean balancedBrackets2(String str) {
        //스택을 사용합니다.
        Stack<Character> stack = new Stack<>();
        //HashMap을 선언해준 이후, 쌍이 맞는 괄호를 키와 값으로 할당합니다.
        HashMap<Character, Character> opener = new HashMap<>();
        opener.put('{', '}');
        opener.put('[', ']');
        opener.put('(', ')');

        //괄호의 뒷부분을 따로 String으로 선언합니다.
        String closer = "}])";

        //입력받은 문자열을 모두 순회하면서
        for(int i = 0; i < str.length(); i++) {
            //현재 문자열이 괄호의 시작 부분일 경우(선언한 Map에 해당 문자열의 키가 존재하는 경우)
            if(opener.containsKey(str.charAt(i))) {
                //스택에 해당 문자열을 삽입합니다.
                stack.push(str.charAt(i));
                //현재 문자열이 괄호의 마지막 부분이고, 스택이 비어있지 않은 경우(선언한 String에 해당 문자열이 존재하는 경우)
                //스택이 비어있다면, 괄호가 열리기 전에 괄호의 뒷부분이 온 상황이므로, 해당 조건에 함께 추가
            } else if(closer.indexOf(str.charAt(i)) != -1 && stack.size() > 0) {
                //스택에서 꺼낸 값과, 해당 키와 매칭되는 값을 찾아 현재 문자열과 비교
                char top = stack.pop();
                char pair = opener.get(top);
                //비교한 값이 다르다면 false를 리턴합니다.
                if(pair != str.charAt(i)) {
                    return false;
                }
                //그 외의 경우(스택이 비어있고, 현재 문자열이 괄호의 뒷부분인 경우) false를 리턴합니다.
            } else {
                return false;
            }
        }
        //남아있는 스택이 없다면 true, 존재한다면 false를 리턴합니다.
        return stack.size() == 0;
    }
}
