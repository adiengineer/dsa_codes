import java.util.Scanner;
public class Tester {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);

		//we need to take in the range permitted and size of array
		
		int size,range,i,pointer;
		size=Integer.parseInt(sc.nextLine());
		range=Integer.parseInt(sc.nextLine());
		
		pointer=size-1;
		
		int[] arr=new int[size];
		int[] b=new int[range];
		//fill in the array
		for( i=0;i<size;i++)
		{
		//	int curr=Integer.parseInt(sc.nextLine());
			
		//	if (curr>=1 && curr<=range)
		   arr[i]=Integer.parseInt(sc.nextLine());
			
		//	else
			//	break;
		}
		
	//	if (i!=size)
		//	System.out.println("inputs not valid for counting sort");
		
		
			//do the sorting.
			
			//this will count occur of each element.
			for(int k=0;k<size;k++)
			   b[arr[k]-1]++;
			
			//now rearange elements according to this count
			
		for(int j=range-1;j>=0;j--)
		{
			while (b[j]>0)
			{
				arr[pointer]=j+1; //to take care of the zero index.
				b[j]--;
				pointer--;
			}
		}
		
		//arr should be sorted.
		//display it.
		for(int j=0;j<arr.length;j++)
			System.out.println(arr[j]);
		
		
		
		sc.close();
	}

}
