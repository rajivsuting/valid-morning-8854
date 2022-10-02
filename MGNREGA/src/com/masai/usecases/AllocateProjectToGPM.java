package com.masai.usecases;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.bean.Project;
import com.masai.dao.ProjectDao;
import com.masai.dao.ProjectDaoImpl;

public class AllocateProjectToGPM {

	public static void main() {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Name of Project");
		String name = 	in.nextLine();
		
		System.out.println("Enter Name of Grampanchayat Member ");
		String gname = in.nextLine();
		
		ProjectDao pd = new ProjectDaoImpl();
		
		Project p = new Project();
		p.setName(name);
		p.setLocation(gname);
		
		String m;
		try {
			m = pd.allocateProjectToGPM(name, gname);
			System.out.println(m);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
