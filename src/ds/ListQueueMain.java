package ds;

public class ListQueueMain {

    public static void main(String[] args) {
        ListQueue queue = new ListQueue();
        queue.add(5);
        queue.add(4);
        queue.add(2);
        queue.add(1);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue.show());
        queue.add(6);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        queue.clear();
        System.out.println(queue.size());
    }
}
