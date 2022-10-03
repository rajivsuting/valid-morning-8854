package com.masai.application;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;
import com.masai.exception.GPMException;
import com.masai.exception.ProjectException;
import com.masai.usecases.AddEmployee;
import com.masai.usecases.AddGPM;
import com.masai.usecases.AddProject;
import com.masai.usecases.AllocateProjectToGPM;
import com.masai.usecases.DisplayEmployee;
import com.masai.usecases.FindEmployeeByProject;
import com.masai.usecases.ViewAllGPM;
import com.masai.usecases.ViewAllProjects;
import com.masai.utility.Console;

public class Main {
	
	public static void main(String[] args) throws SQLException, ProjectException, GPMException, EmployeeException, InputMismatchException {
		int choice = 0 ; 
		Scanner in = new Scanner(System.in); 
		System.out.println();
		System.out.println("-------------Welcome to MGNREGA-----------------");
		System.out.println("      Press 1 to Login as BDO");
		System.out.println("      Press 2 to Login as Gram Panchayat Member" );
		System.out.println("      Press 3 to Login Exit" );
		try {
			
			 choice = in.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Enter Valid Number");
		}
		
		if(choice == 1) {
			System.out.println("Enter UserName/Email");
			String username = in.next();
			
			System.out.println("Enter Password");	
			String password = in.next();
			
			EmployeeDao edao = new EmployeeDaoImpl();
			
			boolean flag = edao.backEndUserCheck(username, password);
			if(flag == false ) {
				
				System.out.println("UserName or Password is wrong please try Again");
				Main.main(args);
				
			}else {
				
				System.out.println("Sucessfully LoggedIn");
			}
			while(flag) {
				if(choice == 1 ) {
					
					boolean flag1 = true ;
					   while(flag1) {
							System.out.println("---------------------------------------------------------------------");
							
							System.out.println("Please Select Queries which you want to Apply ");
							System.out.println("Press 1 to create New Project");
							System.out.println("Press 2 to View all Project");
							System.out.println("Press 3 to Create new GramPanchayat Members");
							System.out.println("Press 4 to View all GramPanchayat Members");
							System.out.println("Press 5 to Allocate Project to GramPanchayatMember");
							//System.out.println("Press 6 to view the list of employee working on Project");
							System.out.println("Press 6 to Go Back to login page");
							System.out.println("Press 7 to Exit");
							System.out.println("---------------------------------------------------------------------");
							
							
							
							
								String BODQ =  in.next();
						
							
							
							
							switch(BODQ) {
								
								case "1" : AddProject.main();
									break ;
								case "2" : ViewAllProjects.main();
									break ;
								case "3" : AddGPM.main(args);
									break ;
								case "4" : ViewAllGPM.main();
									break;
								case "5" : AllocateProjectToGPM.main();
									break ;
//								case "6" : FindEmployeeByProject.main();
//									break;
								case "6" : Main.main(args); 
									break ;
								case "7" : System.exit(0);
							}
							break ; 
						}

					}
				}
		}

		
		else if(choice == 2) {
			System.out.println("Enter Email");
			String username = in.next();
			
			System.out.println("Enter Password");	
			String password = in.next();
			
			EmployeeDao edao = new EmployeeDaoImpl();
			boolean flag =  edao.GPOUserCheck(username, password);
			if(flag == false) {
				System.err.println("UserName or Password is wrong please try Again");
				Main.main(args);
			}else {
				System.out.println("Successfully Logged In ");
			}
			while(flag) {
				
				System.out.println("Press 1 Create Employee");
				System.out.println("Press 2 to View details of employee");
				System.out.println("Press 3 to Assign a project to existing employee");
				System.out.println("Press 4 View total number of days Employee worked in a project and also their wages");
				System.out.println("Press 5 to Go back to login page");
				System.out.println("Press 6 for EXIT");
				String  query = in.next();
				
				switch(query) {
				
				
				case "1" : AddEmployee.main();
						break ;
					case "2" : DisplayEmployee.main();
						break;
					case "4" : FindEmployeeByProject.main();
						break ;
					case "5" : Main.main(args);
						break ;
					case "6" : System.exit(0);
						break;
				}
			}
			
			
		}else if(choice == 3) {
			System.exit(0);
		}else {
			System.err.println("Please enter valid Choice");
			Main.main(args);
		}

	}

}
