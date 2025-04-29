import java.util.Scanner;

public class AVLTreeMinMaxNodes {

    // Function to calculate minimum number of nodes
    static int minNodes(int height) {
        if (height == 0)
            return 0;
        if (height == 1)
            return 1;
        return 1 + minNodes(height - 1) + minNodes(height - 2);
    }

    // Function to calculate maximum number of nodes
    static int maxNodes(int height) {
        return (int) Math.pow(2, height + 1) - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter height of AVL Tree: ");
        int height = sc.nextInt();

        System.out.println("Minimum number of nodes in AVL tree of height " + height + ": " + minNodes(height));
        System.out.println("Maximum number of nodes in AVL tree of height " + height + ": " + maxNodes(height));

        sc.close();
    }
}
