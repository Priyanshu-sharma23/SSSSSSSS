// Program to count leaf and non-leaf nodes in a Binary Tree recursively

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class CountLeafNonLeaf {

    Node root;
    int leafCount = 0;
    int nonLeafCount = 0;

    // Recursive function to count leaf and non-leaf nodes
    void countNodes(Node node) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            leafCount++;
        } else {
            nonLeafCount++;
        }

        countNodes(node.left);
        countNodes(node.right);
    }

    public static void main(String[] args) {
        CountLeafNonLeaf tree = new CountLeafNonLeaf();

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

        tree.countNodes(tree.root);

        System.out.println("Number of Leaf nodes: " + tree.leafCount);
        System.out.println("Number of Non-Leaf nodes: " + tree.nonLeafCount);
    }
}

