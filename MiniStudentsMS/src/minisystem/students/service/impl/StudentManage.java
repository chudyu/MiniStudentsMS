package minisystem.students.service.impl;

import minisystem.students.bean.*;
import minisystem.students.dao.Hashmap;
import minisystem.students.dao.IDatabase;
import minisystem.students.service.IStudentManage;

public class StudentManage implements IStudentManage {
	
	private IDatabase db;
	
	public StudentManage() {
		db = new Hashmap();
		db.initDB();
	}
	
	/* (non-Javadoc)
	 * @see minisystem.students.service.IStudentManage#addStudent(java.lang.String, java.lang.String, int, minisystem.students.bean.Gender)
	 */
	@Override
	public void addStudent(String id, String name, int age, Gender gender) {
		Student student = new Student(id, name, age, gender);
		if(db.put(student) == null) {
			System.out.println("Adding: SUCCEED");
		} else {
			System.out.println("Adding: FAILED - Already exists ID " + student.getID());
		}
	}
	
	/* (non-Javadoc)
	 * @see minisystem.students.service.IStudentManage#addStudent(minisystem.students.bean.Student)
	 */
	@Override
	public void addStudent(Student student) {
		addStudent(student.getID(), student.getName(), student.getAge(), student.getGender());
	}
	
	/* (non-Javadoc)
	 * @see minisystem.students.service.IStudentManage#updateStudent(java.lang.String, java.lang.String, int, minisystem.students.bean.Gender)
	 */
	@Override
	public void updateStudent(String id, String name, int age, Gender gender) {
		Student student = new Student(id, name, age, gender);
		if(db.update(student) != null) { //previous student object returned
			System.out.println("Updating: SUCCEED");
		} else {
			System.out.println("Updating: FAILED - Given ID does NOT exist");
		}
	}
	
	/* (non-Javadoc)
	 * @see minisystem.students.service.IStudentManage#updateStudent(minisystem.students.bean.Student)
	 */
	@Override
	public void updateStudent(Student student) {
		updateStudent(student.getID(), student.getName(), student.getAge(), student.getGender());
	}
	
	/* (non-Javadoc)
	 * @see minisystem.students.service.IStudentManage#getStudentInfoByID(java.lang.String)
	 */
	@Override
	public String getStudentInfoByID(String id){
		Student student = db.getByID(id);
		if(student != null) {
			return student.toString();
		} else {
			return null; // Given ID does NOT exist
		}
	}
	
	/* (non-Javadoc)
	 * @see minisystem.students.service.IStudentManage#removeStudentByID(java.lang.String)
	 */
	@Override
	public void removeStudentByID(String id){
		if(db.removeByID(id) != null) { //previous student object returned
			System.out.println("Removing: SUCCEED");
		} else {
			System.out.println("Removing: FAILED - Given ID does NOT exist");
		}
	}
	
	/* (non-Javadoc)
	 * @see minisystem.students.service.IStudentManage#listAllStudents()
	 */
	@Override
	public void listAllStudents(){
		for(Student student:db.getAll()) {
			System.out.println(student.toString());
		}
	}
	
}
