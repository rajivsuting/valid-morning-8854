package com.masai.usecases;

import java.sql.SQLException;
import java.util.Formatter;
import java.util.List;

import com.masai.bean.GPM;
import com.masai.dao.GPMDao;
import com.masai.dao.GPMDaoImpl;
import com.masai.utility.Console;

public class ViewAllGPM {



	public static void main() throws SQLException {
		// TODO Auto-generated method stub
		
		GPMDao gpa = new GPMDaoImpl();
		List<GPM> gpm = gpa.viewAllGPM();
		Formatter f = new Formatter();
		System.out.println("=========================================================================================");
		f.format("%15s %15s %15s %15s %15s\n", "id" , "name" , "location" , "email" , "password");
		System.out.println(f);
		gpm.forEach(g->System.out.println(g.forString()));
		System.out.println("==================================================================================================================="+Console.RESET);
		
	}
	

	
//	f.format();
//	System.out.println(f);
//	gpm.forEach(g->System.out.println(g.forString()));
//	System.out.println("==================================================================================================================="+Console.RESET);

}
