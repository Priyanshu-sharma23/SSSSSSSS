// Program to perform Indirect Recursion on Binary Tree

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class IndirectRecursionTree {

    Node root;

    IndirectRecursionTree() {
        root = null;
    }

    // First function for indirect recursion
    void indirectA(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");  // Process node
        indirectB(node.left);               // Call B on left child
    }

    // Second function for indirect recursion
    void indirectB(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");  // Process node
        indirectA(node.right);              // Call A on right child
    }

    public static void main(String[] args) {
        IndirectRecursionTree tree = new IndirectRecursionTree();

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

        System.out.println("Indirect Recursive Traversal:");
        tree.indirectA(tree.root);
    }
}
