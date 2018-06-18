import java.util.Scanner;

class AssemblyLine
{
    static int NUM_LINE = 2;
    static int NUM_STATION = 4;

    static int min(int a, int b)
    {
        if (a < b)
            return a;

        return b;

    }

    static int carAssembly(int a[][], int t[][], int e[], int x[])
    {
        int T1[] = new int[NUM_STATION];
        int T2[] = new int[NUM_STATION];
        int i;
        T1[0] = e[0] + a[0][0];
        T2[0] = e[1] + a[1][0];
        for (i = 1; i < NUM_STATION; ++i)
        {
            T1[i] = min(T1[i - 1] + a[0][i], T2[i - 1] + t[1][i] + a[0][i]);
            T2[i] = min(T2[i - 1] + a[1][i], T1[i - 1] + t[0][i] + a[1][i]);
        }
        return min(T1[NUM_STATION - 1] + x[0], T2[NUM_STATION - 1] + x[1]);
    }

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int z = scn.nextInt();
        int q = scn.nextInt();
        int a[][] = new int[z][q];
        int t[][] = new int[z][q];
        for (int i = 0; i < z; i++)
        {
            for (int j = 0; j < q; j++)
            {
                a[i][j] = scn.nextInt();
            }
        }
        for (int i = 0; i < z; i++)
        {
            for (int j = 0; j < q; j++)
            {
                t[i][j] = scn.nextInt();
            }
        }
        System.out.println("Please input entry time");
        int e[] = new int[2];
        int x[] = new int[2];
        for (int i = 0; i < 2; i++)
        {
            e[i] = scn.nextInt();
        }
        System.out.println("Please input exit time");
        for (int i = 0; i < 2; i++)
        {
            x[i] = scn.nextInt();
        }
        System.out.println(carAssembly(a, t, e, x));
    }

}