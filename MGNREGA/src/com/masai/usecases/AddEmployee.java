package com.masai.usecases;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.bean.Employee;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;

public class AddEmployee {

	public static void main() {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		
		
		System.out.println("Enter Name");
		String ename = 	in.nextLine();
		
		System.out.println("Enter address");
		String add = in.nextLine();
		
		
		System.out.println("EnterGPO id");
		int x =	in.nextInt();

		
		System.out.println("Enter Project id");		
		int pr = in.nextInt();
		
		System.out.println("Enter wage of Employee per day");
		int wage = in.nextInt();
		
		System.out.println("Enter number of days Employee worked");
		int day = in.nextInt();
		
		
		
	
		
		EmployeeDao ed = new EmployeeDaoImpl();
		
		Employee e = new Employee();
		e.setName(ename);
		e.setAddress(add);
		e.setDuty(day);
		e.setGPOAssigned(x);
		e.setProjectAssignend(pr);
		e.setWages(wage);
		
		String m;
		try {
			m = ed.addEmployee(e);
			System.out.println(m);
		} catch (EmployeeException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		
		

	}

}
