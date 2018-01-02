package minisystem.students.basic;

import java.util.HashMap;

public class Database {

    HashMap<String, Student> map; 
    
    public void initDB(){
    	if(this.map == null) {
    		map=new HashMap<String, Student>();
    	}
    }

	public Student put(Student student) {
		return map.putIfAbsent(student.getID(), student);
	}

	public Student getByID(String s) {
		return map.get(s);
	}

	public boolean hasID(String id) {
		return map.containsKey(id);
	}
	
	public Student removeByID(String id) {
		return map.remove(id);
	}
	
	public Student update(Student student) {
		return map.replace(student.getID(), student);
	}
	
	public void testStub() {
		this.initDB();
        Student s1=new Student("103001", "张三", 19, Gender.Female);
        Student s2=new Student("103005", "李四", 20, Gender.Female);
        map.put(s1.getID(), s1);
        map.put(s2.getID(), s2);
	}

}
