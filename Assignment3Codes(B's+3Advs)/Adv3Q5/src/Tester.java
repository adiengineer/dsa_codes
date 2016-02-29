import java.util.Scanner;

public class Tester 
{

	public static void main(String[] args) 
	{
	Scanner sc=new Scanner(System.in);
         
	int data,priority;
	    //test the priority queue.
	     PriorityQueue pq=new PriorityQueue();
	     
	      while (true)
	      {
	    	  data=Integer.parseInt(sc.nextLine());
	    	  priority=Integer.parseInt(sc.nextLine());
	    	  
	    	  if (data==-5)
	    		  break;
	    	  
	    	  pq.priorityInsert(data, priority);
	    	  pq.showQueue();
	      }
	      
	      sc.close();
	}

}
