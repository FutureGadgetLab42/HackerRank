package DataStructures.Stacks.SimpleTextEditor;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/simple-text-editor
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOperations = Integer.parseInt(sc.nextLine()), commands[] = new int[numOperations];
        String line[], parameters[] = new String[numOperations];

        for(int i = 0; i < numOperations; i++) {
            line = sc.nextLine().split(" ");
            commands[i] = Integer.parseInt(line[0]);

            if(line.length > 1) {
                parameters[i] = line[1];
            }
        }

        for(int i = 0; i < numOperations; i++) {
            System.out.println(process(commands, parameters));
        }
    }

    private static String process(int[] commands, String[] parameters) {
        return "";
    }
}
