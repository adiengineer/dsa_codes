
public class Superhero extends Human 
{
   String alterego;
   
   Superhero(String name,int age,String alterego)
   {
	   super(name, age);
	   this.alterego=alterego;
   }
   
   public String introduce()
   {
	   return super.introduce()+" Don't tell anyone that I am "+this.alterego+"!";
   }
}
