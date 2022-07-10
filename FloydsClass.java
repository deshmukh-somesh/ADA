import java.util.Scanner;

public class FloydsClass {
    static  final int MAX  = 20;
    static int n;
    static int [][]a;

    public static void main(String[] args){
        a = new int[MAX][MAX]; // arrays instantiation.
        ReadMatrix();
        Floyds();
        PrintMatrix();
    }
    // let's read the matrix
    static void ReadMatrix(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        n = scan.nextInt();
        System.out.println("Enter the cost matrix: ");
        for(int i=1;i<=n;i++)
        {
            for (int j = 1; j <=n; j++)
            {
                a[i][j] = scan.nextInt();
            }
        }
    scan.close();
    }

    static void Floyds()
    {
        for(int k=1;k<=n;k++)
        {
            for(int i=1;i<=n;i++)
                for(int j=1;j<=n;j++)
                    if(a[i][j]>a[i][k]+a[k][j])
                        a[i][j]=a[i][k]+a[k][j];


        }
    }

    static void PrintMatrix()
    {
        System.out.println("The all pair shortest path matrix is :\n");
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
                System.out.print(a[i][j]+"\t");
            System.out.println( "\n");



        }
    }

}
