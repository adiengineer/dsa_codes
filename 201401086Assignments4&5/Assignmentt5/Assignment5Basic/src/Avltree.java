
public class Avltree 
{
    Node root;
    int totaldepth=0;
    //behaviour
    
    public void avlinsert(Node curr,int key,Node parent)
	{
		//base case
		
		if (root==null)
		{
			root=new Node(key,null);
			root.height=0;
			root.balance=0; //trivial case, in others we will have to start from here.
			return;
		}
		
		if (curr.key>=key)
		{
			if (curr.left==null)
				{curr.left=new Node(key,curr);
				
				//place restore here
				this.avlrestore(curr.left);
			     return;
				}
			
			 // if not free recurse
			avlinsert(curr.left,key,curr);
		}
		  
		
		if (curr.key<key)
		{
			if (curr.right==null)
			{curr.right=new Node(key,curr);
			
			//place restore here
			this.avlrestore(curr.right);
		     return;
			}
		
		 // if not free recurse
			avlinsert(curr.right,key,curr);
		}
	}
    
    public void avlrestore(Node curr) //where insertion has taken place.
    {
    	//set leaf params.
    	curr.height=0;
    	curr.balance=0;
    	
    	//move up to the parent
    	curr=curr.parent;
    	
    	//now while root or problem node is not reached, go up,consi root case.
    	while (curr!=root && curr.balance==0)
    	{
    		curr.height++;
    		//need func to calc balance as null case is to be handled.
    		curr.balance=this.calcBalance(curr);
    		curr=curr.parent;
    	}
    	
   /* if (curr==root)      //maybe not needed.
    	{
    		curr.height=this.calcheight(curr);
    		curr.balance=this.calcBalance(curr);
    		return; //nothing to be done.
    	}*/       
    	//so now prob is at curr, prob of -2 or +2
    	curr.balance=this.calcBalance(curr);
    	
    	if (curr.balance==0)
    		return;
    	
    	//if not
    	
    	if (curr.balance==-2) //this ensures lc exists.
    	{
    		
    	   //is it child left heavy,      doubt, if left heavy then lc must exist.
    		if (curr.left.balance!=1) //not right heavy
    		{
    			//then one right rotate will do
    			this.rotateright(curr); //prob solved, curr is maitained.
    			curr.height=this.calcheight(curr);
    			curr.balance=this.calcBalance(curr);
    			curr.parent.height=this.calcheight(curr.parent);
    			curr.parent.balance=this.calcBalance(curr.parent);
    			return;
    		}
    		else
    		{
    			//you need to do two rotations.
    			Node y=curr.left;
    			
    			this.rotateleft(y);
    			y.height=this.calcheight(y);
    			y.balance=this.calcBalance(y);
    			y.parent.height=this.calcheight(y.parent);
    			y.parent.balance=this.calcBalance(y.parent); //one rota, now right rot at curr.
     			
    			this.rotateright(curr); //prob solved, curr is maitained.
    			curr.height=this.calcheight(curr);
    			curr.balance=this.calcBalance(curr);
    			curr.parent.height=this.calcheight(curr.parent);
    			curr.parent.balance=this.calcBalance(curr.parent);
    			return; //second rota and recalc of height and balance.
   			}
    	}
    	
    	else if (curr.balance==2) //this is for +2 case,this needs to be rewritten for right heavy
    	{
    		 //is it child left heavy,      doubt, if left heavy then lc must exist.
    		if (curr.right.balance!=-1) //not right heavy
    		{
    			//then one right rotate will do
    			this.rotateleft(curr); //prob solved, curr is maitained.
    			curr.height=this.calcheight(curr);
    			curr.balance=this.calcBalance(curr);
    			curr.parent.height=this.calcheight(curr.parent);
    			curr.parent.balance=this.calcBalance(curr.parent);
    			return;
    		}
    		else
    		{
    			//you need to do two rotations.
    			Node y=curr.right;
    			
    			this.rotateright(y);
    			y.height=this.calcheight(y);
    			y.balance=this.calcBalance(y);
    			y.parent.height=this.calcheight(y.parent);
    			y.parent.balance=this.calcBalance(y.parent); //one rota, now right rot at curr.
     			
    			this.rotateleft(curr); //prob solved, curr is maitained.
    			curr.height=this.calcheight(curr);
    			curr.balance=this.calcBalance(curr);
    			curr.parent.height=this.calcheight(curr.parent);
    			curr.parent.balance=this.calcBalance(curr.parent);
    			return; //second rota and recalc of height and balance.
   			}
    	}
    }
    
    
    public void transplant(Node u,Node v)
	{
		if (u.parent==null)
			root=v;
		
		else if (u==u.parent.left)
		     u.parent.left=v;
		
		else u.parent.right=v;
		
		if (v!=null)
			v.parent=u.parent;
	}
    
    //we will need to modify delete to incude avl restore property.
    
    public void delete(Node z)
	{
    	if (z==null)
    	{
    		System.out.println("AvlTree is empty");
    		return;
    	}
    	Node start; //indicate starting node for restore traversal.
		if (z.left==null)
			{    
			    if (z.right==null)
			    	start=z.parent;   //sometimes z.right might be null, in which case we can't use it to go up.
			    else
			    start=z.right;
			    
			   transplant(z,z.right);
              			//call restore here on start
			   
			   this.deleterestore(start);
			}
		
		else if (z.right==null)
			{transplant(z,z.left);
		      start=z.left;
		  	//call restore here on start
		      
		      this.deleterestore(start);
			}
		else
			{ Node y=this.minimum(z.right);
			    if (y.parent!=z)
			    {
			    	this.transplant(y,y.right);
			    	y.right=z.right;
			    	y.right.parent=y;
			    }
			    
			    this.transplant(z, y);
			    y.left=z.left;
			    y.left.parent=y; //y replaces z. and hence this is our starting node.
			    //call avl restore over here.
			    
			    this.deleterestore(y);
			}
	}
    
    public Node minimum(Node curr)
	{
		//assumes at least one node pressent
				if (curr==null)
					{System.out.println("First insert something");
					 return null; //error.
					}
				
				if (curr.left==null) //then it is the max.
				{
					return curr;
				}
				
				//if not null,then a greater ele exists.
				return minimum(curr.left);
	}
    
    public int calcBalance(Node x)
    {
    	int lh=0,rh=0;
    	
    	if (x.left==null)
    		lh=-1;
    	else
    	{
    		lh=x.left.height;
    	}
    	
      	if (x.right==null)
    		rh=-1;
    	else
    	{
    		rh=x.right.height;
    	}
      	
      	return (rh-lh);
    }
    
    public int calcheight(Node x)
    {
         int lh,rh;
         
         if (x.left==null)
     		lh=-1;
     	else
     	{
     		lh=x.left.height;
     	}
     	
       	if (x.right==null)
     		rh=-1;
     	else
     	{
     		rh=x.right.height;
     	}
           
       	return (1+Math.max(lh,rh));
    }
    
    //avl delete  restore.
    public void deleterestore(Node curr) //difference being can't stop after one correction
    {
    	if (curr==null)
    	{
    		System.out.println("AvlTree is now empty");
    		return;
    	}
    	while (curr!=null)
    	{
    		  //compute new height and balance, if imbalance correct
    		curr.height=this.calcheight(curr);
    		curr.balance=this.calcBalance(curr);
    		
    		if (curr.balance==-2 || curr.balance==2) // 1 possi at a time
    		{
    			//then we need to correct it.
    			
    			//removes the imbalance
    			if (curr.balance==-2) //this ensures lc exists.
    	    	{
    	    		
    	    	   //is it child left heavy,      doubt, if left heavy then lc must exist.
    	    		if (curr.left.balance!=1) //not right heavy
    	    		{
    	    			//then one right rotate will do
    	    			this.rotateright(curr); //prob solved, curr is maitained.
    	    			curr.height=this.calcheight(curr);
    	    			curr.balance=this.calcBalance(curr);
    	    			curr.parent.height=this.calcheight(curr.parent);
    	    			curr.parent.balance=this.calcBalance(curr.parent);
    	    			return;
    	    		}
    	    		else
    	    		{
    	    			//you need to do two rotations.
    	    			Node y=curr.left;
    	    			
    	    			this.rotateleft(y);
    	    			y.height=this.calcheight(y);
    	    			y.balance=this.calcBalance(y);
    	    			y.parent.height=this.calcheight(y.parent);
    	    			y.parent.balance=this.calcBalance(y.parent); //one rota, now right rot at curr.
    	     			
    	    			this.rotateright(curr); //prob solved, curr is maitained.
    	    			curr.height=this.calcheight(curr);
    	    			curr.balance=this.calcBalance(curr);
    	    			curr.parent.height=this.calcheight(curr.parent);
    	    			curr.parent.balance=this.calcBalance(curr.parent);
    	    			return; //second rota and recalc of height and balance.
    	   			}
    	    	}
    			
    			else if (curr.balance==2)
    			{
    	    		 //is it child left heavy,      doubt, if left heavy then lc must exist.
    	    		if (curr.right.balance!=-1) //not right heavy
    	    		{
    	    			//then one right rotate will do
    	    			this.rotateleft(curr); //prob solved, curr is maitained.
    	    			curr.height=this.calcheight(curr);
    	    			curr.balance=this.calcBalance(curr);
    	    			curr.parent.height=this.calcheight(curr.parent);
    	    			curr.parent.balance=this.calcBalance(curr.parent);
    	    			return;
    	    		}
    	    		else
    	    		{
    	    			//you need to do two rotations.
    	    			Node y=curr.right;
    	    			
    	    			this.rotateright(y);
    	    			y.height=this.calcheight(y);
    	    			y.balance=this.calcBalance(y);
    	    			y.parent.height=this.calcheight(y.parent);
    	    			y.parent.balance=this.calcBalance(y.parent); //one rota, now right rot at curr.
    	     			
    	    			this.rotateleft(curr); //prob solved, curr is maitained.
    	    			curr.height=this.calcheight(curr);
    	    			curr.balance=this.calcBalance(curr);
    	    			curr.parent.height=this.calcheight(curr.parent);
    	    			curr.parent.balance=this.calcBalance(curr.parent);
    	    			return; //second rota and recalc of height and balance.
    	   			}
    	    	} //removes imbalance on positove side
    			
    			//move up
    		}
    		
    		curr=curr.parent; 
    	}
    }
    
    public void rotateright(Node curr)
	{
Node y=curr.left; //this save is needed as then I can safely redirect this link elsewhere.
		
		if (y==null)
		return; //can't do left rotate if y is null.
		
		curr.left=y.right;
		y.right=curr;
		
		
		
		if (curr==root)
		{
			root=y;
		}
		else 
			{if (curr.key<curr.parent.key)
		    curr.parent.left=y;
		else
			curr.parent.right=y;
			}
		//all child pointers changed. Now change parent pointers.
		
		if (curr==root)
		{
			y.parent=null;
			curr.left.parent=curr;
			curr.parent=y;
			return;
		}
		
		y.parent=curr.parent;
		if (curr.left!=null)
		curr.left.parent=curr;
		curr.parent=y;
	}
    
    public void rotateleft(Node curr)
	{
	    // need to make right child of x parent of x.
		Node y=curr.right; //this save is needed as then I can safely redirect this link elsewhere.
		
		if (y==null)
		return; //can't do left rotate if y is null.
		
		curr.right=y.left;
		y.left=curr;
		
		
		if (curr==root)
		{
			root=y;
		}
		else
		{
			if (curr.key<curr.parent.key)
		    curr.parent.left=y;
		else
			curr.parent.right=y;
		
		}
		//all child pointers changed. Now change parent pointers.
		
		if (curr==root)
		{
			y.parent=null;
			curr.right.parent=curr;
			curr.parent=y;
			return;
		}
		
		y.parent=curr.parent;
		
		if (curr.right!=null)
		curr.right.parent=curr;
		
		curr.parent=y;
	}
    
    public void inorder(Node curr)
	{
		//base case is that curr is null
		if (curr==null)
			return;
		
		//else
		inorder(curr.left);
		
		System.out.print(curr.key+"/"+curr.balance+" ");
		
		inorder(curr.right);
	}
    
	public Node search(int key,int depth,Node curr)
	{
		//base
		if (curr==null)
		{
			System.out.println("Key not present");
			return null;
		}
		
		//if curr exists,check if key is found
		if (curr.key==key)
		{
			//System.out.print("Found at depth: "+depth);
			curr.depth=depth; //this will give depth of the root of subtree.
			return curr;
		}
		
		if (curr.key>=key)
			return search(key,depth+1,curr.left);
		
		if (curr.key<key)
			return search(key,depth+1,curr.right);
		
		//this will never happen
		return null;
	}
	
	
	public void sumofdepths(Node curr,int depth) //find depths of all nodes in the subtree
	{
		//first find the depth of the curr
		
		     if (curr==null)
			   return;
		     
		     curr.depth=depth;
		     totaldepth=totaldepth+curr.depth;
		     
		     this.sumofdepths(curr.left, depth+1);
		     this.sumofdepths(curr.right,depth+1);
	}
	
	public int sizesub(Node curr) //gives sizeofsub rooted at curr. 
	{
		if (curr==null)
			return 0;
		
		if (curr.left==null && curr.right==null)
			return 1; 
		
		//else call on both sides
		
		return 1+sizesub(curr.left)+sizesub(curr.right);
	}
	//total depth will be found at the end of this.
}
