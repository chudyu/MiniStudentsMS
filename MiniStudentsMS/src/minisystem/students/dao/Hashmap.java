package minisystem.students.dao;

import java.util.Collection;
import java.util.HashMap;

import minisystem.students.model.Student;

public class Hashmap implements IDatabase {

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
	
	public Collection<Student> getAll() {
		return map.values();
	}

}
