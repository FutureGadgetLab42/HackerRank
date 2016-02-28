package Algorithms.DynamicProgramming.Knapsack.tests;

import Algorithms.DynamicProgramming.Knapsack.Solution;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Created by Tom on 2/28/16.
 */
public class KnapsackTest {
    private Solution solution;
    private static final File[] INPUT_FILES = {new File("input00")}, OUTPUT_FILES = {new File("output00")};

    @Before
    public void setup(){
        solution = new Solution();
    }

    @Test
    public void testSolution(){

    }

}
