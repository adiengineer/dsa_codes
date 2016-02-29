import java.util.Scanner;
public class Tester 
{

	public static void main(String[] args) 
	{
     Scanner sc=new Scanner(System.in);		

    System.out.println("All BST routines  and functions for advanced questions except questions 5 and 7 have been"
    		+ "written here. I have made only one tester class to test all of these routines. If you want to test"
    		+ "any of the fucntions use this reference."); 
    System.out.println("For insert and delete use insert and delete functions");
    System.out.println("ﬁnd/search, maximum, minimum, successor and predecessor have been implemented");
    System.out.println("Height and depth functions also written. sizesub gives size of subtree");
    System.out.println("Inorder,preorder,postorder methods are recursive");
    System.out.println("While iteinorder,preorder,postorder have been done iteratively");
    System.out.println();
    System.out.println("Adv Q1: For this we have findrankall method which finds rank of all nodes dynamically.");
    System.out.println("precisesub(int i,int j) tells if a subtree containing only elements between i-j exists or not.");
    System.out.println("This solves AdvQ.1");
    System.out.println("Using this Adv Q.6 is solved by the method subpair(int n) which returns largest k");
    System.out.println("as required in the question");
    System.out.println("nodes which if you disconnect from their parents give you three subtress");
    System.out.println("with approximately n/3 size. I have allowed an error of (n/3)+-1 for the sizes");
    System.out.println("numberof method is for Adv Q.5. ");
    System.out.println("All these methods are commented out in the main method and can be checked.");
     //create tree
     Bst b=new Bst();
     
     while (true)
     {
    	 int input=Integer.parseInt(sc.nextLine());
    	 
    	 if (input==-5)
    		 break;
    	 
    	 b.insert(b.root,input,null);
       	
     }
     
     //Adv Q3 tester function
     b.equaltripartition();
     
     
//     b.zigzag(); call for zig zag
     
    /* while (true)
     {
    	 int input=Integer.parseInt(sc.nextLine());
    	 
    	 if (input==-5)
    		 break;
    	 
    	 //int max=b.maximum(b.root);
    	// int suc=b.predecessor(input);
    	 
    	 Node curr=b.search(input,0,b.root);
    	   
    	 
    	 //for subtree size
    	 //if (curr!=null && curr.left!=null) //then we can find size left sub
    	 //      System.out.println(b.sizesub(curr.right));
    	 
    	 
    	 //for depth
    	// System.out.println(b.depth(curr));
    	 
    		// System.out.println(suc);
    	 
    	 //for height check
    	// System.out.println(b.height(curr, 0));
     }*/
    
     //call for itepreorder.
     //b.itepreorder(b.root);
     //b.itepostorder(b.root);
     
    // b.iteintorder(b.root);
     
    //delete function has also been written.
     b.findrankall(b.root,1,0);
     //b.inorder(b.root);
      
   
     //code for checking k adv Q1
     /*
     while (true)
     {
    	int left=Integer.parseInt(sc.nextLine());
    	int right=Integer.parseInt(sc.nextLine());
    	if (left==-5)
    		break;
    	
    	
    	System.out.println(b.precisesub(left,right));
     }*/
     
     //code for checking AdvQ6
    // b.subpair(Integer.parseInt(sc.nextLine()));
     
     System.out.println(); 
      
     sc.close();
	}

//this func assumes that curr is not null and has a left sub, upper check required.
	
}
