package com.masai.usecases;

import java.util.Formatter;
import java.util.List;
import com.masai.bean.Project;
import com.masai.dao.ProjectDao;
import com.masai.dao.ProjectDaoImpl;

public class ViewAllProjects {

	public static void main() {
		// TODO Auto-generated method stub
		
		ProjectDao pd = new ProjectDaoImpl();
		
		Formatter fmt = new Formatter();
		System.out.println("-------------------------------------------------------------------------------------");
		fmt.format("%22s %30s %22s\n", "|  ProjectId  |","  |  ProjectName  |  ", "  |  Location  |");
		System.out.println(fmt);
		
		
		List<Project> list =  pd.viewAllProjects();
		
//		System.out.println("ProjectNo");
		list.forEach(p->System.out.println(p.forString()));
		System.out.println("---------------------------------------------------------------------------------------");

	}

}
