package sample;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class QuickSort
{
    public static long fin;
    public static double secs;
    public static int steps=0;
    /*public static  quicksort (byte[] array){

    }*/

    //описание функции qSort

    public static void qSort(byte[] A, int low, int high) {
        int i = low;
        int j = high;
        int x = A[(low + high) / 2];
        long start, end;
        start = System.nanoTime();
        do {
            while (A[i] < x) ++i;
            while (A[j] > x) --j;
            if (i <= j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = (byte) temp;
                i++;
                j--;
                steps++;
            }
        } while (i <= j);
        //рекурсивные вызовы функции qSort
        if (low < j) qSort(A, low, j);
        if (i < high) qSort(A, i, high);
        end = System.nanoTime();
        fin = end-start;
        secs=(double)fin;
    }
}