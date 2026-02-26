import java.util.Scanner;

/*************************************************************************
* Assignment 3 for CSCI 271-001 Spring 2026
*
* Author: Rayane Tellas
* OS: Windows
* Compiler: javac
* Date: February 25, 2026
*
* Purpose
* This program reads a string S from the user and prints the length of S.
* The length is computed using a recursive function (no loops).
*
* Method / Algorithm
* - Base case: if S is empty, length is 0
* - Recursive case: length(S) = 1 + length(S without first character)
*
* Data Structures
* - Uses String and recursion (no additional data structures).
*************************************************************************/

/*************************************************************************
* Class: Q1
*
* Purpose
* Provides a recursive method to compute the length of a string.
*
* Interface
* - main(String[] args)
* - lengthRecursive(String s)
*************************************************************************/
public class Q1
{
    /*****************************main************************************
    * Description: Reads a string from the user and prints its length.
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
    * Calls: lengthRecursive
    ************************************************************************/
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in); // Reads user input

        System.out.print("Enter a string S: ");
        String s = input.nextLine(); // The input string

        int len = lengthRecursive(s); // Length computed recursively

        System.out.println("Length of S = " + len);

        // -------------------- Test Cases (documented) --------------------
        // Test Case 1: Empty string
        // Condition: S has length 0
        // How: lengthRecursive(\"\") should return 0 (base case).
        System.out.println("\n[Test Case 1] S = \"\"  => length = " + lengthRecursive(""));

        // Test Case 2: Single character
        // Condition: S has exactly 1 character
        // How: lengthRecursive(\"A\") should return 1 after one recursive step.
        System.out.println("[Test Case 2] S = \"A\" => length = " + lengthRecursive("A"));

        // Test Case 3: Normal word
        // Condition: S has multiple characters
        // How: lengthRecursive(\"hello\") should return 5 by counting each char recursively.
        System.out.println("[Test Case 3] S = \"hello\" => length = " + lengthRecursive("hello"));

        input.close();
    }

    /*****************************lengthRecursive**************************
    * Description: Recursively computes the number of characters in s.
    *
    * Parameters:
    *   s (input) - string whose length is to be computed
    *
    * Pre: s is not null
    * Post: returns the length of s
    *
    * Returns: int length of s
    *
    * Called by: main
    * Calls: lengthRecursive
    ************************************************************************/
    public static int lengthRecursive(String s)
    {
        // Base case: empty string has length 0
        if (s.length() == 0)
        {
            return 0;
        }

        // Recursive case: 1 + length of substring without first character
        return 1 + lengthRecursive(s.substring(1));
    }

    /*************************************************************************
    * Runtime Analysis (Big-O)
    *
    * Let n be the length of the string.
    * The function does one recursive call per character until the string is empty.
    *
    * Recurrence:
    *   T(n) = T(n-1) + c
    *   T(0) = c
    *
    * Solution:
    *   T(n) = cn + c  => O(n)
    *************************************************************************/
}