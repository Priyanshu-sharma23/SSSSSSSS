// Program to find height of a Binary Tree recursively

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class TreeHeight {

    Node root;

    // Recursive function to find height of tree
    int findHeight(Node node) {
        if (node == null)
            return -1;  // Return -1 if we consider height of empty tree as -1

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        // Return max of left height and right height plus 1 for the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeHeight tree = new TreeHeight();

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

        int height = tree.findHeight(tree.root);
        System.out.println("Height of the tree: " + height);
    }
}
