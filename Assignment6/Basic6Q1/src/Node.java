


public class Node
{  
	Vertex data;
    Node next=null;
    

	public void setData(Vertex v) {
		this.data = v;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

     public Vertex getData()
     {
    	 return data;
     }
     
}

