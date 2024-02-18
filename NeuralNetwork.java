import java.util.Scanner;

public class ABC {
    private int num_of_layers;
    private int[] nodes_in_each_layer;
    private double[][][] weight;

    public ABC(int num_of_layers, int[] nodes_in_each_layer) {
        this.num_of_layers = num_of_layers;
        this.nodes_in_each_layer = nodes_in_each_layer;
        this.weight = new double[num_of_layers - 1][][];
        
        for (int i = 0; i < num_of_layers - 1; i++) 
        {
            this.weight[i] = new double[nodes_in_each_layer[i]][nodes_in_each_layer[i + 1]];
        }
    }

    public void setWeights() 
    {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < num_of_layers - 1; i++) 
        {
            System.out.println("Enter weights for layer " + (i + 1) + " to layer " + (i + 2) + ":");
            for (int j = 0; j < nodes_in_each_layer[i]; j++) 
            {
                for (int k = 0; k < nodes_in_each_layer[i + 1]; k++) 
                {
                    System.out.println("Weight from node " + (j + 1) + " to node " + (k + 1) + ": ");
                    weight[i][j][k] = input.nextDouble();
                }
            }
        }
    }

    public double getWeight(int f_node, int t_node)
    {
    return weight[f_node - 1][t_node - 1][0];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of layers: ");
        int num_of_layers = input.nextInt();
        int[] nodes_in_each_layer = new int[num_of_layers];
        
        System.out.println("Enter the number of nodes in each layer: ");
        for (int i = 0; i < num_of_layers; i++) 
        {
            nodes_in_each_layer[i] = input.nextInt();
        }

        ABC nn = new ABC(num_of_layers, nodes_in_each_layer);
        nn.setWeights();

        System.out.print("Enter the f_node: ");
        int f_node = input.nextInt();
        System.out.print("Enter the t_node: ");
        int t_node = input.nextInt();
        System.out.println("Weight from node " + f_node + " to node " +t_node+ " is: " + nn.getWeight(f_node, t_node));
    }
}