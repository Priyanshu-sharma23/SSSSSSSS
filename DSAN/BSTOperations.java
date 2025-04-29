class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BSTOperations {

    Node root;

    // Preorder traversal
    void preorder(Node node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Inorder traversal
    void inorder(Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Postorder traversal
    void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Function to find the node with minimum value (used in deletion)
    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Function to delete a node from the BST
    Node deleteNode(Node root, int key) {
        // Base case: If the tree is empty
        if (root == null)
            return root;

        // Otherwise, recur down the tree
        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
        else {
            // Node to be deleted found

            // Case 1: Node has only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Case 2: Node has two children
            // Get the inorder successor (smallest in the right subtree)
            Node temp = minValueNode(root.right);

            // Copy the inorder successor's content to this node
            root.data = temp.data;

            // Delete the inorder successor
            root.right = deleteNode(root.right, temp.data);
        }
        return root;
    }

    public static void main(String[] args) {
        BSTOperations tree = new BSTOperations();

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

        // Perform pre-order, in-order, and post-order traversals
        System.out.println("Preorder traversal:");
        tree.preorder(tree.root);

        System.out.println("\nInorder traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPostorder traversal:");
        tree.postorder(tree.root);

        // Perform delete operation
        int keyToDelete = 20;
        System.out.println("\n\nDeleting node with key " + keyToDelete);
        tree.root = tree.deleteNode(tree.root, keyToDelete);

        // Perform inorder traversal after deletion
        System.out.println("\nInorder traversal after deletion:");
        tree.inorder(tree.root);
    }
}
