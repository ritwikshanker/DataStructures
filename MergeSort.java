import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class MergeSort
{
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

    static void merge(long[] arr, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        long L[] = new long[n1];
        long R[] = new long[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void sort(long[] arr, int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
