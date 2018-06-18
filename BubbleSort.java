import java.util.Random;
import java.util.Scanner;

class BubbleSort
{
    public static void main(String args[])
    {
        long startTime = System.currentTimeMillis();
        BubbleSort ob = new BubbleSort();
        Random rn = new Random();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long arr[] = new long[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = rn.nextLong();
        }
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1])
                {
                    long temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime / 1000.0);
    }
}