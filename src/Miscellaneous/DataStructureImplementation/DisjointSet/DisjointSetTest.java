package Miscellaneous.DataStructureImplementation.DisjointSet;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class DisjointSetTest {
    static DisjointSet<Integer> intSet;

    @Before
    public void setup() {
        intSet = new DisjointSet<>();
        for(int i = 0; i < 10; i++) {
            intSet.add(i*10);
            for(int j = 10*i + 1; j < 10*(i+1); j++) {
                intSet.add(j, i);
            }
        }
    }

    @Test
    public void testDisjointSet() {
        assertEquals(10, intSet.numSubsets());
        intSet.setStream().forEach(s -> assertEquals(10, s.size()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptions() {
        intSet.add(null);
        intSet.add(1729, 1729);
        intSet.union(-1, 0);
        intSet.union(0, intSet.numSubsets());
    }

    @Test
    public void testFind() {
        for(int i = 0; i < intSet.numSubsets(); i++) {
            for(int j = 10*i; j < 10*(i+1); j++) {
                assertEquals(i, intSet.find(j));
            }
        }
    }

}
