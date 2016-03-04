package DataStructures.Stacks.MaximumElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/maximum-element
 */
public class Solution {
    private static boolean LOCAL_TEST = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            try {
                sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/DataStructures/Stacks/MaximumElement/tests/input08"));
                System.setOut(new PrintStream(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/DataStructures/Stacks/MaximumElement/tests/myOutput08")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        String line[];
        int numQueries = Integer.parseInt(sc.nextLine()), query, input;
        PriorityQueue<Integer> maxElt = new PriorityQueue<>(Collections.reverseOrder());
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < numQueries; i++) {
            line = sc.nextLine().split(" ");
            query = Integer.parseInt(line[0]);
            switch(query){
                case 1:
                    input = Integer.parseInt(line[1]);
                    st.push(input);
                    if(maxElt.isEmpty() || input >= maxElt.peek()) maxElt.add(input);
                    break;
                case 2:
                    if(maxElt.contains(st.peek())) maxElt.remove(st.peek());
                    st.pop();
                    break;
                case 3:
                    System.out.println(maxElt.peek());
                    break;
            }
        }
    }
}
