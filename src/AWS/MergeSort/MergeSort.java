package AWS.MergeSort;

import java.util.Random;

/**
 * Created by mgao on 2017/3/20.
 */
public class MergeSort {

    public void mergeSort(int[] array){
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    /**
     * Divide and conquer
     */
    private void mergeSort(int[] array, int[] helper, int low, int high){
        System.out.print("Sort Array from " + low + " to " + high + "    ");
        for(int j: array){
            System.out.print(j + " ");
        }
        System.out.println();
        if (low < high){
            int middle = (high +low) >> 1;
            mergeSort(array, helper, low, middle);
            mergeSort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }

    /**
     * Sort and merge
     */
    private void merge(int[] array, int[] helper, int low, int middle, int high){

        System.out.print("merge Array from " + low + " to " + high + "    ");
        for(int j = low; j <= high; j++){
            System.out.print(array[j] + " ");
        }
        System.out.println();

        for (int i = low; i <= high; i ++){
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while (helperLeft <= middle && helperRight <= high){
            if (helper[helperLeft] <= helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i ++){
            array[current + i] = helper[helperLeft + i];
        }
    }

//    static int[] merge(int[]array, int min, int max){
//
//    }
    
    public static void main(String[] args){
        Random random = new Random();
        int[] testArrary = new int[5];
        for (int i = 0; i < testArrary.length; i ++){
            testArrary[i] = random.nextInt(10);
        }

        for(int j: testArrary){
            System.out.print(j + " ");
        }
        System.out.println();

        MergeSort ms = new MergeSort();
        ms.mergeSort(testArrary);
        System.out.println();

        for(int j: testArrary){
            System.out.print(j + " ");
        }
    }
}
