package ds.queue_stack;

import java.util.ArrayList;

public class ListStack {

    private ArrayList<Integer> listStack = new ArrayList<>();

    public void push(Integer data) {
        listStack.add(data);
    }

    public Integer pop() {
        if (listStack.isEmpty()) {
            return null;
        }
        return listStack.remove(listStack.size() - 1);
    }

    public int size() {
        return listStack.size();
    }

    public Integer peek() {
        if (listStack.isEmpty()) {
            return null;
        }
        return listStack.get(listStack.size() - 1);
    }

    public String show() {
        return listStack.toString();
    }

    public void clear() {
        listStack.clear();
    }
}
