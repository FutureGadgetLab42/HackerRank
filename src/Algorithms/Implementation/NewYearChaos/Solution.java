package Algorithms.Implementation.NewYearChaos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos
 */
public class Solution {
    private static final boolean LOCAL_TEST = true;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        if(LOCAL_TEST) {
            sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Algorithms/Implementation/NewYearChaos/input0"));
        }
        int numTestCases = Integer.parseInt(sc.nextLine()), numPeople, finalQueue[];
        String line[];
        Configuration configuration;
        for(int i = 0; i < numTestCases; i++) {
            numPeople = Integer.parseInt(sc.nextLine());
            configuration = new Configuration(numPeople);
            line = sc.nextLine().split(" ");
            finalQueue = new int[numPeople];
            for(int j = 0; j < numPeople; j++) {
                finalQueue[j] = Integer.parseInt(line[j]);
            }
            System.out.println("" + configuration.numSwaps(finalQueue));
        }
        sc.close();
    }

    private static int numSwaps(int[] finalQueue) {
        return -1;
    }

    private static class Configuration {
        Person[] people;

        private Configuration(int numPeople) {
            people = new Person[numPeople + 1];
            for(int i = 1; i < people.length; i++) {
                people[i] = new Person(i);
            }
        }

        private static class Person {
            private int numBribes, initialPosition;
            private Person(int initialPosition) {
                this.initialPosition = initialPosition;
                this.numBribes = 2;
            }
        }

        private boolean swap(int person1, int person2) {
            Person p1 = people[person1], p2 = people[person2], briber;
            if(p1.initialPosition < p2.initialPosition) {
                briber = p2;
            } else {
                briber = p1;
            }
            if(briber.numBribes <= 0) {
                return false;
            } else {
                return true;
            }
        }

        private int numSwaps(int[] configuration) {
            int result = 0;
            HashMap<Integer, Integer> numBribes = new HashMap<>();
            for(int i = 1; i <= configuration.length; i++) {
                numBribes.put(i, 2);
            }


            return result;
        }
    }

}
