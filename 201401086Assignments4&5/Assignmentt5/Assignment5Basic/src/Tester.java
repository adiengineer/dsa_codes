import java.util.Scanner;
public class Tester 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
     Scanner sc=new Scanner(System.in);
     
     System.out.println("For Basic Q,1 use rotateright and rotateleft functions");
     System.out.println("After rotations the curr which is passed continues to point");
     System.out.println("to the old parent");
     System.out.println();
     System.out.println("For avl insertion use avlinsert which uses avlrestore.");
     System.out.println();
     System.out.println("delete function uses deleterestore.");
     System.out.println("The while loop runs in tester until you feed in -5");
     //create avl tree and then insert and see.
     Avltree at=new Avltree();
     
     while (true)
     {
    	 int input=Integer.parseInt(sc.nextLine());
    	 
    	 if (input==-5)
    		 break;
    	 
    	 at.avlinsert(at.root,input,null);
    	 at.inorder(at.root);
    	 System.out.println();
     }
     
     while (true)
     {
    	 //check delete
 int input=Integer.parseInt(sc.nextLine());
    	 
    	 if (input==-5)
    		 break;
    	 
    	
    	 at.delete( at.search(input,0,at.root));
    	 at.inorder(at.root);
    	 System.out.println();
    	 
     }
     sc.close();
	}
	
	public static double changeInAvgDepth(Avltree at,Node curr)
	{
		//perform rotation at curr, find the difference in depth.
	       Node dummy=at.search(curr.key,0, at.root);
	       //the depth of curr is set
	       
		at.sumofdepths(curr,curr.depth);
		int inidsum=at.totaldepth;
		
		at.rotateleft(curr);
		at.sumofdepths(curr.parent,curr.depth); //depth of root after rota will be the same, the root key will of course change
		int finaldsum=at.totaldepth;
		
		int n=at.sizesub(at.root);
		
		return (((double)(finaldsum-inidsum)/(double)n));
	}

}
