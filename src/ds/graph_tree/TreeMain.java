package ds.graph_tree;

public class TreeMain {

    public static void main(String[] args) {

        SimpleTreeImplementation tree = new SimpleTreeImplementation();
        tree.addChildNode(new SimpleTreeImplementation("5"));
        tree.addChildNode(new SimpleTreeImplementation("6"));
        tree.addChildNode(new SimpleTreeImplementation("5"));
        tree.addChildNode(new SimpleTreeImplementation("2"));
        tree.contains("2");
    }
}
