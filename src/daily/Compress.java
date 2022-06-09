package daily;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Compress {

    public static String compressString(String str) {
        if (str.length() == 0) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        ArrayList<String> stack = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(str, "");

        // 토큰으로 잘라서 반복하는데
        // 스택으로 해볼까. 스택으로 담으면서 마지막 값이랑 같으면 그 다음이랑도 같은지

        stack.add(st.nextToken());

        while (st.hasMoreTokens()) {
            // aabb
            String next = st.nextToken();
            String first = stack.get(stack.size() - 1);

            // 스택 첫 노드랑 입력받은 값이 같으면 스택에 추가하고 진행
            // 만약 add만하다가 토큰이 바닥나면 스택은 차 있는 상태에서 반복문이 끝나게 되버린다.
            // 루프가 끝나고 스택의 크기를 확인해서 아래의 작업을 반복해주면 되겠지만 그러면 중복 코드가 발생한다.
            if (first.equals(next)) {
                stack.add(next);
                continue;
            }

            // 다른 경우를 만나면 그 때 스택의 사이즈를 확인. 스택 사이즈는 같은 문자열이 몇개 있는지를 의미한다.
            int size = stack.size();
            String el = stack.get(0);

            // 스택 사이즈가 3보다 크면 사이즈랑 그 문자로 이루어진 문자열을 만들어서 스트링빌더에 추가해준다.
            if (size >= 3) {
                sb.append(size).append(el).append(next);
            } else {

                // 아니라면 있는 그대로 추가한다.
                for (int i = 0; i < size; i++) {
                    sb.append(el).append(next);
                }
            }

            // 스택을 비우고 next를 넣는다.
            stack.clear();
            stack.add(next);
        }

        if (!stack.isEmpty()) {
            int size = stack.size();
            String el = stack.get(0);

            // 스택 사이즈가 3보다 크면 사이즈랑 그 문자로 이루어진 문자열을 만들어서 스트링빌더에 추가해준다.
            if (size >= 3) {
                sb.append(size).append(el);
            } else {

                // 아니라면 있는 그대로 추가한다.
                for (int i = 0; i < size; i++) {
                    sb.append(el);
                }
            }
        }

        return sb.toString();
    }
}
