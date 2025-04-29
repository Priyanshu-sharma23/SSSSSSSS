import java.util.Scanner;

public class SizeBalancedTreeMinNodes {

    // Function to find minimum number of nodes
    static int minNodes(int height) {
        if (height == 0)
            return 0;
        if (height == 1)
            return 1;
        return 1 + minNodes(height - 1) + minNodes(height - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter height of Size-Balanced Tree: ");
        int height = sc.nextInt();

        System.out.println("Minimum number of nodes in size-balanced tree of height " + height + ": " + minNodes(height));

        sc.close();
    }
}

