import java.util.Scanner;
public class Tester 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	 Scanner sc=new Scanner(System.in);	

	 System.out.println("numberoforderings(root,n) recursively finds the requried orderings" );
	 System.out.println("Also factorial, combinations function help in calculations");
		  Bst ab=new Bst();
		  
		  while (true)
		  {
			  int input=Integer.parseInt(sc.nextLine());
			  
			  if (input==-5)
				  break;
			  
			  ab.insert(ab.root,input,null);
			  
		  }
		  
		 //computes the total orderings of keys for the structure generated in the 
		  // above while loop.
		  System.out.println(ab.numberoforderings(ab.root,ab.sizesub(ab.root)));
		  
		  sc.close();
	}


}
