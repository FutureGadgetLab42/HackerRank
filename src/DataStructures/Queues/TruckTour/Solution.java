package DataStructures.Queues.TruckTour;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/truck-tour
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numPetrolPumps = Integer.parseInt(sc.nextLine()), pumpAmounts[] = new int[numPetrolPumps],
                pumpDistances[] = new int[numPetrolPumps];

        String line[];
        for(int i = 0; i < numPetrolPumps; i++) {
            line = sc.nextLine().split(" ");
            pumpAmounts[i] = Integer.parseInt(line[0]);
            pumpDistances[i] = Integer.parseInt(line[1]);
        }
        System.out.println("" + findStartPump(pumpAmounts, pumpDistances));
    }

    public static int findStartPump(int[] pumpAmounts, int[] pumpDistances) {
        return -1;
    }
}
