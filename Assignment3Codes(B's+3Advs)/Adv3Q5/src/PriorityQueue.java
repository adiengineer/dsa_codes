
public class PriorityQueue 
{
    int minPriority;
    
    Queue mainQ=new Queue();
    Queue extraQ=new Queue();
    
    //behaviuour will have priorityInsert and delete
    
    public void priorityInsert(int a,int priority)
    {
        //if empty just fill in element, set minp and return 
    	if (mainQ.size==0)
         {
        	 mainQ.insert(a,priority); // size will increment.
        	minPriority=priority;
        	return;
         }
    	
    	if (priority<=minPriority)
    	{
    		mainQ.insert(a,priority);
    		minPriority=priority;
    		return;
    	}
    	
    	pElement temp;
    	//oterwise I have to use the other queue.
    	if (priority>minPriority)
    	{
    		
    		while (mainQ.size>0)
    		{
    			temp=mainQ.delete();
    			
    			if (temp.priority>=priority) 
    			{
    				extraQ.insert(temp.data, temp.priority);
    			}
    			
    			else
    			{
    				//pop temp back to mainQ
    				mainQ.insert(temp.data, temp.priority);
    				break;
    			}
    		}
    		
    		extraQ.insert(a,priority); //new element put in position
    		   
    		while (mainQ.size>0)
    		{
    			temp=mainQ.delete();
    		extraQ.insert(temp.data, temp.priority);	
    		}
    		
    		//all elements now in extraQ, put it back to mainQ.
    		
    		while (extraQ.size>0)
    		{
    			temp=extraQ.delete();
    			mainQ.insert(temp.data, temp.priority);
    		}
    	}
    	
    }
    
    public pElement delete()
    {
    	if (mainQ.size<=0)
    		{ System.out.println("Queue is empty");
    		 return null;
    		}
    	
    	return mainQ.delete();
    }
    
    public void showQueue()
    {
    	mainQ.show();
    }
}
