
public class DoubleQueue 
{
	private QNode head=null;
    private QNode tail=null;
    int size=0;
    
    public void insertatright(Node a)//queue composes of a set of nodes 
    {if (head==null)
        { head=new QNode();
  	     head.setData(a);
  	     tail=head;
  	     head.setNext(null);
  	     size++;
        }
    
    else
        {  tail.setNext(new QNode());
  	         tail.getNext().setData(a);
  	         tail=tail.getNext();
  	         tail.setNext(null);
  	         size++;
        }
  	  
    }//insert at the tail of the queue.
    
    public void insertatleft(Node a)
    {
    	if (head==null)
        { head=new QNode();
  	     head.setData(a);
  	     tail=head;
  	     head.setNext(null);
  	     size++;
        }
    	
    	else
    	{
    		QNode temp=new QNode();
    		temp.setData(a);
    		temp.setNext(head);
    		head=temp;
    		size++;
    	}
    }
    
    public Node deletefromleft()
    {
    	 Node element;
   	  
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
    
    public Node deletefromright()
    {
    	Node element;
    	
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
    	 
    	 QNode curr=head;
    	 
    	 while (curr.next!=tail)
    	       curr=curr.next;
    	       
    	 element=tail.getData();	 
    	 tail=curr;
    		 
    		 tail.next=null;
    		 size--;
    	 return element;
    }
    
    public void show()
    { QNode curr=head; 
  	    while(curr!=null)
  	    {  System.out.print(curr.getData());
  	    	curr=curr.getNext();
  	    }
  	    System.out.println();
  	    System.out.println("Current size "+ size);
    }
}
