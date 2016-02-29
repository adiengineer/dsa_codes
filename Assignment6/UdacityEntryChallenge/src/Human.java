
public class Human implements Comparable<Human> 
{
   String name;
   int age;
   
   //behaviour
   
   Human(String name, int age)
   {
	   this.name=name;
	   this.age=age;
   }
   
   public String introduce()
   {
	   
	   return "Hello, My name is "+this.name+" . I am "+this.age+ " years old.";
   }
   
   public int compareTo(Human h)
   {
	 if (this.age<h.age)
		 return -1;
	 
	 if (this.age>h.age)
        return 1;
	 
	 //if equal
	  return 0;
	 
	
   }
}
