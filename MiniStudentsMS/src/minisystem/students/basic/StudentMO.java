package minisystem.students.basic;

public class StudentMO {
	
	private Database db;
	
	public StudentMO() {
		db = new Database();
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
		for(Student student:db.map.values()) {
			System.out.println(student.toString());
		}
	}
	
//	public static void main(String[] args) {
//		StudentMO mo = new StudentMO();
//		mo.addStudent("104008", "老王", 66, Gender.Male);
//		mo.addStudent("106A16", "小周", 20, Gender.Male);
//		mo.addStudent("106A16", "小周", 20, Gender.Male);
//		mo.listAllStudents();
//	}
}
