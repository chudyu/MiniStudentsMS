package minisystem.students.basic;

public class Test {
	
	public static void main(String[] argvs) {
		
		Database db = new Database();
		db.testStub();
		
		//getByID
		System.out.print("Get student by ID \"1003001\": \t\t");
		Student bStudent = db.getByID("103001");
		if(bStudent != null)
			System.out.println(bStudent.toString());
		
		//put
		System.out.print("Add student using existing ID: \t\t");
		Student s1=new Student("103001", "张三", 22, Gender.Female);
		if(db.put(s1) == null) {
			System.out.println("SUCCEED putting");
		} else {
			System.out.println("FAILED putting: ALREADY EXISTS ID " + s1.getID());
		};
		
		//update
		System.out.print("Update unexist using ID \"103002\": \t");
		s1=new Student("103002", "张三", 29, Gender.Female);
		//db.put(s1);
		//db.removeByID("103002"); //删除后也无法update
		if(db.update(s1) != null) {
			System.out.println("SUCCEED updating");
		} else {
			System.out.println("FAILED updating: ID " + s1.getID() + " NOT EXISTS");
		};
		
		System.out.print("All values: \t" + db.map.values());
		
	}

}
