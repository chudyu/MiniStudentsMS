package minisystem.students.service;

import minisystem.students.bean.*;
import minisystem.students.dao.Hashmap;
import minisystem.students.dao.IDatabase;

public class StudentManage {
	
	private IDatabase db;
	
	public StudentManage() {
		db = new Hashmap();
		db.initDB();
	}
	
	public void addStudent(String id, String name, int age, Gender gender) {
		Student student = new Student(id, name, age, gender);
		if(db.put(student) == null) {
			System.out.println("Adding: SUCCEED");
		} else {
			System.out.println("Adding: FAILED - Already exists ID " + student.getID());
		}
	}
	
	public void addStudent(Student student) {
		addStudent(student.getID(), student.getName(), student.getAge(), student.getGender());
	}
	
	public void updateStudent(String id, String name, int age, Gender gender) {
		Student student = new Student(id, name, age, gender);
		if(db.update(student) != null) { //previous student object returned
			System.out.println("Updating: SUCCEED");
		} else {
			System.out.println("Updating: FAILED - Given ID does NOT exist");
		}
	}
	
	public void updateStudent(Student student) {
		updateStudent(student.getID(), student.getName(), student.getAge(), student.getGender());
	}
	
	public String getStudentInfoByID(String id){
		Student student = db.getByID(id);
		if(student != null) {
			return student.toString();
		} else {
			return null; // Given ID does NOT exist
		}
	}
	
	public void removeStudentByID(String id){
		if(db.removeByID(id) != null) { //previous student object returned
			System.out.println("Removing: SUCCEED");
		} else {
			System.out.println("Removing: FAILED - Given ID does NOT exist");
		}
	}
	
	public void listAllStudents(){
		for(Student student:db.getAll()) {
			System.out.println(student.toString());
		}
	}
	
}
