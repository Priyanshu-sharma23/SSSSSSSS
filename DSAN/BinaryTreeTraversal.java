// Program to perform Double-order and Triple-order Traversal of a Binary Tree

class Node {
    int data;
    Node left, right;

    // Constructor
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTreeTraversal {

    Node root;

    BinaryTreeTraversal() {
        root = null;
    }

    // Double-order Traversal (Visit Node twice)
    void doubleOrderTraversal(Node node) {
        if (node == null)
            return;

        // Visit before left subtree
        System.out.print(node.data + " ");

        doubleOrderTraversal(node.left);

        // Visit again after left subtree
        System.out.print(node.data + " ");

        doubleOrderTraversal(node.right);
    }

    // Triple-order Traversal (Visit Node three times)
    void tripleOrderTraversal(Node node) {
        if (node == null)
            return;

        // Visit before left subtree
        System.out.print(node.data + " ");

        tripleOrderTraversal(node.left);

        // Visit between left and right subtree
        System.out.print(node.data + " ");

        tripleOrderTraversal(node.right);

        // Visit after right subtree
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();

        /* Tree Structure
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

        System.out.println("Double-order Traversal:");
        tree.doubleOrderTraversal(tree.root);

        System.out.println("\nTriple-order Traversal:");
        tree.tripleOrderTraversal(tree.root);
    }
}
