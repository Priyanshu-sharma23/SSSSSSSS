import java.util.Stack;

// Node class
class TreeNode {
    char data;
    TreeNode left, right;

    public TreeNode(char data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class NestedTree {

    // Function to construct tree from nested expression
    public static TreeNode constructTree(String expr) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null, temp = null;
        int k = 0; // 1 for left child, 2 for right child

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (ch == '(') {
                stack.push(temp);
                k = 1;
            } else if (ch == ',') {
                k = 2;
            } else if (ch == ')') {
                stack.pop();
            } else if (Character.isLetterOrDigit(ch)) {
                temp = new TreeNode(ch);
                if (root == null) {
                    root = temp;
                } else {
                    if (k == 1) {
                        stack.peek().left = temp;
                    } else if (k == 2) {
                        stack.peek().right = temp;
                    }
                }
            }
        }
        return root;
    }

    // Preorder traversal to print tree
    public static void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public static void main(String[] args) {
        String expr = "A(B(D,E),C(F))"; // Example nested tree expression
        TreeNode root = constructTree(expr);

        System.out.println("Preorder Traversal of constructed tree:");
        preorder(root);
    }
}
