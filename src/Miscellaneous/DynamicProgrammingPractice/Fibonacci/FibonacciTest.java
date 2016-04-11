package Miscellaneous.DynamicProgrammingPractice.Fibonacci;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {
    String fileName = "/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Miscellaneous/DynamicProgrammingPractice/Fibonacci/input00";
    String outputFilename = "/Users/Tom/IdeaProjects/HackerRank and Miscellaneous/src/Miscellaneous/DynamicProgrammingPractice/Fibonacci/output00";
    Scanner sc;
    Fibonacci fibonacci;

    @Before
    public void setup() throws FileNotFoundException {
        fibonacci = new Fibonacci();
        sc = new Scanner(new File(fileName));
    }

    @Test
    public void testFibonnaci0() throws FileNotFoundException {
        String line[] = sc.nextLine().split(" ");
        int f0 = Integer.parseInt(line[0]), f1 = Integer.parseInt(line[1]), n = Integer.parseInt(line[2]);
        sc.close();
        sc = new Scanner(new File(outputFilename));
        line = sc.nextLine().split(" ");
        int[] actual = fibonacci.fib(f0, f1, n);

        for(int i = 0; i < n; i++) {
            assertEquals(Integer.parseInt(line[i]), actual[i]);
        }
        sc.close();
    }
}
