import java.util.ArrayList;
public class Graph 
{
   int v; //stands for number of vertices
   Vertex[] vertices;
   ArrayList<ArrayList<Vertex>> adj; // this is just ref to arraylist of arraylists of vertices.
    int time=0;
   Queue q= new Queue();
   // we need to have an array of pointers to arraylists.
   
   int[][] weight; //this will store the weight of directed paths.
   
   Vertex[] queue; //will act as the priority queue.
   //now give its constructor.
   
   
   Graph(int v)
   {
	  this.v=v;  //sets num of vertices.
	  queue=new Vertex[v];
	  weight=new int[v][v];
	  vleft=v;
	  //initialize the size of array,
	  // we can't create an array of a genreric data type, so we will use arraylist of arrayList.
	  adj=new ArrayList<ArrayList<Vertex>>(v); // makes space for v pointers of lists of vertices.
	  vertices=new Vertex[v]; //the vertices. this will have id 1,2,3,4,5 and fill the necessary data.
	  
	  for (int i=0;i<v;i++)
	  {
		  vertices[i]=new Vertex(i,"white");
		  vertices[i].parent=null;
		  vertices[i].distance=10000; //for djik we need this to be some high value
		    
		  //now point the queue to these vertices 
		  queue[i]=vertices[i]; 
	  }
	  //constructor for arraylists of vertices.
	  for(int i=0;i<v;i++)
	  {
		adj.add(new ArrayList<Vertex>());  
	  }
   }
   
   //now we need to fill in the adja cen list.
   
  //call this for each line to give weights.
   
   int vleft;
   public Vertex extract()
   {
	   Vertex temp=null;
	   int min=10000,pos=0;
	   for(int i=0;i<v;i++)
	   {
		   if (queue[i]!=null && queue[i].distance<min)
		   {
			   min=queue[i].distance;
			   temp=queue[i];
			   pos=i;
		   }
	   }
	   
	   //now we now min
	   queue[pos]=null; //erase this pointer
	   vleft--; // indicates 1 is less, this will be test to breka out of loop
	   
	  // System.out.println(temp.id+1); //debug
	   return temp;
   }
   
   public void djik(Vertex s)
   {
	   s.parent=null;
	   s.distance=0;
//	   System.out.println("djik was called");
	   while(vleft>0)
	   {
		   Vertex u=this.extract();
		   
		   for(int i=0;i<adj.get(u.id).size();i++)
		   {
			   this.relax(u, adj.get(u.id).get(i));
		   }
	   }
   }
   
   public void relax(Vertex u,Vertex v)
   {
	   int w=weight[u.id][v.id]; //assuming u,v labelled correctly
	   
	   if (v.distance>(u.distance+w))
		   {v.distance=(u.distance+w);
		    v.parent=u;
		   }
   }
   public void fillweight(int i,String[] input)
   {
	   for(int j=0;j<v;j++)
		   weight[i][j]=Integer.parseInt(input[j]);
   }
   
   
   //call this from main to fill each list one by one.
   public void fillList(String[] input, int index)
   {
	     
	   for (int i=0;i<input.length;i++)
	    {
	       adj.get(index).add(vertices[Integer.parseInt(input[i])-1]); // fill the vertex at its position, pass in the pointer     	
	    }
   }
   
  //searches a vertex in the adja list
  
   public Vertex searchVertex(int id)
   {
 	   for(int i=0;i<v;i++)
 	   {
 		  for(int j=0; j<adj.get(i).size();j++)
 		  {
 			  if (adj.get(i).get(j).id==id  )
 				  return adj.get(i).get(j);
 		  }
 	   }
 	   
 	   return null;
   }
   
   public Vertex searchVertexafterBFS(int id)
  {
	   for(int i=0;i<v;i++)
	   {
		  for(int j=0; j<adj.get(i).size();j++)
		  {
			  if (adj.get(i).get(j).id==id && adj.get(i).get(j).parent!=null )
				  return adj.get(i).get(j);
		  }
	   }
	   
	   return null;
  }
   
   public void BFS(Vertex s) //the param indicates which vertex should be trated as the source.
   {
	   //ini for source
	   s.color="grey";
	   s.parent=null;
       s.distance=0;
       
       q.insert(s);
       
       while (q.size!=0)
       {
    	  Vertex u=q.delete();
    	  
    	  int id=u.id;
    	  
    	  for(int i=0;i<adj.get(id).size();i++)
    	  {
    		  Vertex curr=adj.get(id).get(i);  //id is 1 indexed. 
    		  
    		  if (curr.color=="white")
    		  {
    			  curr.color="grey";
    			  curr.distance=u.distance+1;
    			  curr.parent=u;
    			  q.insert(curr);
    		  }
    	  }
    	  
    	  u.color="black";
       }
   }
   
   public void printpath(Vertex s,Vertex v)
   {
	   if (v==null)
	   {
		   System.out.println("Vertex not found");
		    return; //node not found
	   }
	   if (v==s)
		   System.out.print((v.id+1)+"/"+v.distance+" ");
	   
	   else
	   {
		   if (v.parent==null)
			   {System.out.println("Path between source and vertex does not exist");
			   return;
			   }
		   
		   printpath(s,v.parent);
		   System.out.print((v.id+1)+"/"+v.distance+"/"+(v.parent.id+1)+" ");
	   }
   }
   
   public void DFS() //select 1st vertex as source.
   {
	   time=0;
	   
	   for (int i=0;i<v;i++)
	   {
		   vertices[i].color="white";
		   vertices[i].parent=null;
	   }
	   
	   
	   
	   for(int i=0;i<v;i++)
	   {
		   if (vertices[i].color=="white")
		   dfsVisit(vertices[i]);
	   }
   }
   
   public void dfsVisit(Vertex v)
   {
	     time++;
	     v.discover=time;
	     v.color="grey";
	     
	     for(int j=0;j<adj.get(v.id).size();j++)
	     {
	    	 if (adj.get(v.id).get(j).color=="white")
	    	 {
	    		 adj.get(v.id).get(j).parent=v;
	    		 dfsVisit(adj.get(v.id).get(j));
	    	 }
	     }
	     
	     v.color="black";
	     time++;
	     v.finish=time;
   }
}
