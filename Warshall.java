import java.util.Scanner;

public class Warshall
{

    private int V;
    private boolean[][]tc;
    public void getTC(int[][]graph)
    {
        this.V = graph.length;
        tc = new boolean[V][V];
        for(int i=0;i<V;i++)
        {
            for (int j=0;j<V;j++)
                if(graph[i][j]!=0)
                    tc[i][j]=true;
        }
        // lets compute R^(k)
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                if(tc[j][i])
                    for (int k=0;k<V;k++)
                        if(tc[j][i] && tc[i][k])
                            tc[j][k] = true;
            }
        }
    }




    public void displayTC()
    {
        System.out.println("\n Transitive closure:\n");
        System.out.println();
        for(int v =0 ;v<V;v++)
        {
            System.out.print(v + " ");
            for(int w=0;w<V;w++)
            {
                if(tc[v][w])
                    System.out.print("1");
                else
                    System.out.print("0");
            }
            System.out.println();
        }
    }







    public static void main(String[] args)
    {
        Scanner scan  = new Scanner(System.in);
        System.out.println("Warshall Algorithm test \n");
        // make an object of warshall class
        Warshall w = new Warshall();
        // accept no. of vertices
        System.out.println("Enter no of vertices \n");
        int V = scan.nextInt();
        // get graph
        System.out.println("\n Enter matrix\n");
        int [][]graph = new int[V][V];
        for(int i =0;i<V;i++)
            for(int j=0;j<V;j++)
                graph[i][j] = scan.nextInt();

        w.getTC(graph);
        w.displayTC();
    }
}
