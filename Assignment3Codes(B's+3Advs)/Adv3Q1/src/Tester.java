import java.util.Scanner;
public class Tester 
{
	static int limit;
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
       
		int k,limit;
		
		//main parameters taken in. 
		k=Integer.parseInt(sc.nextLine());
		 limit=Integer.parseInt(sc.nextLine());
		 
		 int[] heap=new int[limit];
		 //now take in i whose p and c is needed.
		
		 while (true)
		 {
			 int input=Integer.parseInt(sc.nextLine());
			 
			 if (input==-5)
				 break;
			 
			 relatives(heap,k,input);
		 }
		 sc.close();
	}

	public static void relatives(int[] heap,int k,int i)
	{
		int base=k*i,ans;
		
		System.out.print("Childern at indices: ");
		for(int j=1;j<=k;j++)
		{
			ans=base+j;
			if (ans<heap.length)
				System.out.print(ans+" ");
		}
		System.out.println();
		
		System.out.print("Parent at index: ");
		
		System.out.println((i-1)/k);
	}
}