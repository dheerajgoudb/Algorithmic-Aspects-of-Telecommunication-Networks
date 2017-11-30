package graph;

import java.util.ArrayList;
import java.util.Random;

public class Graph
{
    private int count;
    private int adj[][];
    private ArrayList<String> edge;
    private int m;
    private int n;
    private static Random random;
    private boolean visited[];

    static
    {
        random = new Random();
    }


    public Graph(int n, int m)
    {
        this.n = n;
        this.m = m;
        this.count = 0;
        edge = new ArrayList<>();
        adj = new int[n][n];
        adjMatrix();
        Edges();
        visited = new boolean[n];
    }

    // creates adjaceny matrix of the graph
    private void adjMatrix()
    {
        while (count != m)
        {
            int u = random.nextInt(n);
            int v = random.nextInt(n);
            if (u != v)
            {
                addEdge(u, v);
            }
        }
    }

    private void addEdge(int u, int v)
    {
        if (adj[u][v] != 1)
            count++;
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    // adds (u-v) edge, represented using "uv" and stored in a list
    private void Edges()
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = i+1; j < n; j++)
            {
                String str = Integer.toString(i)+Integer.toString(j);
                edge.add(str);
            }
        }
    }

    // This method takes '1010101010' network case and changes the adj matrix depending on failed links
    public void Event(String networkLinksSituation)
    {
        ArrayList<Integer> failedLinksID = new ArrayList<>();
        ArrayList<String> failedLinks = new ArrayList<>();
        for (int i = 0; i < networkLinksSituation.length(); i++)
        {
            int status = Character.getNumericValue(networkLinksSituation.charAt(i));
            if (status == 0)
            {
                failedLinksID.add(i);
            }
        }
        for (int linkID : failedLinksID)
        {
            failedLinks.add(edge.get(linkID));
        }

        for (String link : failedLinks)
        {
            int node1 = Character.getNumericValue(link.charAt(0));
            int node2 = Character.getNumericValue(link.charAt(1));
            adj[node1][node2] = 0;
            adj[node2][node1] = 0;
        }
    }

    // checks whether the graph, after updating the adjacency graph, is still connected or not
    public boolean isConnected()
    {
        for (int i = 0; i < visited.length; i++)
        {
            visited[i] = false;
        }
        DFS(0);
        for (boolean b : visited)
        {
            if (!b)
            {
                return false;
            }
        }
        return true;
    }

    private void DFS(int node)
    {
        visited[node] = true;
        for (int i = 0; i < n; i++)
        {
            if (node == i)
                continue;
            if (adj[node][i] == 1 && !visited[i])
            {
                DFS(i);
            }
        }
    }
}

