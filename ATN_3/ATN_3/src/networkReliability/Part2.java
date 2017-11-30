package networkReliability;

import graph.Graph;
import java.util.ArrayList;

public class Part2 extends DriverFunction
{
    static void p2()
    {
        p = 0.85;
        for (int k = 0; k < 26; k++)
        {
            ArrayList<Double> tmpList = new ArrayList<>();
            double sum = 0;
            for (int i = 0; i < 50; i++)
            {
                Ntwk_R = 0.0;
                ArrayList<Integer> randomKSituations = new ArrayList<>();
                int j = 0;
                while (j < k)
                {
                    int x = random.nextInt(1024);
                    if (randomKSituations.contains(x))
                        while (randomKSituations.contains(x))
                            x = random.nextInt(1024);
                    randomKSituations.add(x);
                    j++;
                }
                for (int l = 0; l < Math.pow(2,m); l++)
                {
                    networkLinksSituation = String.format("%10s", Integer.toBinaryString(l)).replace(" ", "0");
                    Graph graph = new Graph(N, m);
                    graph.Event(networkLinksSituation);
                    if (randomKSituations.contains(l))
                    {
                        if (!graph.isConnected())
                            Ntwk_R = Ntwk_R + Reliability();
                    }
                    else
                    {
                        if (graph.isConnected())
                            Ntwk_R = Ntwk_R + Reliability();
                    }
                }
                tmpList.add(Ntwk_R);
            }
            for (double d : tmpList)
            {
                sum += d;
            }
            System.out.println("At k = " + k + ", Reliability of the netowrk: " + sum/tmpList.size());
        }
    }
}
