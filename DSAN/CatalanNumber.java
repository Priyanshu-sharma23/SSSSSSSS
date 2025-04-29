// Program to find number of binary trees possible with given number of nodes

import java.util.Scanner;

class CatalanNumber {

    // Function to find factorial
    static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Function to find Catalan Number using factorial
    static long catalanNumber(int n) {
        long fact2n = factorial(2 * n);
        long factn1 = factorial(n + 1);
        long factn = factorial(n);

        return fact2n / (factn1 * factn);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();

        long numberOfBinaryTrees = catalanNumber(n);

        System.out.println("Number of Binary Trees possible with " + n + " nodes = " + numberOfBinaryTrees);
        
        sc.close();
    }
}
