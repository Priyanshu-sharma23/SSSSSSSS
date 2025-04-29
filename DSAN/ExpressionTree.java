import java.util.Stack;
import java.lang.*;
// Node class
class Node {
    String value;
    Node left, right;

    Node(String item) {
        value = item;
        left = right = null;
    }
}

public class ExpressionTree {

    // Function to check if a character is operator
    boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    // Function to return precedence
    int precedence(String op) {
        switch (op) {
            case "+": case "-":
                return 1;
            case "*": case "/":
                return 2;
        }
        return -1;
    }

    // Function to convert infix to postfix
    String[] infixToPostfix(String[] infix) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (String token : infix) {
            if (!isOperator(token) && !token.equals("(") && !token.equals(")")) {
                result.append(token).append(" ");
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim().split("\\s+");
    }

    // Function to build Expression Tree from postfix
    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();

        for (String token : postfix) {
            Node t = new Node(token);

            if (isOperator(token)) {
                t.right = stack.pop();
                t.left = stack.pop();
            }
            stack.push(t);
        }

        return stack.peek();
    }

    // Inorder traversal (for testing)
    void inorder(Node node) {
        if (node != null) {
            if (isOperator(node.value)) System.out.print("(");
            inorder(node.left);
            System.out.print(node.value);
            inorder(node.right);
            if (isOperator(node.value)) System.out.print(")");
        }
    }

    public static void main(String[] args) {
        ExpressionTree et = new ExpressionTree();
        // Example: (a+b)*(c-d)
        String infixExpr = "( a + b ) * ( c - d )";
        String[] infix = infixExpr.split("\\s+");

        String[] postfix = et.infixToPostfix(infix);
        Node root = et.buildTree(postfix);

        System.out.println("Inorder Traversal (reconstructed infix expression):");
        et.inorder(root);
    }
}
