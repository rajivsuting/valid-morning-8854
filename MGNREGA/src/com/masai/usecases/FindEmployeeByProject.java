package com.masai.usecases;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;

public class FindEmployeeByProject {

	public static void main() {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Project Name");
		String x = in.nextLine();
		EmployeeDao pd = new EmployeeDaoImpl();
		
		try {
			List<String> l = pd.viewEmpByProjectName(x);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
