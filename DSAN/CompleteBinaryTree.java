class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class CompleteBinaryTree {

    Node root;

    // Function to count total number of nodes
    int countNodes(Node node) {
        if (node == null)
            return 0;
        return (1 + countNodes(node.left) + countNodes(node.right));
    }

    // Function to check if the tree is complete
    boolean isComplete(Node node, int index, int numberNodes) {
        if (node == null)
            return true;

        if (index >= numberNodes)
            return false;

        return (isComplete(node.left, 2 * index + 1, numberNodes) &&
                isComplete(node.right, 2 * index + 2, numberNodes));
    }

    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();

        /* Example tree:
                  1
                /   \
               2     3
              / \   /
             4   5 6
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);

        int nodeCount = tree.countNodes(tree.root);
        int index = 0;

        if (tree.isComplete(tree.root, index, nodeCount))
            System.out.println("The tree is a complete binary tree.");
        else
            System.out.println("The tree is NOT a complete binary tree.");
    }
}

