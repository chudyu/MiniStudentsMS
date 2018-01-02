package minisystem.students.service;

import minisystem.students.dao.Hashmap;
import minisystem.students.dao.IDatabase;
import minisystem.students.model.*;

public class Test {
	
	public static void main(String[] argvs) {
		
		IDatabase db = new Hashmap();
		db.initDB();
        Student s1=new Student("103001", "张三", 19, Gender.Female);
        Student s2=new Student("103005", "李四", 20, Gender.Female);
        db.put(s1);
        db.put(s2);
		
		//getByID
		System.out.print("Get student by ID \"1003001\": \t\t");
		Student bStudent = db.getByID("103001");
		if(bStudent != null)
			System.out.println(bStudent.toString());
		
		//put
		System.out.print("Add student using existing ID: \t\t");
		Student s3=new Student("103001", "张三", 22, Gender.Female);
		if(db.put(s3) == null) {
			System.out.println("SUCCEED putting");
		} else {
			System.out.println("FAILED putting: ALREADY EXISTS ID " + s3.getID());
		};
		
		//update - ID不存在或对象删除后均无法update
		System.out.print("Update unexist using ID \"103002\": \t");
		Student s4=new Student("103002", "张三", 29, Gender.Female);
		if(db.update(s4) != null) {
			System.out.println("SUCCEED updating");
		} else {
			System.out.println("FAILED updating: ID " + s4.getID() + " NOT EXISTS");
		};
		
		System.out.print("All values: \t" + db.getAll());
		
	}

}
