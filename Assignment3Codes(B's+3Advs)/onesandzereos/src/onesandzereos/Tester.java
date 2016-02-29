
package onesandzereos;
import java.util.Scanner;
public class Tester 
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		// TODO Auto-generated method stub
        int length=1,right,curr=0;
        double maxfrac=-5;
        int test=Integer.parseInt(sc.nextLine());
        
        for(int t=0;t<test;t++)
        {int size=Integer.parseInt(sc.nextLine());
        int[] arr=new int[size];
        
        String input=sc.nextLine();
		String[] inputsp=input.split(" ");
		
		for(int i=0;i<inputsp.length;i++)
		   arr[i]=Integer.parseInt(inputsp[i]);
		
		//array taken
		
		while (length<arr.length)
		{
			for(int i=0;i<arr.length;i++)
		{
			 right=i+length;
			 
			 if (right<arr.length)
				 curr=findfrac(i,right,arr);
			 
			 if (curr>maxfrac)
				 maxfrac=curr;
		}
	          length++;	
		}
		
		displayreduform(maxfrac);
        }
		sc.close();
	}

	
	public static int findfrac(int left,int right,int[] arr)
	{
		int numpos=0,numneg=0;
		
		for(int i=left;i<=right;i++)
		{
			if (arr[i]==1)
				numpos++;
			if (arr[i]==-1)
				numneg++;
		}
		
		if (numneg!=0)
		 return numpos/numneg ;
		
		else
			return 0; //indicates -1 absent.
	}
	
	public static void displayreduform(double frac)
	{
		 int divisor=1,gcd=-5;
		 
		 while (true)
		 {
			frac=frac*divisor;
			
			if (((int)frac-frac)==0)
				break;
			
			divisor=divisor*10;
		 }
		 
		 //when it comes out we have frac as whole and the denominator.
		 int fracint=(int) frac;
		 while (true)
		 {
			 if (divisor==0)
				 break;
			 
			 if (fracint==0)
				 {System.out.println("0/1");
			     break;
				 }
			 gcd=gcd(fracint,divisor);
			 
			
			 if (gcd==1)
				 break;
			 
			 fracint=(int)(fracint/(float)gcd);
			 divisor=(int)(divisor/(float)gcd);
		 }
		 
		 if (fracint==0)
		 return;
		 if (divisor==0)
			 {System.out.println(fracint+"/"+1);
			 return;
			 }
		 System.out.println(fracint+"/"+divisor);
	}
	
	public static int gcd(int a,int b)
	{
		if (a==b)
			return a;
		
		if (a<b)
		{
			if (b%a==0)
				return a;
			
			for (int i=a-1;i>=1;i--)
			{
				if (a%i==0 && b%i==0)
					return i;
			}
		}
		

		if (a>b)
		{
			if (a%b==0)
				return b;
			
			for (int i=b-1;i>=1;i--)
			{
				if (a%i==0 && b%i==0)
					return i;
			}
		}
		
		return 0; //last case.
	}
}
