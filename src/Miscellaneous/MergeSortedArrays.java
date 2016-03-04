package Miscellaneous;

/**
 * Merge two sorted Arrays
 */
public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] a1 = {0, 2, 4, 6, 8}, a2 = {1, 3, 5, 7, 9};
        int[] arr = merge(a1, a2);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] merge(int[] a1, int[] a2) {
        return mergeRec(a1, 0, a2, 0, new int[a1.length + a2.length], 0);
    }

    private static int[] mergeRec(int[] a1, int i1, int[] a2, int i2, int[] result, int r) {
        if(i1 >= a1.length) {
            while(i2 < a2.length) {
                result[r++] = a2[i2++];
            }
            return result;
        } else if(i2 >= a2.length) {
            while(i1 < a1.length) {
                result[r++] = a1[i1++];
            }
            return result;
        }
        int numToAdd;
        if(a1[i1] < a2[i2]) {
            numToAdd = a1[i1++];
        } else {
            numToAdd = a2[i2++];
        }
        result[r++] = numToAdd;
        return mergeRec(a1,i1,a2,i2,result,r);
    }
}
