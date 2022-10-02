package com.masai.usecases;

import java.sql.SQLException;
import java.util.Scanner;
import com.masai.bean.Project;
import com.masai.dao.ProjectDao;
import com.masai.dao.ProjectDaoImpl;
import com.masai.exception.ProjectException;

public class AddProject {

	public static void main() {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Name of Project");
		String name = 	in.nextLine();
		
		System.out.println("Enter Location Project ");
		String loc = in.nextLine();
		

		
		ProjectDao pd = new ProjectDaoImpl();
		
		Project p = new Project();
		p.setName(name);
		p.setLocation(loc);
		
		String message;
		try {
			message = pd.addProject(p);
			System.out.println(message);
		} catch (ProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
