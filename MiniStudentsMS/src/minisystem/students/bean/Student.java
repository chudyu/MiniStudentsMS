package minisystem.students.bean;

public class Student {
	
	private String id;
	private String name;
	private int age;
	private Gender gender;
	
	public Student(String id, String name, int i, Gender sex) {
		this.id = id;
		this.name = name;
		this.age = i;
		this.gender = sex;
	}
	
	public Student() {
		
	}
	
	public void setID(String s) {
		this.id = s;
	}
	
	public String getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String s) {
		this.name = s;
	}
	
	public void setAge(int x) {
		if(x>0)
			this.age = x;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setGender(Gender sex) {
		this.gender = sex;
	}
	
	public Gender getGender() {
		return this.gender;
	}
	
	public String toString() {
		return this.id + " " + this.name + " " + this.age + " " + this.gender;
	}

}
