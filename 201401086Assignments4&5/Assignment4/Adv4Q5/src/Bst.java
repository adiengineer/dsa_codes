

public class Bst 
{
    //attributes of the bst.
	Node root;
	
	//now write the functions
	
	//fist rec func to insert
	
	public void insert(Node curr,int key,Node parent)
	{
		//base case
		
		if (root==null)
		{
			root=new Node(key,null);
			return;
		}
		
		if (curr.key>=key)
		{
			if (curr.left==null)
				{curr.left=new Node(key,curr);
			     return;
				}
			
			 // if not free recurse
			insert(curr.left,key,curr);
		}
		  
		
		if (curr.key<key)
		{
			if (curr.right==null)
			{curr.right=new Node(key,curr);
		     return;
			}
		
		 // if not free recurse
		insert(curr.right,key,curr);
		}
	}
	
	//needs to traverse through the tree lhs,node,rhs
	
	public void inorder(Node curr)
	{
		//base case is that curr is null
		if (curr==null)
			return;
		
		//else
		inorder(curr.left);
		
		System.out.print(curr.key+"/"+curr.rank+" ");
		
		inorder(curr.right);
	}
	
	public void preorder(Node curr)
	{
		//base case is that curr is null
		if (curr==null)
			return;
		
		//else
		
		System.out.print(curr.key+" ");
		preorder(curr.left);
		preorder(curr.right);
	}

	public void postorder(Node curr)
	{
		//base case is that curr is null
				if (curr==null)
					return;
				
				//else
				
				
				preorder(curr.left);
				preorder(curr.right);
				System.out.print(curr.key+" ");
	}
	
	//found and at what depth,return pointer where found
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
			return curr;
		}
		
		if (curr.key>=key)
			return search(key,depth+1,curr.left);
		
		if (curr.key<key)
			return search(key,depth+1,curr.right);
		
		//this will never happen
		return null;
	}
	
	public Node searchrank(int rank,int depth,Node curr)
	{
		//base
		if (curr==null)
		{
			System.out.println("Key not present");
			return null;
		}
		
		//if curr exists,check if key is found
		if (curr.rank==rank)
		{
		//	System.out.print(curr.rank);
			return curr;
		}
		
		if (curr.rank>rank)
			return searchrank(rank,depth+1,curr.left);
			
		if (curr.rank<rank)
			return searchrank(rank,depth+1,curr.right);
		
		//this will never happen
		return null;
	}
	
	//returns the max key in an element.
	public int maximum(Node curr)
	{
		//assumes at least one node pressent
		if (curr==null)
			{System.out.println("First insert something");
			 return -5; //error.
			}
		
		if (curr.right==null) //then it is the max.
		{
			return curr.key;
		}
		
		//if not null,then a greater ele exists.
		return maximum(curr.right);
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
	
	//at the given node what is succesor.
	public Node succesor(int key,Node subroot)
	{
	   Node curr; //this is where query is found
	   
	   curr=this.search(key, 0, root);
	   
	   //if query not present return -5
	   if (curr==null)
		   return null;
	   
	   //otherwise.
	   //now if it has a Rhs sub
	   if (curr.right!=null)
	   {
		   return minimum(curr.right);
	   }
	   
	   //if rhs sub not present, then 
	   
	   while (curr.parent!=subroot.parent && (curr.key>curr.parent.key))
		   curr=curr.parent;
	   
	   //if curr's parent is null coming from a right path, 
	   //implies i have been following less elements and 
	   if (curr.parent==subroot.parent)
		   return null; //cant find succesor
	   
        //else return parent.
	   return curr.parent;
	}
	
	public int predecessor(int key,Node subroot)
	{
	   Node curr; //this is where query is found
	   
	   curr=this.search(key, 0, root);
	   
	   //if query not present return -5
	   if (curr==null)
		   return -5;
	   
	   //otherwise.
	   //now if it has a Rhs sub
	   if (curr.left!=null)
	   {
		   return maximum(curr.left);
	   }
	   
	   //if rhs sub not present, then 
	   
	   while (curr.parent!=subroot.parent && (curr.key<=curr.parent.key))
		   curr=curr.parent;
	   
	   //if curr's parent is null coming from a right path, 
	   //implies i have been following less elements and 
	   if (curr.parent==subroot.parent)
		   return -5; //cant find succesor
	   
        //else return parent.
	   return curr.parent.key;
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
	
   //give it loc, it tells you the depth.
	public int depth(Node curr)
   {
	     int depth=0;
	     
	     while (curr!=root)
	    	 {depth++;
	    	    curr=curr.parent;
	    	 }
	     
	     return depth;
   }
	
	//give node tell height, assues node is not null
	public int height(Node curr,int height) //initially 0 
	{
	  if (curr==null)
		  return 0;
	  
	   //base if leaf
	  if (curr.left==null && curr.right==null)
		  return height;
	  
	  //if not leaf or null
	    //max of the lefth,righth
	  int lefth=height(curr.left,height+1);
	  int righth=height(curr.right,height+1);
	  
	   if (lefth>righth)
		   return lefth;
	   else
		   return righth;
	}
	
	//traverse in zig zag order uses a double ended queue,
	
	
	//preorder in iterative mode.
	public void itepreorder(Node curr) 
	{
		 while (curr!=null)
		 {
			int checkvisit=curr.visit;
			 //here curr is not null,
			 
			 if (checkvisit==0) //not visited before
			 {
				curr.visit++;  //this must be done at the end.
				 
				System.out.print(curr.key+" "); //print imme on visiting.
				 if (curr.left!=null)
					 curr=curr.left;
			 }
			
			 else if (checkvisit==1)
			 {
				 curr.visit++;
				 if (curr.right!=null)
					 curr=curr.right;
			 }
			 
			 else if (checkvisit==2)
				 curr=curr.parent;
			 
			 //curr.visit++; //icrement at every loop.
		 }
	}
	
	public void itepostorder(Node curr) 
	{
		 while (curr!=null)
		 {
			int checkvisit=curr.visit;
			 //here curr is not null,
			 
			 if (checkvisit==0) //not visited before
			 {
				curr.visit++;  //this must be done at the end.
				 
				//System.out.print(curr.key+" "); //print imme on visiting.
				 if (curr.left!=null)
					 curr=curr.left;
			 }
			
			 else if (checkvisit==1)
			 {
				 curr.visit++;
				 if (curr.right!=null)
					 curr=curr.right;
			 }
			 
			 else if (checkvisit==2)
				 {
				   System.out.print(curr.key+" "); 
				   curr=curr.parent;
				 }
			 //curr.visit++; //icrement at every loop.
		 }
	}
	
	public void iteintorder(Node curr) 
	{
		 while (curr!=null)
		 {
			int checkvisit=curr.visit;
			 //here curr is not null,
			 
			 if (checkvisit==0) //not visited before
			 {
				curr.visit++;  //this must be done at the end.
				 
				//System.out.print(curr.key+" "); //print imme on visiting.
				 if (curr.left!=null)
					 curr=curr.left;
			 }
			
			 else if (checkvisit==1)
			 {
				 curr.visit++;
				 
				 System.out.print(curr.key+" ");
				 
				 if (curr.right!=null)
					 curr=curr.right;
			 }
			 
			 else if (checkvisit==2)
				 {
				  // System.out.print(curr.key+" "); 
				   curr=curr.parent;
				 }
			 //curr.visit++; //icrement at every loop.
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
	
	public void delete(Node z)
	{
		if (z.left==null)
			transplant(z,z.right);
		
		else if (z.right==null)
			transplant(z,z.left);
		
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
			    y.left.parent=y; //y replaces z.
			}
	}
	
	//reucrsive function
	public void findrankall(Node curr,int pbaserank,int prank) //ini call (root,1,0) //as root has no parent.
	{
		int baserank=0;
		
		if (curr==null)
			return;  //base case all work done in this direction
		
	    if (curr==root)
	    {
	        baserank=1;       	
	    	curr.rank=1+this.sizesub(curr.left); //rank of root is simply its local rank.
	    	
	    	//now call left and right
	    	this.findrankall(curr.left, baserank,curr.rank);
	    	this.findrankall(curr.right, baserank,curr.rank);
	    }
	    
	    else
	    {
	    	//if left then one and right then another.
	    	if (curr.key<=curr.parent.key) // then left child 
	    	{
	    		baserank=pbaserank;
	    		
	    		curr.rank=baserank+1+this.sizesub(curr.left)-1;
	    	}
	    	else if (curr.key>curr.parent.key) // then left child 
	    	{
	    		baserank=1+prank;
	    		
	    		curr.rank=baserank+1+this.sizesub(curr.left)-1;
	    	}
	    	
	    	this.findrankall(curr.left, baserank,curr.rank);
	    	this.findrankall(curr.right, baserank,curr.rank);
	    }
	}
	
	//before this function can be used, ranks must be computed.
	public boolean precisesub(int i,int j) //assume i<j that should be the rela between the two.
	{
		  Node curr=root;
		  
		  while (curr!=null)
		  {
		         if (curr.rank< i && curr.rank<j)
		        	 curr=curr.right;
		         
		        else if (curr.rank> i && curr.rank>j)
		        	 curr=curr.left;
		         
		        else if (curr.rank>=i && curr.rank<=j )
		        	break;
		  }
		  
		  //if curr becomes null it implies that the range input is wrong.
		  if (curr==null)
		  {
			  System.out.println("Check range");
			  return false;
		  }
		  
		  //if not. then I need to find left and right of the range.
		  //curr represents the subtree's root.
		  
		  //left right will indicate start and end of desired list in subtree nothing outside
		  //should be present, so left- no predecessor and right- no successor.
		 
		  //debug
		 // System.out.println(curr.key);
		  
		  Node left=this.searchrank(i,0,curr);
		  Node right=this.searchrank(j,0,curr);
		  
		  if (this.predecessor(left.key,curr)==-5 && this.succesor(right.key,curr)==null)
			  {
			   System.out.println("Subtree rooted at"+curr.key);
			    return true;
			  
			  }
		  else
		  return false;
	}
	
	public void subpair(int n) //where n is number of nodes in the subtree
	{
		//Start k from n-1, as mentioned.
		int k=n-1;
		
		  while(k>1) //we don't want complete tree nor do we want the whole tree. 
		{if ((this.precisesub(1,k)&&this.precisesub(n-k+1,n))==true)
		{
		 System.out.println(k+ " sized precise sub possible");
		 break;
		}
		  
		  k--;
		}
		  
		  if (k<=1)
				 {System.out.println("Not possible");
				 
				 }
	}
	
	public int numberoforderings(Node curr,int n) //initial call (root,size of sub rooted at n.)
	{
		  //compute for the given structures how many orderings of keys possible.
		     if (n==0)
		    	 return 0;
		     
		     if (n==1)
		    	 return 1; //base cases.
		     
		     //if not return 
		    int sizeleft=this.sizesub(curr.left);
		     int sizeright=this.sizesub(curr.right);
		     
		     return (combi(sizeleft+sizeright,sizeleft)*numberoforderings(curr.left,sizeleft)+numberoforderings(curr.right,sizeright)); 
	}		
	
	public static int factorial(int n)
	{
		int fact=1;
		
		for(int i=n;i>=2;i--)
			fact=fact*i;
		
		return fact;
	}
	
	public static int combi(int n,int r)
	{
		
		return (factorial(n)/( factorial(n-r)*factorial(r) ) );
	}
	
	
}
