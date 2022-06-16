package daily;

import java.util.ArrayList;

public class TreeDFS {

    public static ArrayList<String> dfs(tree node) {

        // preorder 로 돌면 될 것 같다.
        // 먼저 방문한 노드를 결과 리스트에 담음
        // 자식이 없으면 종료
        // 자식이 있으면 인자에 주어지는 노드를 다음 자식 노드로 바꾸고 탐색 진행

        ArrayList<String> result = new ArrayList<>();

        if (node == null) {
            return result;
        }

        String data = node.getValue();
        result.add(data);

        // 자식이 없으면 종료
        if (node.getChildrenNode() == null) {
            return result;
        }

        // 자식이 있으면
        ArrayList<tree> children = node.getChildrenNode();
        for (tree child : children) {
            ArrayList<String> values = dfs(child);
            result.addAll(values);
        }

        return result;
    }

    //아래 클래스의 내용은 수정하지 말아야 합니다.
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
        TreeDFS.tree root = new tree("1");
        tree child1 = root.addChildNode(new tree("2"));
        tree child2 = root.addChildNode(new tree("3"));
        tree leaf1 = child1.addChildNode(new tree("4"));
        child1.addChildNode(new tree("5"));

//        ArrayList<String> result = dfs(root);


        leaf1.addChildNode(new tree("6"));
        child2.addChildNode(new tree("7"));

        ArrayList<String> result = dfs(root);
        System.out.println(result.toString());
    }
}
