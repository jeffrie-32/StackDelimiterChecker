/*
Description: Checks whether delimiters are properly matched using a stack.
Programmed by: Jeffrie Ganding, BSIT, 48160, DATA STRUCTURE AND ALGORITHMS
Last Modified: October 19, 2026
Version: 1.0
Acknowledgements: OpenAI ChatGPT, used to help create and explain the program.
*/

import java.util.Scanner;
import java.util.Stack;

public class StackDelimiterChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        System.out.print("Enter a sequence: ");
        String input = scanner.nextLine();

        boolean valid = true;
        String reason = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                System.out.println("Read: " + ch);
                System.out.println("Operation: PUSH " + ch);
                System.out.println("Stack: " + stack);

            } else if (ch == ')' || ch == ']' || ch == '}') {
                System.out.println("Read: " + ch);

                if (stack.isEmpty()) {
                    valid = false;
                    reason = "Closing delimiter has no matching opening delimiter: " + ch;
                    System.out.println("Operation: INVALID");
                    break;
                }

                char top = stack.peek();
                System.out.println("Operation: PEEK " + top);

                boolean matches =
                    (ch == ')' && top == '(') ||
                    (ch == ']' && top == '[') ||
                    (ch == '}' && top == '{');

                if (matches) {
                    stack.pop();
                    System.out.println("Operation: POP " + top);
                    System.out.println("Stack: " + stack);
                } else {
                    valid = false;
                    reason = "Mismatched delimiters: " + top + " and " + ch;
                    System.out.println("Operation: INVALID");
                    break;
                }
            }
        }

        if (valid && !stack.isEmpty()) {
            valid = false;
            reason = "Unmatched opening delimiter remains: " + stack;
        }

        if (valid) {
            System.out.println("Result: Valid");
        } else {
            System.out.println("Result: Invalid");
            System.out.println("Reason: " + reason);
        }

        scanner.close();
    }
}