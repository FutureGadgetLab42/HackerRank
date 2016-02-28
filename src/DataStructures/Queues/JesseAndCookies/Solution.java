package DataStructures.Queues.JesseAndCookies;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/jesse-and-cookies
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line[] = sc.nextLine().split(" ");
        int numCookies = Integer.parseInt(line[0]), minSweetness = Integer.parseInt(line[1]), cookies[] = new int[numCookies];
        line = sc.nextLine().split(" ");

        for(int i = 0; i < numCookies; i++) {
            cookies[i] = Integer.parseInt(line[i]);
        }
        System.out.println("" + increaseSweetness(cookies, minSweetness));
    }

    public static int increaseSweetness(int[] cookies, int minSweetness) {
        return -1;
    }

}
