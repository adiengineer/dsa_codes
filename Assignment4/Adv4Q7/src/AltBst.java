
public class AltBst 
{
	
//has a root attribute.	
 Node root;   
	
	//recursive insert, it uses param insert to demarcate the level
 
 //insertion okay for one pretty random test case.
	public void insert(Node curr,int key,int level) //initial call (t.root,0)
	{
		//if level is even use normal rule else use inv rule.
		if (root==null)
		    {root=new Node(key,null);
		    return;
		    }
		
		//if nodes present
		if (level%2==0) //if level is even, normal
		{
			if (curr.key>key) //assume distinct.
			{
				if (curr.left==null)
				{
					curr.left=new Node(key,curr);
					return;
				}
				
				insert(curr.left,key,level+1);
			}
			
			else if (curr.key<key)
			{
				if (curr.right==null)
				{
					curr.right=new Node(key,curr);
					return;
				}
				
				insert(curr.right,key,level+1);

			}
		}
		
		else ///if odd, inv the rule.
		{
			if (curr.key>key) //assume distinct.
			{
				if (curr.right==null)
				{
					curr.right=new Node(key,curr);
					return;
				}
				
				insert(curr.right,key,level+1);
			}
			
			else if (curr.key<key)
			{
				if (curr.left==null)
				{
					curr.left=new Node(key,curr);
					return;
				}
				
				insert(curr.left,key,level+1);

			}
		}
	}
	
	public void inorder(Node curr)
	{
		//base case is that curr is null
		if (curr==null)
			{
			  System.out.println(); 
			  return;
			}		
		
		//else
		inorder(curr.left);
		
		System.out.print(curr.key+" ");
		
		inorder(curr.right);
	}
	
	//recursive search in the alt bst.
	public Node search(Node curr,int key,int level) //ini call (t.root,key,0)
	{
	     if (curr==null)
	     {
	    	 return null; //indicates not found.
	     }
	     
	     if (curr.key==key)
	     {
	    	 return curr;
	     }
	     
	     //reaching here implies not found at this node. So where to move?
	     
	     if(level%2==0) //if even then normal
	     {
	          if (curr.key<key)
	        	 return  search(curr.right,key,level+1); //important to preinrement.
	          else if (curr.key>key)
	        	  return search(curr.left,key,level+1);
	     }
	     
	     else
	     {
	    	 if (curr.key<key)
	    		 return search(curr.left,key,level+1); //important to preinrement.
	          else if (curr.key>key)
	        	  return search(curr.right,key,level+1);
	     }
	     
	    return null; 
	}
	
	public int maximum(Node curr,int level)
	{
		//assumes at least one node pressent
		if (curr==null)
			{System.out.println("First insert something");
			 return -5; //error.
			}
		
		if (level%2==0)
		{if (curr.right==null) //then it is the max.
		{
			return curr.key;
		}
		
		//if not null,then a greater ele exists.
		return maximum(curr.right,level+1);
		}
		
		else
		{
			if (curr.left==null) //then it is the max.
			{
				return curr.key;
			}
			
			//if not null,then a greater ele exists.
			return maximum(curr.left,level+1);	
		}
	}
	
	public int minimum(Node curr,int level)
	{
		//assumes at least one node pressent
		if (curr==null)
			{System.out.println("First insert something");
			 return -5; //error.
			}
		
		if (level%2==0)
		{if (curr.left==null) //then it is the max.
		{
			return curr.key;
		}
		
		//if not null,then a lesser ele exists.
		return minimum(curr.left,level+1);
		}
		
		else
		{
			if (curr.right==null) //then it is the max.
			{
				return curr.key;
			}
			
			//if not null,then a greater ele exists.
			return minimum(curr.right,level+1);	
		}
	}
	public int succesor(Node curr)
	{
		if (curr==null)
		{
			return -5; //indicates succsor not found. 
		}
		
		//find depth
		
		Node up=curr;
		int depth=0;
		
		while (up.parent!=null)
		{
			depth++;
			up=up.parent;
		}
		
		  //depth found
	
	
			if (depth%2==0)
		{
			//then like normal.
			if (curr.right!=null)
			   return this.minimum(curr.right,depth+1);
			
	       while (depth>=0)
	       {
	    	   if (curr.parent.key>curr.key)
	    		   return curr.parent.key;
	    	   
	    	   //else
	    	   depth--;
	    	   curr=curr.parent;
	       }
		}
			
			else
			{
				if (curr.left!=null)
					   return this.minimum(curr.left,depth+1);
					
			       while (depth>=0)
			       {
			    	   if (curr.parent.key>curr.key)
			    		   return curr.parent.key;
			    	   
			    	   //else
			    	   depth--;
			    	   curr=curr.parent;
			       }
			}
		 return -5; 
		}
	}

