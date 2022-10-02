package com.masai.usecases;

import java.util.Formatter;
import java.util.List;

import com.masai.bean.Project;
import com.masai.dao.ProjectDao;
import com.masai.dao.ProjectDaoImpl;
import com.masai.utility.Console;

public class DisplayAllProjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProjectDao pO = new ProjectDaoImpl();
		
		Formatter fmt = new Formatter();
		System.out.println(Console.BLACK_BOLD+"===========================================================================================");
		fmt.format("%22s %30s %22s\n", "|  ProjectNo  |","  |  ProjectName  |  ", "  |  Location  |");
		System.out.println(fmt);
		
		
		List<Project> list =  pO.viewAllProjects();
		
//		System.out.println("ProjectNo");
		list.forEach(p->System.out.println(p.forString()));
		System.out.println("==========================================================================================="+Console.RESET);

	}

}
