import java.util.Scanner;

class Knapsack
{

    static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }

    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }


    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Please input the number of values");
        int x = scn.nextInt();
        int val[] = new int[x];
        for (int i = 0; i < x; i++)
        {
            val[i] = scn.nextInt();
        }
        int wt[] = new int[x];
        System.out.println("Please input the weights");
        for (int i = 0; i < x; i++)
        {
            wt[i] = scn.nextInt();
        }
        System.out.println("Input the max weight");
        int W = scn.nextInt();
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}