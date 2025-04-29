// Program to construct unique binary tree using Inorder and Preorder Traversal and find Postorder

import java.util.HashMap;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class ConstructTree {

    Node root;
    int preIndex = 0;
    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    // Function to build tree
    Node buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end)
            return null;

        int current = preorder[preIndex++];
        Node node = new Node(current);

        if (start == end)
            return node;

        int inIndex = inorderMap.get(current);

        node.left = buildTree(preorder, inorder, start, inIndex - 1);
        node.right = buildTree(preorder, inorder, inIndex + 1, end);

        return node;
    }

    // Function to print Postorder traversal
    void printPostorder(Node node) {
        if (node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        ConstructTree tree = new ConstructTree();

        // Example Data
        int[] preorder = {1, 2, 4, 5, 3};
        int[] inorder = {4, 2, 5, 1, 3};

        // Build a map for fast lookup
        for (int i = 0; i < inorder.length; i++) {
            tree.inorderMap.put(inorder[i], i);
        }

        tree.root = tree.buildTree(preorder, inorder, 0, inorder.length - 1);

        System.out.println("Postorder traversal of constructed tree:");
        tree.printPostorder(tree.root);
    }
}
