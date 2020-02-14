/*
 * ArraysUtilsDemo.java        1.0 01/02/2016
 *
 * Demo of Arrays Utils Library.
 */

package aul;

/**
 * Demo of European Date Utils Library.
 */
public class ArraysUtilsDemo {
    
    /**
     * Demo.
     * @param args Not used.
     */
    public static void main (String[] args) {

        double[] array = {5.0, 5.5, 6.0, 8.5, 10.0};

        System.out.println("ARRAYS UTILS LIBRARY DEMO");
        System.out.println("================================");
        System.out.println("ArraysUtils.create() : " + ArraysUtils.toString(ArraysUtils.create(15)));
        System.out.println("ArraysUtils.sort() : " + ArraysUtils.sorted(array));
        System.out.println("ArraysUtils.binarySearch() : " + ArraysUtils.binarySearch(array, 6.0));

    }

}
