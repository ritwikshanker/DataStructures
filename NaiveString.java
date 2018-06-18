import java.util.Scanner;

public class NaiveString
{
    public static void search(String txt, String pat)
    {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++)
        {
            int j;
            for (j = 0; j < M; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            if (j == M)
                System.out.println("Pattern found at index " + i);
        }
    }

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Please input text");
        String txt = scn.next();
        System.out.println("Please input Pattern");
        String pat = scn.next();
        search(txt, pat);
    }
}