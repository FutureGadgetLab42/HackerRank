package DataStructures.Stacks.MaximumElement.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Tom on 3/4/16.
 */
public class Tester {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/DataStructures/Stacks/MaximumElement/tests/output06"));
        Scanner mySc = new Scanner(new File("/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/DataStructures/Stacks/MaximumElement/tests/myOutput06"));

        ArrayList<String> lines = new ArrayList<>(), myLines = new ArrayList<>();
        while(sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        while(mySc.hasNextLine()) {
            myLines.add(mySc.nextLine());
        }


        for(int i = 0; i < lines.size(); i++) {
            if(i >= myLines.size()) System.out.println("First output out of bounds: " + lines.get(i) + " at " + i);
            if(!lines.get(i).equals(myLines.get(i))){
                System.out.println("Error at line " + i + " expected " + lines.get(i) + " actual " + myLines.get(i));
            }
        }

    }
}
