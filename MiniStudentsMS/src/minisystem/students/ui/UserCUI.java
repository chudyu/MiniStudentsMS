package minisystem.students.ui;

import java.util.Scanner;

import minisystem.students.pojo.Gender;
import minisystem.students.pojo.Student;
import minisystem.students.service.*;

public class UserCUI {

	static Scanner scanner = new Scanner(System.in);
	static StudentManage smo = null;

	public static void init() {

		smo = new StudentManage();

		// test
		Student s1 = new Student("103001", "张三", 19, Gender.Female);
		UserCUI.smo.addStudent(s1);
		s1 = new Student("103002", "李四", 20, Gender.Female);
		UserCUI.smo.addStudent(s1);
		s1 = new Student("103016", "小周", 20, Gender.Female);
		UserCUI.smo.addStudent(s1);
		s1 = new Student("103033", "大刘", 20, Gender.Female);
		UserCUI.smo.addStudent(s1);

		// int commandCount = 6;
		// String[] commands = {"AddS", "RemoveS", "SearchS", "UpdateS"}; //表驱动+反射机制
		// 好像有点困难
		// Class clazz = this.getClass();
		// Method method = null;
		// try {
		// method = clazz.getDeclaredMethod(commands[0]);
		// } catch (NoSuchMethodException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (SecurityException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// method.invoke(clazz);
		// } catch (IllegalAccessException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IllegalArgumentException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (InvocationTargetException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		while (true) {
			System.out.println("----------- Mini Student Management System -----------");
			System.out.println("1. Add Student");
			System.out.println("2. Remove Student");
			System.out.println("3. Search Student");
			System.out.println("4. Update Student Information");
			System.out.println("5. List All Student");
			System.out.println("0. Quit");
			System.out.println("Please input command Nubmer: ");

			// using String instead of int to avoid exception caused by char input
			String input = scanner.next();
			switch (input) {
			case "0":
				System.out.println(" -- Now Quit. --");
				System.exit(0);
				break;

			case "1":
				AddS();
				break;

			case "2":
				RemoveS();
				break;

			case "3":
				SearchS();
				break;

			case "4":
				UpdateS();
				break;

			case "5":
				ListAllS();
				break;

			default:
				System.out.println("\nInvalid Input.");
				break;
			}
		}
	}

	public static Student getInputStudent() {
		System.out.print("Please input student's ID: ");
		String id = scanner.next();
		System.out.print("Please input student's name: ");
		String name = scanner.next();

		int age = -1;
		while (age < 0 || age > 140) { // if input is string, age is zero
			System.out.print("Please input student's age: ");
			try {
				age = scanner.nextInt();
			} catch (Exception e) {
				scanner.next(); // 清空buffer，必不可少，否则进入前面while的死循环。
				System.out.print("Invalid Input. ");
				// 关于Scanner调用nextInt()异常try后不能二次输入问题
				// http://blog.csdn.net/fanssss/article/details/52020201
			}
		}
		System.out.print("Please input student's gender: ");
		String gen = null;
		Gender gender = null;
		while (gender == null) {
			gen = scanner.next().toLowerCase();
			if (gen.equals("male") || gen.equals("m")) { // 用==不对
				gender = Gender.Male;
			} else {
				if (gen.equals("Female") || gen.equals("f")) {
					gender = Gender.Female;
				} else {
					System.out.print("Invalid Input. Please intput student's gender: ");
				}
			}
		}
		Student student = new Student(id, name, age, gender);
		return student;
	}

	public static void AddS() {
		Student student = getInputStudent();
		smo.addStudent(student);
	}

	private static void RemoveS() {
		System.out.print("Please input student's ID: ");
		String id = scanner.next();
		smo.removeStudentByID(id);
	}

	private static void SearchS() {
		System.out.print("Please input student's ID: ");
		String id = scanner.next();
		String result = smo.getStudentInfoByID(id);
		if (result == null) {
			System.out.println("Search: FAILED - Given ID doesn't exist");
		} else {
			System.out.println(result);
		}
	}

	private static void UpdateS() {
		Student student = getInputStudent();
		smo.updateStudent(student);
	}

	private static void ListAllS() {
		System.out.println(" -- All Students Information: --");
		smo.listAllStudents();
		System.out.println(" -- Done. --");
	}

}
