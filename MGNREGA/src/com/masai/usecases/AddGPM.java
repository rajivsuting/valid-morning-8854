package com.masai.usecases;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.bean.GPM;
import com.masai.dao.GPMDao;
import com.masai.dao.GPMDaoImpl;
import com.masai.exception.GPMException;

public class AddGPM {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name :");
		String name = sc.next();
		
		System.out.println("Enter Location :");
		String location = sc.next();
		
		System.out.println("Enter email :");
		String email = sc.next();
		
		System.out.println("Enter password :");
		String password = sc.next();
		
		GPMDao gpmd = new GPMDaoImpl();
		
		GPM gpm = new GPM();
		gpm.setName(name);
		gpm.setLocation(location);
		gpm.setEmail(email);
		gpm.setPassword(password);
		
		
		try {
			String res = gpmd.registerGPM(gpm);
			System.out.println(res);
		} catch (GPMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
