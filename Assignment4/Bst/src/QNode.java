
public class QNode 
{
	 Node tnode=null;
     QNode next=null;
   
	public Node getData() {
		return tnode;
	}
	
   public void setData(Node a)
   {
	   tnode=a;
   }
	public QNode getNext() {
		return next;
	}
	public void setNext(QNode next) {
		this.next = next;
	}

}
