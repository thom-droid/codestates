package daily;

import java.util.ArrayList;

public class Compress {

    public static String compressString(String str) {

        if (str.length() == 0) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<Character> stack = new ArrayList<>();

        // 스택으로 해볼까. 스택으로 담으면서 마지막 값이랑 같으면 그 다음이랑도 같은지

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

            int size = stack.size();

            if (size >= 3) {
                sb.append(size).append(first);
            } else {

                // 아니라면 있는 그대로 추가한다.
                for (int j = 0; j < size; j++) {
                    sb.append(first);
                }
            }

            // 스택을 비우고 next를 넣는다.
            stack.clear();
            stack.add(next);
        }

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
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = compressString("abc");
        String s2 = compressString("wwwggoppopppp");
        System.out.println(s2);
    }
}
