
public class Vertex 
{
   int id;
   String color;
   Vertex parent;
   int distance; // bfs ensures that this is the min dist from source.
   int discover;
   int finish;
   
   Vertex(int id,String color)
   {
	   this.id=id;
	   this.color=color;
   }
}
