import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
class Node implements Comparator<Node>{
    private int value;
    private int weight;
    Node(int _v, int _w){value=_v;weight=_w;}
    Node(){}
    public int getValue(){return value;}
    public int getWeight(){return weight;}

    public int compare(Node node1, Node node2){
        if(node1.weight < node2.weight){return -1;}
        else if(node1.weight > node2.weight){return 1;}
        return 0;
    }
}
public class Dprac {
    static void dijkstra(int source, ArrayList<ArrayList<Node>> adj, int N){
        int distance[] = new int[N];
        for(int i=0;i<N;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());
        pq.add(new Node(source,0));
        while(pq.size() > 0){
            Node oldValue = pq.poll();
            for(Node newValue: adj.get(oldValue.getValue())){
                if(distance[oldValue.getValue()] + oldValue.getWeight() < distance[newValue.getValue()]){
                    distance[newValue.getValue()] = distance[oldValue.getValue()] + newValue.getWeight();
                    pq.add(new Node(newValue.getValue(),distance[newValue.getValue()]));
                }
            }
        }
        for(int i = 0;i<N;i++){
            System.out.println(distance[i] + " -> " + i);
        }
        
     }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Node>> adj = new ArrayList<ArrayList<Node>>();
        System.out.println("Enter the number of nodes: ");
        int n = scanner.nextInt();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Node>());
        }
        while(true){
            System.out.println("Enter from where you want the edge: ");
            int from = scanner.nextInt();
            System.out.println("Enter till where you want the edge: ");
            int to = scanner.nextInt();
            System.out.println("Enter the weight: " +from+ "-" +to+" :");
            int weight = scanner.nextInt();
            adj.get(from).add(new Node(to, weight));
            adj.get(to).add(new Node(from, weight));
            System.out.println("Do you want to add more?(Press 1:yes and 0:no)");
            if(scanner.nextInt()==0) break;
        }
        scanner.close();
        dijkstra(0,adj,n);
    }
}
