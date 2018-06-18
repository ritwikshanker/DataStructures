import java.util.Random;

public class CountingSort
{
    private static final int MAX_RANGE = 1000000;

    public static void sort(int[] arr)
    {
        int N = arr.length;
        if (N == 0)
            return;
        /** find max and min values **/
        int max = arr[0], min = arr[0];
        for (int i = 1; i < N; i++)
        {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        int range = max - min + 1;
        if (range > MAX_RANGE)
        {
            System.out.println("\nError : Range too large for sort");
            return;
        }

        int[] count = new int[range];
        for (int i = 0; i < N; i++)
            count[arr[i] - min]++;
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i])
                arr[j++] = i + min;
    }

    public static void main(String args[])
    {
        long startTime = System.currentTimeMillis();
        CountingSort ob = new CountingSort();
        int n = 100000;
        Random rn = new Random();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = rn.nextInt(9);
        }
        ob.sort(arr);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime / 1000.0);
    }
}