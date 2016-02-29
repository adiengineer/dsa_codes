

public class Node 
{
   int key;
   int visit=0; //this will indicate the number of times node visited, used for iterative traversal.
   Node left;
   Node right;
   Node parent;
   int rank; //will hold the rank of the node.
   
   //on Create new Node
   Node(int key,Node parent)
   {
	   this.key=key;
	   this.left=null;
	   this.right=null;
	   this.parent=parent;
   }
}
