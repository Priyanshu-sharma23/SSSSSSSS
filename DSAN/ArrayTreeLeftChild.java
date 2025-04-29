public class ArrayTreeLeftChild {

    public static void main(String[] args) {
        int[] tree = {0, 12, 56, 3, 7, 9, 35, 11, 19, 25, 75}; // Index 0 is unused

        int k = 3; // Find left child of kth element

        if (2 * k < tree.length) {
            System.out.println("Left child of element at index " + k + " (" + tree[k] + "): " + tree[2 * k]);
        } else {
            System.out.println("No left child for element at index " + k);
        }
    }
}
