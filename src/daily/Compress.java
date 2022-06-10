package daily;

import java.util.ArrayList;

public class Compress {

    // 스트링 빌더는 동기화를 지원하지 않기 떄문에 static으로 선언하면 여러 메서드에서 호출하게 되면 문제가 될 수 있을 것 같다.
    // 현재 문제는 간단하므로 사용해도 될 것 같다.
    // 테스트가 여러 번 돌면서 리턴 값들이 중복되어서 안된다. 지역 변수로 선언하자.
    public static String compressString(String str) {

        if (str.length() == 0) {
            return str;
        }

        // 스택으로 해볼까. 스택으로 담으면서 마지막 값이랑 같으면 그 다음이랑도 같은지
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> stack = new ArrayList<>();
        stack.add(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char next = str.charAt(i);
            char first = stack.get(stack.size() - 1);

            // 스택 첫 노드랑 입력받은 값이 같으면 스택에 추가하고 진행
            // 만약 add만하다가 토큰이 바닥나면 스택은 차 있는 상태에서 반복문이 끝나게 되버린다.
            // 루프가 끝나고 스택의 크기를 확인해서 아래의 작업을 반복해주면 되겠지만, 그러면 중복 코드가 발생한다.
            if (next == first) {
                stack.add(next);
                continue;
            }

            checkLeftNodesOfStack(stack, sb);

            // 스택을 비우고 next를 넣는다.
            stack.clear();
            stack.add(next);
        }

        checkLeftNodesOfStack(stack, sb);

        return sb.toString();
    }

    private static void checkLeftNodesOfStack(ArrayList<Character> stack, StringBuilder sb) {
        if (!stack.isEmpty()) {
            int size = stack.size();
            char el = stack.get(0);

            if (size >= 3) {
                sb.append(size).append(el);
            } else {
                for (int i = 0; i < size; i++) {
                    sb.append(el);
                }
            }
        } else {
            System.out.println("this stack is empty");
        }
    }

    public static void main(String[] args) {
//        String s = compressString("abc");
        String s2 = compressString("wwwggoppopppp");
        System.out.println(s2);
    }
}
