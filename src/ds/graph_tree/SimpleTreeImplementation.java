package ds.graph_tree;

import java.util.ArrayList;

public class SimpleTreeImplementation {

    private String value;
    private ArrayList<SimpleTreeImplementation> children;

    public SimpleTreeImplementation() {
        this.value = null;
        this.children = null;
    }

    public SimpleTreeImplementation(String value) {
        this.value = value;
        this.children = null;
    }

    public void setValue(String data) {
        this.value = data;
    }

    public String getValue() {      //현재 노드의 데이터를 반환
        return this.value;
    }

    public void addChildNode(SimpleTreeImplementation node) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(node);

    }
    public void removeChildNode(SimpleTreeImplementation node) {
        if(children.contains(node)) children.remove(node);
    }

    public ArrayList<SimpleTreeImplementation> getChildrenNode() {
        return children;
    }

    public boolean contains(String data) {      //재귀를 사용하여 값을 검색합니다.
        if (this.value != null) {
            if (this.value.equals(data)) return true;
        }

        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                return children.get(i).contains(data);
            }
        }
        return false;
    }
}
