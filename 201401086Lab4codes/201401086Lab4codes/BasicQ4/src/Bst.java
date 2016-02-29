
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
		
		System.out.print(curr.key+" ");
		
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
	
	public int minimum(Node curr)
	{
		//assumes at least one node pressent
				if (curr==null)
					{System.out.println("First insert something");
					 return -5; //error.
					}
				
				if (curr.left==null) //then it is the max.
				{
					return curr.key;
				}
				
				//if not null,then a greater ele exists.
				return minimum(curr.left);
	}
	
	//at the given node what is succesor.
	public int succesor(int key)
	{
	   Node curr; //this is where query is found
	   
	   curr=this.search(key, 0, root);
	   
	   //if query not present return -5
	   if (curr==null)
		   return -5;
	   
	   //otherwise.
	   //now if it has a Rhs sub
	   if (curr.right!=null)
	   {
		   return minimum(curr.right);
	   }
	   
	   //if rhs sub not present, then 
	   
	   while (curr.parent!=null && (curr.key>curr.parent.key))
		   curr=curr.parent;
	   
	   //if curr's parent is null coming from a right path, 
	   //implies i have been following less elements and 
	   if (curr.parent==null)
		   return -5; //cant find succesor
	   
        //else return parent.
	   return curr.parent.key;
	}
	
	public int predecessor(int key)
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
	   
	   while (curr.parent!=null && (curr.key<=curr.parent.key))
		   curr=curr.parent;
	   
	   //if curr's parent is null coming from a right path, 
	   //implies i have been following less elements and 
	   if (curr.parent==null)
		   return -5; //cant find succesor
	   
        //else return parent.
	   return curr.parent.key;
	}
	
	public int sizesub(Node curr) //this curr should be left pointer of curr. 
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
	
	
}
