

public class Node 
{
   int key;
   int visit=0; //this will indicate the number of times node visited, used for iterative traversal.
   Node left;
   Node right;
   Node parent;
   int rank; //will hold the rank of the node.
   int height;
   int balance;
   int depth;
   //on Create new Node , set augmented keyfields at runtime.
   Node(int key,Node parent)
   {
	   this.key=key;
	   this.left=null;
	   this.right=null;
	   this.parent=parent;
   }
}
