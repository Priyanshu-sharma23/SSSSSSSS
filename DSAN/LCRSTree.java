import java.util.*;

class LCRSNode {
    int data;
    LCRSNode leftChild;
    LCRSNode rightSibling;

    public LCRSNode(int data) {
        this.data = data;
        this.leftChild = this.rightSibling = null;
    }
}

public class LCRSTree {
    // Store all nodes in list by level order to access kth easily
    static List<LCRSNode> nodeList = new ArrayList<>();

    // Utility to create sample LCRS tree from given array
    public static LCRSNode createSampleLCRSTree(int[] values) {
        // Let's manually create the tree structure
        // Tree: 12(56(3,7,9),35(11,19),25,75)

        LCRSNode root = new LCRSNode(values[0]);
        nodeList.add(root); // 0 - 12

        // Level 1
        LCRSNode n56 = new LCRSNode(56);
        nodeList.add(n56); // 1
        LCRSNode n25 = new LCRSNode(25);
        nodeList.add(n25); // 2
        LCRSNode n75 = new LCRSNode(75);
        nodeList.add(n75); // 3
        root.leftChild = n56;
        n56.rightSibling = n25;
        n25.rightSibling = n75;

        // Level 2
        LCRSNode n3 = new LCRSNode(3);
        nodeList.add(n3); // 4
        LCRSNode n7 = new LCRSNode(7);
        nodeList.add(n7); // 5
        LCRSNode n9 = new LCRSNode(9);
        nodeList.add(n9); // 6
        n56.leftChild = n3;
        n3.rightSibling = n7;
        n7.rightSibling = n9;

        LCRSNode n35 = new LCRSNode(35);
        nodeList.add(n35); // 7
        n56.rightSibling = n35;

        LCRSNode n11 = new LCRSNode(11);
        nodeList.add(n11); // 8
        LCRSNode n19 = new LCRSNode(19);
        nodeList.add(n19); // 9
        n35.leftChild = n11;
        n11.rightSibling = n19;

        return root;
    }

    public static void main(String[] args) {
        int[] values = {12, 56, 3, 7, 9, 35, 11, 19, 25, 75}; // Input data
        LCRSNode root = createSampleLCRSTree(values);

        int k = 1; // Index in nodeList (0-based)
        if (k >= 0 && k < nodeList.size()) {
            LCRSNode kth = nodeList.get(k);
            if (kth.leftChild != null) {
                System.out.println("Left child of node " + kth.data + " is: " + kth.leftChild.data);
            } else {
                System.out.println("Node " + kth.data + " has no left child.");
            }
        } else {
            System.out.println("Invalid k value.");
        }
    }
}
