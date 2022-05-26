package ds;

public class ListStackMain {

    public static void main(String[] args) {
        ListStack listStack = new ListStack();
        listStack.push(5);
        listStack.push(3);
        listStack.push(5);
        listStack.push(1);
        System.out.println(listStack.show());
        System.out.println(listStack.pop());
        System.out.println(listStack.show());
        System.out.println(listStack.pop());
        System.out.println(listStack.show());
        System.out.println(listStack.peek());
        System.out.println(listStack.show());
        System.out.println(listStack.size());
        listStack.clear();
        System.out.println(listStack.show());
    }
}
