import java.util.Scanner;

public class Tester 
{

	public static void main(String[] args) 
	{
	Scanner sc=new Scanner(System.in);	

	
	System.out.println("Insert is for part a) Adv Q7");
	System.out.println("inorder method is for display");
	System.out.println("for part b) use mehtods search, maximum and succesor");

	  AltBst ab=new AltBst();
	  
	  while (true)
	  {
		  int input=Integer.parseInt(sc.nextLine());
		  
		  if (input==-5)
			  break;
		  
		  ab.insert(ab.root,input,0);
		  
	  }
	  
	  ab.inorder(ab.root);
	  
	  System.out.println(ab.maximum(ab.root,0));
	  
	  
	  //loop for search
	  while (true)
	  {
int input=Integer.parseInt(sc.nextLine());
		  
	  if (input==-5)
			  break;
		  
		  //Node result=ab.search(ab.root,input,0);
		  
		 // if (result!=null)
		  System.out.println(ab.succesor(ab.search(ab.root,input,0)));
		  
	  }
	  
	  sc.close();
	}
	
}
