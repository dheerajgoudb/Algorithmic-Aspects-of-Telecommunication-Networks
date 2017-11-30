package networkReliability;

import graph.Graph;

public class Part1 extends DriverFunction
{
    static void p1()
    {
        for (double i = 0.0; i < 1.01; i = i+0.04)
        {
            Ntwk_R = 0.0;
            p = Double.parseDouble(String.format("%.2f",i));
            for (int j = 0; j < Math.pow(2,m); j++)
            {
                networkLinksSituation = String.format("%10s", Integer.toBinaryString(j)).replace(" ", "0");
                Graph graph = new Graph(N,m);
                graph.Event(networkLinksSituation);
                if (graph.isConnected())
                {
                    Ntwk_R = Ntwk_R + Reliability();
                }
            }
            System.out.println("At p = " + p + ", Reliability of Network: " + Ntwk_R);
        }
    }
}
