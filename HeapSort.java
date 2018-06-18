import java.util.Random;
import java.util.Scanner;

public class HeapSort
{
    public static void sort(long[] arr)
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i >= 0; i--)
        {
            long temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void heapify(long[] arr, int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i)
        {
            long swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        Random rn = new Random();
        int n = 100000;
        long arr[] = new long[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = rn.nextLong();
        }
        sort(arr);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime / 1000.0);
    }
}
