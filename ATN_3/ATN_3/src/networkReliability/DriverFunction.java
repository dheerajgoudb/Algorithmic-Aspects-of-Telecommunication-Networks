package networkReliability;

import java.util.Random;

public class DriverFunction
{
    static int N;
    static int m;
    static double p;
    static Random random;
    static String networkLinksSituation;
    static double Ntwk_R = 0.0;

    public static void main(String[] args)
    {
        N = 5;
        m = (N*(N-1))/2;
        random = new Random();

        Part1.p1();
        Part2.p2();
    }

    static double Reliability()
    {
        double R_total = 1.0;
        for (int i = 0; i < networkLinksSituation.length(); i++)
        {
            int linkStatus = Character.getNumericValue(networkLinksSituation.charAt(i));
            if (linkStatus == 1)
                R_total = R_total*p;
            else
                R_total = R_total*(1-p);
        }
        return R_total;
    }
}

