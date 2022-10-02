package com.masai.usecases;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.masai.bean.Employee;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;
import com.masai.utility.Console;

public class DisplayEmployee {
	
	public static void main() throws EmployeeException, SQLException {
		
		
		
		try {
			
			Scanner in = new Scanner(System.in);
			
			System.out.println("Enter the Name of Employee");
			String name = in.next();
			
			System.out.println("Enter Employees Id ");
			int id = in.nextInt();
			
			
			EmployeeDao ed = new EmployeeDaoImpl();
			Employee e  = ed.checkEmployee(name, id);
			if(e == null) {
				System.out.println("Employee with name "+name +" and Id "+id+" doesNot Exist");
			}else {
				System.out.println(e+Console.RESET);
			}
		}catch(InputMismatchException ee){
			System.out.println(Console.RED+"Please Id Must be Number"+Console.RESET);
			
		}
	}

}
