package DataStructures.Stacks.MaximumElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/maximum-element
 */
public class Solution {
    private static boolean LOCAL_TEST = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            try {
                sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/DataStructures/Stacks/MaximumElement/tests/input00"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        String line[];
        int numQueries = Integer.parseInt(sc.nextLine()), query, input;
        Stack<Integer> st = new Stack<>(), maxElt = new Stack<>();
        for(int i = 0; i < numQueries; i++) {
            line = sc.nextLine().split(" ");
            query = Integer.parseInt(line[0]);
            switch(query){
                case 1:
                    input = Integer.parseInt(line[1]);
                    st.push(input);
                    if(maxElt.empty() || input > maxElt.peek()) maxElt.push(input);
                    break;
                case 2:
                    if(st.peek() == maxElt.peek()) maxElt.pop();
                    st.pop();
                    break;
                case 3:
                    System.out.println(maxElt.peek());
                    break;
            }
        }
    }
}
