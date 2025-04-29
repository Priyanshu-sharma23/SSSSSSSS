import java.util.Stack;

class InfixToPostfix {
    // Function to get the precedence of operators
    private static int precedence(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '^') {
            return 3;
        }
        return -1; // For non-operators
    }

    // Function to check if a character is an operand (a letter or a digit)
    private static boolean isOperand(char c) {
        return Character.isLetterOrDigit(c);
    }

    // Function to convert the infix expression to postfix
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        // Loop through the infix expression
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (isOperand(c)) {
                // If it's an operand, append it to the result
                postfix.append(c);
            } else if (c == '(') {
                // If it's an opening parenthesis, push it to the stack
                stack.push(c);
            } else if (c == ')') {
                // If it's a closing parenthesis, pop from the stack until '(' is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Pop the '(' from the stack
            } else {
                // If it's an operator
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()); // Pop operators from stack if they have higher or equal precedence
                }
                stack.push(c); // Push the current operator to the stack
            }
        }

        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infix = "A+B*(C^D-E)^(F+G*H)-I";
        System.out.println("Infix Expression: " + infix);
        
        String postfix = infixToPostfix(infix);
        System.out.println("Postfix Expression: " + postfix);
    }
}

