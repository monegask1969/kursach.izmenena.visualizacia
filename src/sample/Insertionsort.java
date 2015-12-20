package sample;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Insertionsort{
    public static long fin;
    public static double secs;
    public static int steps = 0;
    public static  void insertionsort(int array)
    {
        int N = array; //размерность массива
        byte A[];//название массива
        A = new byte[N];
        System.out.println("Begin work insertionsort");
        // считывание массива
        /*BufferedInputStream buf = null;
        try {
            buf = new BufferedInputStream(new FileInputStream("C:/Intel/1.avi"));
            buf.read(A, 0, A.length);
            buf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nДанный массив\n");
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0)     //чтобы не выводило отрицательные значения
                System.out.print(A[i] + " ");
        }
        */
        Random r = new Random(); //инициализация от таймера
        int yd, xs;
        long start, end;
        int low = 0;
        int high = N - 1;
        start = System.nanoTime();   // получить начальное время
        insort(A);
        end = System.nanoTime();    // получить конечное время
        System.out.print(fin);
       /* System.out.println("\nПосле сортировки вставками\n");
        for (int i = 0; i < N; i++) {
            if (A[i] > 0)     //чтобы не выводило отрицательные значения
                System.out.print(A[i] + " ");
        }
        System.out.println("\nTime of running: " + (fin) + "nanosec");*/
    }

    //описание функции insertionsort
     static void insort(byte[] A) {
         long start, end;
         start = System.nanoTime();
        for( int i = 1; i < A.length; i++){
            byte currElem = A[i];
            int prevKey = i - 1;
            while(prevKey >= 0 && A[prevKey] > currElem){
                A[prevKey+1] = A[prevKey];
                A[prevKey] = currElem;
                prevKey--;
                steps++;
            }
        }
         end = System.nanoTime();
         fin = end-start;
         secs=(double)fin;
    }
}