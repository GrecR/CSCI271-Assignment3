import java.util.Scanner;

public class Q6
{
    /*****************************main************************************
    * Description: Reads the array from user input and prints the sum of even
    * integers computed by a recursive function.
    *
    * Parameters:
    *   args (input) - unused
    *
    * Pre: none
    * Post: prints the sum of even integers
    *
    * Returns: none
    *
    * Called by: JVM
    * Calls: sumEven
    ************************************************************************/
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // Reads user input

        System.out.print("How many integers? ");
        int n = input.nextInt(); // Number of integers to read

        int[] A = new int[n]; // Array of integers

        // Read integers into the array (input reading can use a loop)
        for (int i = 0; i < n; i++)
        {
            System.out.print("Enter integer " + (i + 1) + ": ");
            A[i] = input.nextInt(); // Store next integer
        }

        int sum = sumEven(A, 0); // Sum of even integers (recursive)
        System.out.println("Sum of even integers = " + sum);

        // -------------------- Test Cases (documented) --------------------
        // Test Case 1:
        // Condition: mix of even and odd numbers
        // How: [1,2,3,4,5,6] => evens are 2+4+6 = 12
        int[] t1 = {1, 2, 3, 4, 5, 6}; // Test array 1
        System.out.println("\n[Test Case 1] [1,2,3,4,5,6] => " + sumEven(t1, 0) + " (expected: 12)");

        // Test Case 2:
        // Condition: no even numbers
        // How: [1,3,5] => sum is 0
        int[] t2 = {1, 3, 5}; // Test array 2
        System.out.println("[Test Case 2] [1,3,5] => " + sumEven(t2, 0) + " (expected: 0)");

        // Test Case 3:
        // Condition: all even numbers (including negatives)
        // How: [-2, 0, 8] => sum is 6
        int[] t3 = {-2, 0, 8}; // Test array 3
        System.out.println("[Test Case 3] [-2,0,8] => " + sumEven(t3, 0) + " (expected: 6)");

        input.close();
    }

    /*****************************sumEven*********************************
    * Description: Recursively computes the sum of all even integers in array A.
    *
    * Parameters:
    *   A (input) - array of integers
    *   index (input) - current index being processed
    *
    * Pre: A is not null, index is between 0 and A.length
    * Post: returns sum of even elements from index to end
    *
    * Returns: int sum of even integers
    *
    * Called by: main
    * Calls: sumEven
    ************************************************************************/
    public static int sumEven(int[] A, int index)
    {
        // Base case: finished the array
        if (index == A.length)
        {
            return 0;
        }

        int add = 0; // Value to add (A[index] if even)

        // If current element is even, include it
        if (A[index] % 2 == 0)
        {
            add = A[index];
        }

        // Recursive step: move to next index
        return add + sumEven(A, index + 1);
    }

    /*************************************************************************
    * Runtime Analysis (Big-O)
    *
    * Let n be the number of elements in the array.
    * The function visits each element exactly once and makes one recursive
    * call per element.
    *
    * Recurrence:
    *   T(n) = T(n-1) + c
    *   T(0) = c
    *
    * Solution:
    *   T(n) = O(n)
    *************************************************************************/
}