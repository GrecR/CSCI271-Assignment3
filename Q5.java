import java.util.Scanner;

public class Q5
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // Reads user input

        System.out.print("Enter a string S: ");
        String s = input.nextLine(); // Input string

        String sPrime = reverseRecursive(s); // Reversed string S'
        System.out.println("S' = " + sPrime);

        // -------------------- Test Cases (documented) --------------------
        // Test Case 1: Empty string
        // Condition: S is empty
        // How: reverseRecursive("") returns "" (base case).
        System.out.println("\n[Test Case 1] S=\"\" => S'=\"" + reverseRecursive("") + "\"");

        // Test Case 2: Single character
        // Condition: S has length 1
        // How: reverseRecursive("X") returns "X".
        System.out.println("[Test Case 2] S=\"X\" => S'=\"" + reverseRecursive("X") + "\"");

        // Test Case 3: Normal word
        // Condition: S has multiple characters
        // How: reverseRecursive("computer") returns "retupmoc".
        System.out.println("[Test Case 3] S=\"computer\" => S'=\"" + reverseRecursive("computer") + "\"");

        input.close();
    }

    /*****************************reverseRecursive*************************
    * Description: Returns S' which is S but backwards (recursive).
    *
    * Parameters:
    *   s (input) - string to reverse
    *
    * Pre: s is not null
    * Post: returns reversed version of s
    *
    * Returns: String S' (reversed string)
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
    * Let n be the length of S.
    * One recursive call is made per character.
    *
    * Recurrence:
    *   T(n) = T(n-1) + c
    *   T(0) = c
    *
    * Solution:
    *   T(n) = O(n)
    *************************************************************************/
}