// Program to count total number of nodes in a Binary Tree recursively

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class CountNodes {

    Node root;

    // Recursive function to count nodes
    int countNodes(Node node) {
        if (node == null)
            return 0;

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void main(String[] args) {
        CountNodes tree = new CountNodes();

        /* Example Tree
                  1
                 / \
                2   3
               / \
              4   5
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        int totalNodes = tree.countNodes(tree.root);
        System.out.println("Total number of nodes in the tree: " + totalNodes);
    }
}
