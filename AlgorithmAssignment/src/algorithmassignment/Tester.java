/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmassignment;

import sortingAlgorithms.*;
import fileIOutil.CSVWritter;

/**
 *
 * @author Kelly
 * ?
 * kelem negasi
 */
public class Tester {

    public static int steps = 20;//number of steps between the input ranges
    public static int rep = 20; //the number of repetition a single sorter is run
    public static double[][] TimeVsInput = new double[2][steps];/*holds the array of runtimes registered for each input
     averaged over the number of repetitions */

    public static int start = 0; //holds the starting value of the input
    public static int stop = 1000000; // holds the end value of the input
    public static int[] inputArrays;

    public static void testInsetionSort(double presortedness) {
        int inputSize = 0;
        long startTime;
        long endTime;
        long time;
        for (int i = 1; i <= steps; i++) {
            time = 0;
            inputSize = i * (stop / steps);//holds the input size of each step
            for (int j = 0; j < rep; j++) {
                inputArrays = RandomGenerator.generateArray(presortedness, inputSize, start, inputSize);//creat a new array with size of current input
                startTime = System.nanoTime();
                InsertionSort.doInsertionSort(inputArrays);
                endTime = System.nanoTime();
                time += (endTime - startTime);
            }
            TimeVsInput[0][i - 1] = time / rep;//find average time and add to the array;
            TimeVsInput[1][i - 1] = inputSize;
            System.out.println("step "+i);
        }
        CSVWritter.writeCsvFile("insertion_p = " + presortedness, TimeVsInput);

    }

    public static void testSelectionSort(double presortedness) {
        int inputSize = 0;
        long startTime;
        long endTime;
        long time;
        for (int i = 1; i <= steps; i++) {
            time = 0;
            inputSize = i * (stop / steps);//holds the input size of each step
            for (int j = 0; j < rep; j++) {
                inputArrays = RandomGenerator.generateArray(presortedness, inputSize, start, inputSize);//creat a new array with size of current input
                startTime = System.nanoTime();
                SelectionSort.doSelectionSort(inputArrays);
                endTime = System.nanoTime();
                time += (endTime - startTime);
            }
            TimeVsInput[0][i - 1] = time / rep;//find average time and add to the array;
            TimeVsInput[1][i - 1] = inputSize;
            System.out.println("step "+i);
        }
        CSVWritter.writeCsvFile("selection_p= " + presortedness, TimeVsInput);

    }

    public static void testQuickSort(double presortedness) {
        int inputSize = 0;
        long startTime;
        long endTime;
        long time;
        for (int i = 1; i <= steps; i++) {
            time = 0;
            inputSize = i * (stop / steps);//holds the input size of each step
            for (int j = 0; j < rep; j++) {
                inputArrays = RandomGenerator.generateArray(presortedness, inputSize, start, inputSize);//creat a new array with size of current input
                startTime = System.nanoTime();
                QuickSort.doQuickSort(inputArrays);
                endTime = System.nanoTime();
                time += (endTime - startTime);
            }
            TimeVsInput[0][i - 1] = time / rep;//find average time and add to the array;
            TimeVsInput[1][i - 1] = inputSize;
            System.out.println("step "+i);
        }
        CSVWritter.writeCsvFile("Quick_p= " + presortedness, TimeVsInput);

    }

    public static void testMrgeSort(double presortedness) {
        int inputSize = 0;
        long startTime;
        long endTime;
        long time;
        for (int i = 1; i <= steps; i++) {
            time = 0;
            inputSize = i * (stop / steps);//holds the input size of each step
            for (int j = 0; j < rep; j++) {
                inputArrays = RandomGenerator.generateArray(presortedness, inputSize, start, inputSize);//creat a new array with size of current input
                startTime = System.nanoTime();
                MergeSort.doMergeSort(inputArrays);
                endTime = System.nanoTime();
                time += (endTime - startTime);
            }
            TimeVsInput[0][i - 1] = time/rep;//find average time and add to the array;
            TimeVsInput[1][i - 1] = inputSize;
            System.out.println("step "+i);
        }
        CSVWritter.writeCsvFile("merge_p= " + presortedness, TimeVsInput);
    }

    public static void testHeapSort(double presortedness) {
        int inputSize = 0;
        long startTime;
        long endTime;
        long time;
        for (int i = 1; i <= steps; i++) {
            time = 0;
            inputSize = i * (stop / steps);//holds the input size of each step
            for (int j = 0; j < rep; j++) {
                inputArrays = RandomGenerator.generateArray(presortedness, inputSize, start, inputSize);//creat a new array with size of current input
                startTime = System.nanoTime();
                HeapSort.doHeapSort(inputArrays);
                endTime = System.nanoTime();
                time += (endTime - startTime);
            }
            TimeVsInput[0][i - 1] = time / rep;//find average time and add to the array;
            TimeVsInput[1][i - 1] = inputSize;
            System.out.println("step "+i);
        }
        CSVWritter.writeCsvFile("Heap_p= " + presortedness, TimeVsInput);
    }

}
