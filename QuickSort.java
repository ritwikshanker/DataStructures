import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class QuickSort
{
    static int partition(long[] arr, int low, int high)
    {
        long pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                long temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        long temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void sort(long[] arr, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public static void main(String args[]) throws IOException
    {
        Scanner scn = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        Random rn = new Random();
        int n = scn.nextInt();
        long arr[] = new long[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = rn.nextLong();
        }
        sort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime / 1000.0);
    }
}
