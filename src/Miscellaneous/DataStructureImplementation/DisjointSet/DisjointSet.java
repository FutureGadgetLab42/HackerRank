package Miscellaneous.DataStructureImplementation.DisjointSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Stream;

public class DisjointSet<T> {
    private ArrayList<HashSet<T>> sets;
    public DisjointSet() {
        sets = new ArrayList<>();
    }

    public Stream<HashSet<T>> setStream(){
        return sets.stream();
    }

    /** Adds data to a new disjoint subset, if it is not contained in any of the other sets. */
    public void add(T data) {
        if(data == null) {
            throw new IllegalArgumentException("Null argument passed to add method.");
        }

        if(sets.stream().noneMatch(s -> s.contains(data))) {
            HashSet<T> newSet = new HashSet<>();
            newSet.add(data);
            sets.add(newSet);
        }
    }

    /** Adds data to the specified subset, if it is not contained in any of the subsets. */
    public void add(T data, int setNumber) {
        if(data == null || setNumber < 0 || setNumber >= sets.size()) {
            throw new IllegalArgumentException("Illegal argument passed to add. data = "
                    + data + " setNumber = " + setNumber);
        }

        if(sets.stream().noneMatch(s -> s.contains(data))) {
            sets.get(setNumber).add(data);
        }
    }

    /** Performs union of the two subsets at specified indices, and returns the representative of the result. */
    public void union(int subset1, int subset2) {
        if(subset1 < 0 || subset1 >= sets.size() || subset2 < 0 || subset2 >= sets.size()) {
            throw new IllegalArgumentException("Illegal args passed to union. subset1 = "
                    + subset1 + " subset2 = " + subset2);
        }

        sets.get(subset1).addAll(sets.get(subset2));
        sets.remove(subset2);
    }

    /** Performs union of the two subsets containing specified elements, if they are contained
     * in the disjoint set. */
    public void union(T data1, T data2) {
        if(sets.stream().noneMatch(s -> s.contains(data1) || s.contains(data2))) {
            throw new IllegalArgumentException("Illegal arguments passed to union. data1 = "
                    + data1 + " data2 = " + data2);
        }

        union(find(data1), find(data2));
    }

    /** Returns the index of the subset containing data, or -1 if it is not found. */
    public int find(T data) {
        for(int i = 0; i < sets.size(); i++) {
            if(sets.get(i).contains(data)) {
                return i;
            }
        }
        return -1;
    }

    public int numSubsets() {
        return sets.size();
    }
}
