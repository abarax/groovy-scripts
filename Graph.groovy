
import java.util.ArrayList;
import java.util.List;

public class Vertex
{
    public String name;
    public HashSet<Edge> edges = new HashSet<Edge>();

    public Vertex(String name)
    {
        this.name = name;
    }

    public Vertex addEdge(Vertex child, int w)
    {
        edges.add(new Edge(this, child, w));

        return this;
    }
}
public class Edge
{
    public Integer weight;
    public Vertex parent;
    public Vertex child;

    public Edge(Vertex parent, Vertex child, Integer weight) {

        this.parent = parent;
        this.child = child;
        this.weight = weight;
    }
}

public class Graph {

    public Vertex root;
    public List<Vertex> vertices = new ArrayList<Vertex>();

    public Vertex createRoot(String name)
    {
        root = createVertex(name);
        return root;
    }

    public Vertex createVertex(String name)
    {
        Vertex n = new Vertex(name);
        this.vertices.add(n);
        return n;
    }

    public int[][] createAdjMatrix()
    {
        int[][] adj = new int[this.vertices.size()][this.vertices.size()];

        for (int i = 0; i < this.vertices.size(); i++)
        {
            Vertex v1 = this.vertices.get(i);

            for (int j = 0; j < this.vertices.size(); j++)
            {
                Vertex v2 = this.vertices.get(j);

                for (Edge e : v1.edges) {
                    if (e.child == v2)
                        adj[i][j] = e.weight;
                    
                }
            }
        }
        return adj;
    }
}

       def graph = new Graph();

        a = graph.createRoot("A");
        b = graph.createVertex("B");
        c = graph.createVertex("C");
        d = graph.createVertex("D");
        e = graph.createVertex("E");
        f = graph.createVertex("F");
        g = graph.createVertex("G");
        h = graph.createVertex("H");

        a.addEdge(b, 1).addEdge(d, 1);
        b.addEdge(c,1);
        c.addEdge(h, 1);

        d.addEdge(e, 1);
        e.addEdge(f, 1);
        f.addEdge(g, 1);
        g.addEdge(h, 1);

        int[][] adj = graph.createAdjMatrix();
        
        
def printMatrix(int [][] matrix, int Count)
{
    print("      ");
    
    for (int i = 0; i < Count; i++)
    {
       print "${( 'A'..'Z').get(i)}  "
    }

   println();

    for (int i = 0; i < Count; i++)
    {
       print "${( 'A'..'Z').get(i)} | ["

        for (int j = 0; j < Count; j++)
        {
            if (i == j)
            {
               print " &,"
            }
            else if (matrix[i][j] == 0)
            {
               print " .,"
            }
            else
            {
               print " ${ matrix[i][j]},"
            }

        }
       print " ]"
       println ""
    }
   println ""
}

printMatrix(adj, 8)
