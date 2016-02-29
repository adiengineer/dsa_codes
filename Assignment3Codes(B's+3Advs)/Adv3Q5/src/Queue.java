
public class Queue 
{  
	private Node head=null;
      private Node tail=null;
      int size=0;
      public void insert(int key,int priority)//queue composes of a set of nodes 
      {if (head==null)
          { head=new Node();
    	     head.setData(key,priority);
    	     tail=head;
    	     head.setNext(null);
    	     size++;
          }
      
      else
          {  tail.setNext(new Node());
    	         tail.getNext().setData(key,priority);
    	         tail=tail.getNext();
    	         tail.setNext(null);
    	         size++;
          }
    	  
      }//insert at the tail of the queue.
      
      public pElement delete()
      {    
    	  pElement element;
    	  
    	  if (head==null)
    	     return (null); //represents error.
    	  
    	  if (head==tail)
            {  element=head.getData();
            
    		  head=null;
    	       tail=null;
    	       size=0;
    	       return element; //represents queue has become empty.
    	       //  System.out.println("Queue is now empty!");
            }
    	   
          //if these dont happen then it will come here.
    	  element=head.getData();
              head=head.getNext();
              size--;
        	   return element; //represents succesful deletion.
            
      }
      
      public void show()
      { Node curr=head; 
    	    while(curr!=null)
    	    {  System.out.print(curr.getvalue());
    	    	curr=curr.getNext();
    	    }
    	    System.out.println();
    	    System.out.println("Current size "+ size);
      }
}
