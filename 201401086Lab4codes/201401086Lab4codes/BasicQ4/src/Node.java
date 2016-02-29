
public class Node 
{
   int key;
   Node left;
   Node right;
   Node parent;
   
   //on Create new Node
   Node(int key,Node parent)
   {
	   this.key=key;
	   this.left=null;
	   this.right=null;
	   this.parent=parent;
   }
}
