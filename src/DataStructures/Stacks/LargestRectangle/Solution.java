package DataStructures.Stacks.LargestRectangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/largest-rectangle
 */
public class Solution {
    private static final boolean LOCAL_TEST = false;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/DataStructures/Stacks/LargestRectangle/tests/input00"));
        }
        sc.nextLine();
        String line[] = sc.nextLine().split(" ");
        int[] buildingHeights = new int[line.length];
        for(int i = 0; i < line.length; i++) {
            buildingHeights[i] = Integer.parseInt(line[i]);
        }
        System.out.println("" + largestRectangle(buildingHeights));
    }

    private static int largestRectangle(int[] buildingHeights) {
        Stack<Integer> heightStack = new Stack<>();
        int globalMax = 0, localMax;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < buildingHeights.length; i++) {
            localMax = 0;
            for(int j = i; j < buildingHeights.length; j++) {
                queue.add(buildingHeights[j]);
                localMax = queue.size() * queue.peek();
                if(localMax > globalMax) globalMax = localMax;
            }
            queue.clear();
        }
        return globalMax;
    }
//
//    private static int largestRectangle(int[] buildingHeights) {
//        int globalMax = 0, localMax = 0, poppedElt;
//        Stack<Integer> stack = new Stack<>();
//        for(int i = 0; i < buildingHeights.length; i++) {
//            if(stack.empty() || stack.peek() < buildingHeights[i]) {
//                stack.push(i);
//            } else {
//                poppedElt = stack.pop();
//                localMax = stack.empty()? i : i - stack.peek() - 1;
//                if(localMax > globalMax) globalMax = localMax;
//            }
//        }
//
//        while(!stack.empty()) {
//            poppedElt = stack.pop();
//            if(stack.empty()) {
//                localMax = buildingHeights[poppedElt];
//            } else {
//                localMax = (buildingHeights.length - stack.peek() + 1) * buildingHeights[poppedElt];
//            }
//            if(localMax > globalMax) globalMax = localMax;
//        }
//
//        return globalMax;
//    }

}
