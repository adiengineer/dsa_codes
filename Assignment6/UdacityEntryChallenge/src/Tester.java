import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
public class Tester {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
 // Test your code here:
        
        // Some sample instances
        Superhero batman = new Superhero("Bruce", 26, "Batman");
        Human rachel = new Human("Rachel", 24);
        Superhero wolverine = new Superhero("Logan",40, "Wolverine");
        Superhero spiderman = new Superhero("Peter",23, "Spiderman");
        Human maryjane = new Human("Maryjane",22);
        Human auntmay= new Human("Aunt May",100);
        Human alfred =new Human("Alfred",65);
        // Create some more characters!
  
        
        // Make some introductions
        // Note: Superheroes should also share their alter ego! For example,
       
        // should print to std out:
        // Hey! I'm Bruce and I'm 26 years old. I'm also known as Batman!
        //intros
        
        System.out.println(batman.introduce());
        System.out.println(rachel.introduce());
        System.out.println(wolverine.introduce());
        System.out.println(auntmay.introduce());
        
        
        // Testing your Comparable Interface:
        // Create multiple Humans/Superheros and add them to an ArrayList
        // Example:
        // Superhero ironman = new Superhero("Tony", 35, "Ironman");
        // Human pepper = new Human("Pepper", 22);
        
         List<Human> people = new ArrayList<Human>();
         people.add(batman);
         people.add(rachel);
         people.add(spiderman);
         people.add(auntmay);
        
        // Loop through the list and print out their names.
        // With the above example, you would expect the ordered output
        // Bruce Rachel Tony Pepper
        
         Iterator<Human> i=people.listIterator();
         while(i.hasNext()==true)
         {
        	 System.out.println(i.next().name);
         }
         
         
         
        // Then sort your list (which uses your interface implementation) 
         Collections.sort(people); 
        
        // Print out a list of names, now sorted by age
        // With the above example, the newly sorted output should be
        // Pepper Rachel Bruce Tony
         
         Iterator<Human> k=people.listIterator();
         while(k.hasNext()==true)
         {
        	 System.out.println(k.next().name);
         }
	}

}
