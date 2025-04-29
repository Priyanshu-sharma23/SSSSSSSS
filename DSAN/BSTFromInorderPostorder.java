import java.util.HashMap;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BSTFromInorderPostorder {

    Node root;
    int postIndex;

    // Function to construct BST from inorder and postorder
    Node buildTree(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, HashMap<Integer, Integer> inorderMap) {
        if (inorderStart > inorderEnd)
            return null;

        // The current root is the last element in postorder
        int rootValue = postorder[postIndex--];
        Node root = new Node(rootValue);

        // Find root in inorder
        int inorderIndex = inorderMap.get(rootValue);

        // Recursively construct the right and left subtrees
        root.right = buildTree(inorder, postorder, inorderIndex + 1, inorderEnd, inorderMap);
        root.left = buildTree(inorder, postorder, inorderStart, inorderIndex - 1, inorderMap);

        return root;
    }

    // Function to print Preorder traversal of the tree
    void printPreorder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public static void main(String[] args) {
        BSTFromInorderPostorder tree = new BSTFromInorderPostorder();

        // Example Data
        int[] inorder = {4, 2, 5, 1, 3};
        int[] postorder = {4, 5, 2, 3, 1};

        // Create map for fast lookup of inorder indices
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Set the postIndex (index of last element in postorder)
        tree.postIndex = postorder.length - 1;

        // Build the tree
        tree.root = tree.buildTree(inorder, postorder, 0, inorder.length - 1, inorderMap);

        // Print Preorder traversal
        System.out.println("Preorder traversal of constructed BST:");
        tree.printPreorder(tree.root);
    }
}
