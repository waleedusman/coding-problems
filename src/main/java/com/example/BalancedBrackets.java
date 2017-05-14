package com.example;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

import static com.google.common.base.Preconditions.checkNotNull;

public class BalancedBrackets {

    public boolean balance(final String input) {
        checkNotNull(input);

        Stack<Character> bracketStack = new Stack<>();
        boolean isBalanced = true;

        for (final char c : input.toCharArray()) {
            if (!isBalanced) {
                break;
            }

            if (isOpenBracket(c)) {
                bracketStack.push(c);
            } else if (isCloseBracket(c)) {
                try {
                    isBalanced = match(bracketStack.pop().charValue(), c);
                } catch (EmptyStackException ex) {
                    return false;
                }
            } else {
                throw new IllegalArgumentException("Input must only contain brackets, i.e. ()[]{}");
            }
        }

        return isBalanced && bracketStack.isEmpty();
    }

    private boolean isOpenBracket(char c) {
        return (c == '(') || (c == '[') || (c == '{');
    }

    private boolean isCloseBracket(char c) {
        return (c == ')') || (c == ']') || (c == '}');
    }

    private boolean match(char openBracket, char closeBracket) {
        return (openBracket == '(' && closeBracket == ')')
                || (openBracket == '[' && closeBracket == ']')
                || (openBracket == '{' && closeBracket == '}');
    }

    public static void main(String[] args) {
        System.out.println("Enter the string of brackets that you would like to check for balance: ");
        String input = new Scanner(System.in).nextLine();

        System.out.println(new BalancedBrackets().balance(input) ? "balanced" : "not balanced");
    }
}
