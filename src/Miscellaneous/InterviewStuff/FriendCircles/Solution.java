package Miscellaneous.InterviewStuff.FriendCircles;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Tom on 3/17/16.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Miscellaneous/InterviewStuff/FriendCircles/tests/input00"));
        int n = Integer.parseInt(sc.nextLine());
        String[] friends = new String[n];
        for(int i = 0; i < n; i++) {
            friends[i] = sc.nextLine();
        }
        System.out.print("" + friendCircles(friends));
    }
    static int friendCircles(String[] friends) {
        int result = 0;
        Set<Integer> discoveredSet = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int currentRow, currentNeighbor;
        for(int index = 0; index < friends.length; index++) {
            if(!discoveredSet.contains(index)){
                queue.add(index);
                discoveredSet.add(index);
                while(!queue.isEmpty()) {
                    currentNeighbor = queue.poll();
                    for(int i = 0; i < friends[currentNeighbor].length(); i++) {
                        if(!discoveredSet.contains(i) && i != currentNeighbor && friends[currentNeighbor].charAt(i) == 'Y') {
                            queue.add(i);
                            discoveredSet.add(i);
                        }
                    }
                }
                queue.clear();
                result++;
            }
        }
        return result;
    }
}
