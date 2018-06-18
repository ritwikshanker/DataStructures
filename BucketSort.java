
import java.util.Random;

public class BucketSort
{
    static int[] sort(int[] sequence, int maxValue)
    {
        // Bucket Sort
        int[] Bucket = new int[maxValue + 1];
        int[] sorted_sequence = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++)
            Bucket[sequence[i]]++;

        int outPos = 0;
        for (int i = 0; i < Bucket.length; i++)
            for (int j = 0; j < Bucket[i]; j++)
                sorted_sequence[outPos++] = i;

        return sorted_sequence;
    }

    static void printSequence(int[] sorted_sequence)
    {
        for (int i = 0; i < sorted_sequence.length; i++)
            System.out.print(sorted_sequence[i] + " ");
    }

    static int maxValue(int[] sequence)
    {
        int maxValue = 0;
        for (int i = 0; i < sequence.length; i++)
            if (sequence[i] > maxValue)
                maxValue = sequence[i];
        return maxValue;
    }

    public static void main(String args[])
    {
        long startTime = System.currentTimeMillis();
        Random random = new Random();
        int n = 100000;
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++)
        {
            sequence[i] = Math.abs(random.nextInt(100));
        }
        int maxValue = maxValue(sequence);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime / 1000.0);
    }
}