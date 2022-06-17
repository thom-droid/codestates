package daily;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeBFS {

    public static ArrayList<String> bfs(tree node) {

        ArrayList<String> result = new ArrayList<>();
        LinkedList<tree> queue = new LinkedList<>();


        queue.add(node);

        while (!queue.isEmpty()) {

            tree current = queue.poll();

            result.add(current.getValue());

            if (current.getChildrenNode() != null) {
                queue.addAll(current.getChildrenNode());
            }

        }

        return result;
    }
    public static class tree {
        private String value;
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        public tree addChildNode(tree node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }

    public static void main(String[] args) {

        TreeBFS.tree root = new TreeBFS.tree("1");
        TreeBFS.tree child1 = root.addChildNode(new TreeBFS.tree("2"));
        TreeBFS.tree child2 = root.addChildNode(new TreeBFS.tree("3"));
        TreeBFS.tree leaf1 = child1.addChildNode(new TreeBFS.tree("4"));
        child1.addChildNode(new TreeBFS.tree("5"));
        ArrayList<String> output = bfs(root);
        System.out.println(output);
    }
}
