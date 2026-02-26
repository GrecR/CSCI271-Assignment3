import java.util.Scanner;


/*************************************************************************
* Class: Q2
*
* Purpose
* Provides a recursive method to count occurrences of a character in a string.
*
* Interface
* - main(String[] args)
* - countCharRecursive(String s, char c)
*************************************************************************/
public class Q2
{
    /*****************************main************************************
    * Description: Reads S and C from user and prints the count of C in S.
    * Also includes documented test cases.
    *
    * Parameters:
    *   args (input) - command line arguments (unused)
    *
    * Pre: none
    * Post: prints results to the screen
    *
    * Returns: none
    *
    * Called by: JVM
    * Calls: countCharRecursive
    ************************************************************************/
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // Reads user input

        System.out.print("Enter a string S: ");
        String s = input.nextLine(); // Input string

        System.out.print("Enter a character C: ");
        String cInput = input.nextLine(); // Raw input for character
        char c = cInput.charAt(0);        // First character from input

        int count = countCharRecursive(s, c); // Count computed recursively

        System.out.println("Count of '" + c + "' in S = " + count);

        // -------------------- Test Cases (documented) --------------------
        // Test Case 1: Empty string
        // Condition: S is empty
        // How: countCharRecursive("", 'a') should return 0 (base case).
        System.out.println("\n[Test Case 1] S=\"\", C='a' => " + countCharRecursive("", 'a'));

        // Test Case 2: No matches
        // Condition: character does not appear in the string
        // How: countCharRecursive("hello", 'z') should return 0.
        System.out.println("[Test Case 2] S=\"hello\", C='z' => " + countCharRecursive("hello", 'z'));

        // Test Case 3: Multiple matches
        // Condition: character appears multiple times
        // How: countCharRecursive("banana", 'a') should return 3.
        System.out.println("[Test Case 3] S=\"banana\", C='a' => " + countCharRecursive("banana", 'a'));

        input.close();
    }

    /*****************************countCharRecursive***********************
    * Description: Recursively counts how many times c appears in s.
    *
    * Parameters:
    *   s (input) - string to search
    *   c (input) - character to count
    *
    * Pre: s is not null
    * Post: returns number of occurrences of c in s
    *
    * Returns: int count of c in s
    *
    * Called by: main
    * Calls: countCharRecursive
    ************************************************************************/
    public static int countCharRecursive(String s, char c)
    {
        // Base case: empty string
        if (s.length() == 0)
        {
            return 0;
        }

        // Check the first character
        int firstCount = 0; // 1 if first char matches, else 0
        if (s.charAt(0) == c)
        {
            firstCount = 1;
        }

        // Recursive call on the rest of the string
        return firstCount + countCharRecursive(s.substring(1), c);
    }

    /*************************************************************************
    * Runtime Analysis (Big-O)
    *
    * Let n be the length of the string.
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