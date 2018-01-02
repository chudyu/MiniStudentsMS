package minisystem.students.dao;

import java.util.Collection;

import minisystem.students.model.Student;

public interface IDatabase {

    public void initDB();

	public Student put(Student student);

	public Student getByID(String s);

	public boolean hasID(String id);
	
	public Student removeByID(String id);
	
	public Student update(Student student);
	
	public Collection<Student> getAll();

}
