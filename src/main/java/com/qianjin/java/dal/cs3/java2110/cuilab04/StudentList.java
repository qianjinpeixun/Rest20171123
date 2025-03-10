package com.qianjin.java.dal.cs3.java2110.cuilab04;

public class StudentList {
	private List<Student> students;
	public StudentList(){
		students = new List<Student>();
	}
	public void add(Student stu){
		students.add(stu);
	}
	public void addToEnd(Student stu){
		students.addToEnd(stu);
	}
	public void remove(Student stu){
		students.remove(stu);
	}	
	public void displayMajor(){
		Student stu = students.first();
		while(stu != null){
			System.out.println(stu.getMajor());
			stu = students.next();
		}
	}
	public void displayFaculty(){
		Student stu = students.first();
		while(stu != null){
			System.out.println(stu.getFaculty());
			stu = students.next();
		}
	}
	public void searchID(int id){
		Student stu = students.first();
		int num = students.first().getStudentID();
		while(stu != null){
			if(num == id){
				stu.toString();
				return;
			}
			num = students.next().getStudentID();
			stu = students.next();
		}
		System.out.println("Cannot find this StudentID");
	}
	public void searchEmail(String email){
		Student stu = students.first();
		while(stu != null){
			if(stu.getEmail().equals(email)){
				System.out.println(stu.toString());
				return;
			}
			stu = students.next();
		}
		System.out.println("Cannot find this email");
	}
	public void searchName(String first, String last){
		Student stu = students.first();
		while(stu != null){
			if(stu.getFirstName().equals(first) && stu.getLastName().equals(last)){
				System.out.println(stu.toString());
				return;
			}
			stu = students.next();
		}
		System.out.println("Cannot find this first and last name");
	}
	public Student first(){
		return students.first();
	}
	public Student next(){
		return students.next();
	}
	public void enumerate(){
		students.enumerate();
	}
}	
		
		