package minisystem.students.service;

import minisystem.students.bean.Gender;
import minisystem.students.bean.Student;

public interface IStudentManage {

	void addStudent(String id, String name, int age, Gender gender);

	void addStudent(Student student);

	void updateStudent(String id, String name, int age, Gender gender);

	void updateStudent(Student student);

	String getStudentInfoByID(String id);

	void removeStudentByID(String id);

	void listAllStudents();

}