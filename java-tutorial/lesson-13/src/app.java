
class Person{
	//classes can contain:
	// 1. Data
	// 2. subroutines (methods)
	
	//instance variables (data or "state")
	
	String name;
	int age;
}


public class app {
	public static void main(String[] args) {
		
		Person person1 = new Person();
		person1.name = "Georg Gross";
		person1.age = 28;
		
		Person person2 = new Person();
		person2.name = "Ute Zumbach";
		person2.age = 55;
		
		System.out.println(person1.age);
		System.out.println(person2.name);
		
		
		
		
	}

}
