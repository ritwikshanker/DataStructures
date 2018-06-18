import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SelectionSort
{
    static void selsort(long arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
        {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            long temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String args[]) throws IOException
    {
        long startTime = System.currentTimeMillis();
        Random rn = new Random();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long arr[] = new long[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = rn.nextLong();
        }
        selsort(arr);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime / 1000.0);
    }
}
