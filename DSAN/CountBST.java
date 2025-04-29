class CountBST {

    // Function to calculate number of BSTs using Catalan number
    int countBST(int n) {
        int[] catalan = new int[n + 1];

        // Base case
        catalan[0] = catalan[1] = 1;

        // Calculate Catalan numbers using DP
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        
        // The nth Catalan number is the number of unique BSTs
        return catalan[n];
    }

    public static void main(String[] args) {
        CountBST tree = new CountBST();
        
        int n = 5;  // Given number of distinct keys
        int result = tree.countBST(n);

        System.out.println("Number of unique BSTs that can be formed with " + n + " distinct keys: " + result);
    }
}
