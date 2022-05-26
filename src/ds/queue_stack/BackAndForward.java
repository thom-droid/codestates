package ds.queue_stack;

import java.util.ArrayList;
import java.util.Stack;

public class BackAndForward {

    public static ArrayList<Stack<String>> browserStack(String[] actions, String start) {

        Stack<String> prev = new Stack<>();
        Stack<String> next = new Stack<>();
        Stack<String> current = new Stack<>();

        ArrayList<Stack<String>> result = new ArrayList<>();

        current.push(start);

        // 대문자 알파벳이 들어오면 새로운 페이지, -1이면 뒤로가기, 1이면 앞으로 가기
        for (String action : actions) {

            // 뒤로가기를 눌렀을 때,
            // 현재 스택은 next로 이동하고
            // prev 스택을 current로 가져오면 됨
            if (!prev.isEmpty() && action.equals("-1")) {
                String popped = current.pop();
                next.push(popped);
                System.out.println("pushed into next stack: " + popped);
                current.push(prev.pop());
                System.out.println("current : " + current.peek());
                continue;
            }

            //앞으로 가기 눌렀을 때
            // 현재 스택은 prev로 이동하고
            // next 에서 current로 가져오면 됨
            if (!next.isEmpty() && action.equals("1")) {
                String popped = current.pop();
                prev.push(popped);
                System.out.println("pushed into prev stack: " + popped);
                current.push(next.pop());
                System.out.println("current : " + current.peek());
                continue;
            }

            // 대문자 이외의 문자가 들어왔을 때
            if (!action.matches("[A-Z]")) {
                System.out.println("invalid action");
                break;
            }

            // 위를 통과하면 대문자만 받은 경우임. 즉 새 페이지로 접속한 경우
            // 새로운 페이지에 접속했을 때에는 current를 prev에 넣고 next는 모두 비운다.

            if (!next.isEmpty()) {
                next.clear();
            }
            prev.push(current.pop());
            System.out.println(prev.peek());
            current.push(action);



        }
        result.add(prev);
        result.add(current);
        result.add(next);

        return result;
    }

    public static void main(String[] args) {
        String[] actions = new String[]{"B", "C", "-1", "D", "A", "-1", "1", "-1", "-1"};
        String start = "A";
        System.out.println(browserStack(actions, start));
    }
}
