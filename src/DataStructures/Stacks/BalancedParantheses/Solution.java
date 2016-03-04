package DataStructures.Stacks.BalancedParantheses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/balanced-parentheses
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            try {
                sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/DataStructures/Stacks/BalancedParantheses/tests/input01"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        int numTestCases = Integer.parseInt(sc.nextLine());
        String line;
        for(int i = 0; i < numTestCases; i++) {
            line = sc.nextLine();
            System.out.println(isBalanced(line));
        }
    }

    private static String isBalanced(String line) {
        int numClosedParen = 0, numClosedBracket = 0, numClosedVec = 0;
        Stack<Character> characterStack = new Stack<>(), lastClosed = new Stack<>();
        for(int i = 0; i < line.length(); i++) {
            characterStack.push(line.charAt(i));
        }
        char currentChar;
        while(!characterStack.empty()) {
            currentChar = characterStack.pop();
            switch(currentChar){
                case ')':
                    lastClosed.push(')');
                    numClosedParen++;
                    break;
                case '(':
                    if(lastClosed.empty() || lastClosed.pop() != ')') return "NO";
                    numClosedParen--;
                    break;
                case ']':
                    lastClosed.push(']');
                    numClosedVec++;
                    break;
                case '[':
                    if(lastClosed.empty() || lastClosed.pop() != ']') return "NO";
                    numClosedVec--;
                    break;
                case '}':
                    lastClosed.push('}');
                    numClosedBracket++;
                    break;
                case '{':
                    if(lastClosed.empty() || lastClosed.pop() != '}') return "NO";
                    numClosedBracket--;
                    break;
                default:
                    break;
            }
        }
        return (numClosedParen == 0 && numClosedBracket == 0 && numClosedVec == 0) ?
                "YES" : "NO";
    }
}
