
public class Node
{  
	private pElement data=new pElement(); //mistake was that I was not asssining an memory for Plement.
     private Node next=null;
    
	public pElement getData() {
		return data;
	}
	
	public int getvalue()
	{
		return data.data;
	}
	public void setData(int key,int priority) {
		data.data =key;
		data.priority=priority;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

     
     
}

