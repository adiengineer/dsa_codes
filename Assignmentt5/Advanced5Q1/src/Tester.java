import java.util.Scanner;
public class Tester
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
	 
		System.out.println("The change in average node depth is found using the static");
		System.out.println("changeinAvgDepth fuction.");
		
	     //create avl tree and then insert and see.
	     Bst t=new Bst();
	     
	     while (true)
	     {
	    	 int input=Integer.parseInt(sc.nextLine());
	    	 
	    	 if (input==-5)
	    		 break;
	    	 
	    	 t.insert(t.root,input,null);
	    	 t.inorder(t.root);
	    	 System.out.println();
	     }
	     
	     while (true)
	     {
	    	 int input=Integer.parseInt(sc.nextLine());
	    	 
	    	 if (input==-5)
	    		 break;
	    	 

	    	 //t.inorder(t.root);
	    	 //enter the key where you want to rotate, it will rotate the tree there if possible and compute the change in average node depth.S
	    	 System.out.println( changeInAvgDepth(t,t.search(input, 0, t.root)));

	     }
	     
	     sc.close();
	}

	
	//this code finds out the average change in depth, it is called in the tester method.
	public static double changeInAvgDepth(Bst at,Node curr)
	{
		//perform rotation at curr, find the difference in depth.
	       Node dummy=at.search(curr.key,0, at.root);
	       //the depth of curr is set
	       
		at.sumofdepths(curr,curr.depth);
		int inidsum=at.totaldepth;

		  at.totaldepth=0; //needs to be reset
		  
		  if (curr.right==null)
		  {
			  System.out.println("Left rotation not possible");
			  return 0.0;
		  }
		  
		at.rotateleft(curr);
		at.sumofdepths(curr.parent,curr.depth); //depth of root after rota will be the same, the root key will of course change
		int finaldsum=at.totaldepth;
		
		int n=at.sizesub(at.root);
		
		return (((double)(finaldsum-inidsum)/(double)n));
	}
	
	
}
