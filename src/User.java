
public class User {
	String name;
	int age;
	String hobby;
	
	public User(String n, int a, String h) {
		name = n;
		age = a;
		hobby = h;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getHobby() {
		return hobby;
	}
}
