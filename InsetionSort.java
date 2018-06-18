import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class InsetionSort
{
    static void inssort(long arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i)
        {
            long key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
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
        inssort(arr);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime / 1000.0);
    }
}
