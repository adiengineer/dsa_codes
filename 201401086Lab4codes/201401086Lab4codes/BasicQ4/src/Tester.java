import java.util.Scanner;
public class Tester 
{

	public static void main(String[] args) 
	{
     Scanner sc=new Scanner(System.in);		

     //create tree
     Bst b=new Bst();
     
     while (true)
     {
    	 int input=Integer.parseInt(sc.nextLine());
    	 
    	 if (input==-5)
    		 break;
    	 
    	 b.insert(b.root,input,null);
    	
     }
     
     while (true)
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
    	 
    	 System.out.println(b.height(curr, 0));
     }
     
     sc.close();
	}

//this func assumes that curr is not null and has a left sub, upper check required.
	
}
