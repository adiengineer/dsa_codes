import java.util.Scanner;
public class Tester 
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
      
		 int v;
		 
		 v=Integer.parseInt(sc.nextLine());
		 Graph g=new Graph(v);
		 
		//fill in the adjacency list
		 for(int i=0;i<v;i++)
		 {
			 String input=sc.nextLine().trim();
			 String[] inputsp=input.split(" ");
			 
			 g.fillList(inputsp, i);
		 }
		 
		 //fill in the weight data
		 for(int i=0;i<v;i++)
		 {
			 String input1=sc.nextLine().trim();
			 String[] inputsp1=input1.split(" ");
			 
			 g.fillweight(i, inputsp1);
		 }
		 
		 //the list has been made, now run BFS for a source node.
		 
		 //Vertex source=g.vertices[Integer.parseInt(sc.nextLine())-1];
		 //g.BFS(source);
		 //g.printpath(source,g.vertices[Integer.parseInt(sc.nextLine())-1]);
		 
		//g.DFS();
		
		/*for(int i=0;i<v;i++)
		{
	        System.out.println(g.vertices[i].id+"/"+g.vertices[i].discover+"/"+g.vertices[i].finish+" ");
		}*/
		
		 
		//now call djik
		 
		 g.djik(g.vertices[Integer.parseInt(sc.nextLine())-1]);
		 
		for(int i=0;i<v;i++) 
		{
		System.out.println((g.vertices[i].id+1)+"/"+g.vertices[i].distance);	
		}
		 sc.close();
	}

}
