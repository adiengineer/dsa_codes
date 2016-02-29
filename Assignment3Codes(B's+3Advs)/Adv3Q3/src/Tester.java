import java.util.Scanner;


public class Tester 
{
	static int heapsize=0,sizelimit;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 //routine scanning and array generation.
        Scanner sc=new Scanner(System.in);
        
        //assume that the array repersenting a complete tree is fixed i.e size is fixed.
        
       
      
       sizelimit=Integer.parseInt(sc.nextLine()); //array will have this limit
       int[] heap=new int[sizelimit]; // max possible eleemnts will be decided by this limit.
         
       while(true)
       {
      	 int key=Integer.parseInt(sc.nextLine());
      	 
      	 if (key==-5)
      		 break;
      	 
      	 insertinAltheap(heap,key);
      	 showheap(heap);
       }
       
       sc.close();
	}

	public static void insertinAltheap(int []heap,int key)
	{
		   //heap size is 1 indexed.
		int curr,temp,parentin,grandin;
		if (heapsize==sizelimit)
		{
			System.out.println("Heap full");
			return;
		}
		
			if (heapsize==0)
			{heap[0]=key;
			 heapsize++;
			 return;
			}

			//if it reaches here then insertion is possible.
			
			heap[heapsize]=key; //inserted at empty position
			heapsize++;
			
			curr=heapsize-1;
			
			if ((curr-1)/2==0) //if parent is root
			{
				//if curr>root then swap
				if (heap[curr]>heap[(curr-1)/2])
				{
					temp=heap[(curr-1)/2];
					heap[(curr-1)/2]=heap[curr];
					heap[curr]=temp;
					
				}
				
				return; // if this is true then return.
			}
			
			//otherwise the general case will be 
			
			parentin=(curr-1)/2;
			grandin=(parentin-1)/2;
			
			if (heap[parentin]<heap[grandin])
			{
				//then curr should be more, if not swap
				
				if (heap[curr]<heap[parentin])
				{
					//swap
					temp=heap[parentin];
					heap[parentin]=heap[curr];
					heap[curr]=temp;
					
				}
				return;
			}
			
			if (heap[parentin]>heap[grandin])
			{
				//then curr should be less, if not swap
				
				if (heap[curr]>heap[parentin])
				{
					//swap
					temp=heap[parentin];
					heap[parentin]=heap[curr];
					heap[curr]=temp;
					
				}
				return;
			}
	}
	
	public static void showheap(int[] heap)
	{
		for(int i=0;i<heapsize;i++)
			System.out.print(heap[i]+" ");
		System.out.println();
	}
}
