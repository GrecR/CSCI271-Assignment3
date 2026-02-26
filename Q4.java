import java.util.Scanner;

public class Q4
{
    /*****************************main************************************
    * Description: Reads N and digit D, prints the number of times D occurs in N.
    * Also runs documented test cases.
    *
    * Parameters:
    *   args (input) - unused
    *
    * Pre: none
    * Post: prints results
    *
    * Returns: none
    *
    * Called by: JVM
    * Calls: countDigitOccurrences
    ************************************************************************/
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // Reads user input

        System.out.print("Enter an integer N : ");
        long n = input.nextLong(); // Input number N

        System.out.print("Enter a single digit D (0-9): ");
        int d = input.nextInt(); // Digit to count

        int result = countDigitOccurrences(n, d); // Recursive count
        System.out.println("Answer = " + result);

        // -------------------- Test Cases (documented) --------------------
        // NOTE: We use shorter values that fit in long, as instructed.

        // Test Case 1: N contains the digit multiple times
        // Condition: digit appears more than once
        // How: N=31245871348 and D=8 -> 8 appears twice.
        System.out.println("\n[Test Case 1] N=31245871348, D=8 => " +
                countDigitOccurrences(31245871348L, 8) + " (expected: 2)");

        // Test Case 2: N contains the digit zero times
        // Condition: digit does not appear
        // How: N=31245871348 and D=9 -> 9 appears zero times.
        System.out.println("[Test Case 2] N=31245871348, D=9 => " +
                countDigitOccurrences(31245871348L, 9) + " (expected: 0)");

        // Test Case 3: N is 0
        // Condition: smallest value edge case
        // How: N=0 and D=0 -> by this function definition, count is 1 only if we treat 0 specially.
        // Our recursive definition uses base case N==0 => 0, so result will be 0.
        System.out.println("[Test Case 3] N=0, D=0 => " +
                countDigitOccurrences(0L, 0) + " (expected: 0 by this base case)");

        input.close();
    }

    /*****************************countDigitOccurrences********************
    * Description: Recursively counts how many times digit d occurs in n.
    *
    * Parameters:
    *   n (input) - the number to search (long)
    *   d (input) - digit to count (0-9)
    *
    * Pre: d is between 0 and 9
    * Post: returns the number of occurrences of d in n
    *
    * Returns: int count of digit occurrences
    *
    * Called by: main
    * Calls: countDigitOccurrences
    ************************************************************************/
    public static int countDigitOccurrences(long n, int d)
    {
        // Make n positive for digit checking (handles negative inputs)
        if (n < 0)
        {
            n = -n;
        }

        // Base case: once n becomes 0, stop
        if (n == 0)
        {
            return 0;
        }

        int lastDigit = (int)(n % 10); // Last digit of n
        int add = 0;                   // 1 if lastDigit matches d

        if (lastDigit == d)
        {
            add = 1;
        }

        // Recursive step: remove last digit and continue
        return add + countDigitOccurrences(n / 10, d);
    }

    /*************************************************************************
    * Runtime Analysis (Big-O)
    *
    * Let k be the number of digits in N.
    * Each recursive call removes one digit by dividing n by 10.
    *
    * Recurrence:
    *   T(k) = T(k-1) + c
    *   T(0) = c
    *
    * Solution:
    *   T(k) = O(k)
    *************************************************************************/
}