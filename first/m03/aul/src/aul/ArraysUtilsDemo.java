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

        //double[] array = {5.0, 5.5, 6.0, 8.5, 10.0};
        double[] array = {10.0, 2.6, 11.0, 50.0, 6.8, 5.7};
        //double[] array2 = {5.0, 5.5, 6.0, 8.5, 10.0};
        double[] array2 = {5.0, 5.2, 95.3,60.4};

        System.out.println("ARRAYS UTILS LIBRARY DEMO");
        System.out.println("================================");
        System.out.println("ArraysUtils.sort(): ");
        ArraysUtils.sort(array, 2, 4);
        //ArraysUtils.sort(array);

        /*System.out.println("ArraysUtils.append() : " + ArraysUtils.toString(ArraysUtils.append(array, 5.6)));
        System.out.println("ArraysUtils.create() : " + ArraysUtils.toString(ArraysUtils.create(8)));
        System.out.println("ArraysUtils.sorted() : " + ArraysUtils.sorted(array));
        System.out.println("ArraysUtils.binarySearch() : " + ArraysUtils.binarySearch(array, 10.0));
        System.out.println("ArraysUtils.union() : " + ArraysUtils.toString(ArraysUtils.union(array,array2)));
        System.out.println("ArraysUtils.insert() : " + ArraysUtils.toString(ArraysUtils.insert(array,2,3.3)));
        System.out.println("ArraysUtils.remove() : " + ArraysUtils.toString(ArraysUtils.remove(array, 3)));
        System.out.println("ArraysUtils.fill(): ");
        ArraysUtils.fill(array, 9.9);
        ArraysUtils.fill(array, 9, 10, 2.0);
        System.out.println("ArraysUtils.copyOf() : " + ArraysUtils.toString(ArraysUtils.copyOf(array, 10)));
        System.out.println("ArraysUtils.copyOfRange() : " + ArraysUtils.toString(ArraysUtils.copyOfRange(array, 2, 4)));
        System.out.println("ArraysUtils.equals() : " + ArraysUtils.equals(array, array2));
        System.out.println("ArraysUtils.prepend() : " + ArraysUtils.toString(ArraysUtils.prepend(array, 536.6)));
        System.out.println("ArraysUtils.sort(): ");
        ArraysUtils.sort(array, 3, 6);
        ArraysUtils.sort(array);*/


    }

}
