class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class MinMaxBST {

    Node root;

    // Function to find the minimum value node
    Node findMin(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Function to find the maximum value node
    Node findMax(Node node) {
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public static void main(String[] args) {
        MinMaxBST tree = new MinMaxBST();

        /* Example BST
                  50
                 /  \
                30   70
               / \   / \
              20 40 60  80
        */
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);

        // Find minimum and maximum key values
        Node minNode = tree.findMin(tree.root);
        Node maxNode = tree.findMax(tree.root);

        System.out.println("Minimum key in the BST: " + minNode.data);
        System.out.println("Maximum key in the BST: " + maxNode.data);
    }
}
