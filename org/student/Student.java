package org.student;

import org.department.Department;

/*Package   :org.student
		Class        :Student
		Methods   :studentName(),studentDept(),studentId()

		Description:
			create above 3 class and call all your class methods into the Student using multilevel inheritance.*/
public class Student extends Department{
	
		public void studentName() {
			System.out.println("studentName : Sandhiya.M");
		}
		public void studentDept() {
			System.out.println("studentDept : ECE");
		}
		public void studentId() {
			System.out.println("studentId : 9876543");
		}
	public static void main(String[] args) {
		
		Student Information=new Student();
		Information.collegeName();
		Information.collegeCode();
		Information.collegeRank();
		Information.deptName();
		Information.studentName();
		Information.studentDept();
		Information.studentId();
		
		
		
	}

}
