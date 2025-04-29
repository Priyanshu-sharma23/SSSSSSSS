import java.util.Stack;

class PostfixEvaluation {

    // Function to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Function to perform arithmetic operations
    private static int applyOperator(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+': return operand1 + operand2;
            case '-': return operand1 - operand2;
            case '*': return operand1 * operand2;
            case '/': return operand1 / operand2;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }

    // Function to evaluate a postfix expression
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        // Loop through each character of the postfix expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                // If it's a digit, push it to the stack
                stack.push(c - '0');  // Convert char to int
            } else if (isOperator(c)) {
                // If it's an operator, pop two operands, apply the operator, and push the result
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = applyOperator(c, operand1, operand2);
                stack.push(result);
            }
        }

        // The result should be the only element left in the stack
        return stack.pop();
    }

    public static void main(String[] args) {
        String postfixExpression = "234*+5-"; // Example: "2 3 4 * + 5 -"
        System.out.println("Postfix Expression: " + postfixExpression);
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result);
    }
}

