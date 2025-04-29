// Program to count full nodes in a Binary Tree recursively

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class CountFullNodes {

    Node root;
    int fullNodeCount = 0;

    // Recursive function to count full nodes
    void countFullNodes(Node node) {
        if (node == null)
            return;

        if (node.left != null && node.right != null) {
            fullNodeCount++;
        }

        countFullNodes(node.left);
        countFullNodes(node.right);
    }

    public static void main(String[] args) {
        CountFullNodes tree = new CountFullNodes();

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

        tree.countFullNodes(tree.root);

        System.out.println("Number of Full nodes: " + tree.fullNodeCount);
    }
}
