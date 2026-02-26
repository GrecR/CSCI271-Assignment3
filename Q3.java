import java.util.Scanner;

public class Q3
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // Reads user input

        System.out.print("Enter a string S: ");
        String s = input.nextLine(); // Input string

        String rev = reverseRecursive(s); // Reverse computed recursively
        System.out.println("Reverse of S = " + rev);

        // -------------------- Test Cases (documented) --------------------
        // Test Case 1: Empty string
        // Condition: S is empty
        // How: reverseRecursive("") should return "" (base case).
        System.out.println("\n[Test Case 1] S=\"\" => \"" + reverseRecursive("") + "\"");

        // Test Case 2: Single character
        // Condition: S has one character
        // How: reverseRecursive("A") should return "A".
        System.out.println("[Test Case 2] S=\"A\" => \"" + reverseRecursive("A") + "\"");

        // Test Case 3: Normal word
        // Condition: S has multiple characters
        // How: reverseRecursive("hello") should return "olleh".
        System.out.println("[Test Case 3] S=\"hello\" => \"" + reverseRecursive("hello") + "\"");

        input.close();
    }

    /*****************************reverseRecursive*************************
    * Description: Recursively reverses a string.
    *
    * Parameters:
    *   s (input) - string to reverse
    *
    * Pre: s is not null
    * Post: returns reversed version of s
    *
    * Returns: reversed string
    *
    * Called by: main
    * Calls: reverseRecursive
    ************************************************************************/
    public static String reverseRecursive(String s)
    {
        // Base case
        if (s.length() == 0)
        {
            return "";
        }

        // Recursive case
        return reverseRecursive(s.substring(1)) + s.charAt(0);
    }

    /*************************************************************************
    * Runtime Analysis (Big-O)
    *
    * Let n be the length of the string.
    * One recursive call per character.
    *
    * Recurrence:
    *   T(n) = T(n-1) + c
    * Solution:
    *   T(n) = O(n)
    *************************************************************************/
}