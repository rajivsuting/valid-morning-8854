package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import com.masai.bean.BDO;
import com.masai.bean.Employee;
import com.masai.bean.GPM;
import com.masai.exception.EmployeeException;
import com.masai.utility.Console;
import com.masai.utility.DBConnection;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String addEmployee(Employee e) throws EmployeeException, SQLException {
		// TODO Auto-generated method stub
String message = "There is some error while adding new Employee " ;
		
		
		try(Connection c = DBConnection.provideConnection()){
			
			PreparedStatement ps = c.prepareStatement("insert into Employee("
					+ "name,address,wages,duty,project_assigned,GPOAssigned)"
					+ "values(?,?,?,?,?,?)");
			
			
			ps.setString(1, e.getName());
			ps.setString(2,e.getAddress());
			ps.setInt(3, e.getWages());
			ps.setInt(4, e.getDuty());
			ps.setInt(5, e.getProjectAssignend());
			ps.setInt(6, e.getGPOAssigned());
			
			
		int update = 	ps.executeUpdate();	
		
		if(update > 0) {
			message = "Employee Added successfully";
		}else {
			throw new EmployeeException(message);
		}
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		
		return message;
	}

	@Override
	public boolean backEndUserCheck(String username, String password) throws SQLException {
		BDO bed = new BDO();
		try(Connection c = DBConnection.provideConnection()){
			
			PreparedStatement ps = c.prepareStatement("select * from BDO where username = ? AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
			String user = 	rs.getString("username");
			String pass = 	rs.getString("password");
				
			bed.setUsername(user);
			bed.setPassword(pass);
			return true ;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			return false;
		}
		
		
		
		
	}


	@Override
	public boolean GPOUserCheck(String username, String password) throws SQLException {
		GPM gpm = new GPM();
		try(Connection c = DBConnection.provideConnection()){
			
			PreparedStatement ps = c.prepareStatement("select * from GPM where email = ? AND password = ?");

			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
			String user = 	rs.getString("email");
			String pass = 	rs.getString("password");
				
			gpm.setName(user);
			gpm.setPassword(pass);
			return true ;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			return false;
		}
		
		
	}

	@Override
	public List<String> viewEmpByProjectName(String proj) throws SQLException {
		List<String> l = new ArrayList<>();
		boolean flag = false ; 

		try(Connection c = DBConnection.provideConnection()){
			
			PreparedStatement ps = c.prepareStatement(" select  e.name ,g.name, e.wages , e.duty  ,e.wages*e.duty as totalWage from project p inner join employee e inner join GPM g on name = ? and e.project_assigned = p.id and e.gpoAssigned = g.id; ;");
			
			ps.setString(1, proj);
			
		 ResultSet rs =	ps.executeQuery();
		 Formatter fmt = new Formatter();  
		
		
		
			 if(rs.next()){
				 
				 fmt.format("%10s %12s %9s %10s %12s\n","EmpName "," GPMName ","EmpWage","EmpDays","TotalWage");
				 while(rs.next()) {
					 	flag = true ; 
						String a = rs.getString("e.name");
						String b = rs.getString("g.name");
						int d = rs.getInt("e.wages");
						int e = rs.getInt("e.duty");
						int f = rs.getInt("totalWage");
						fmt.format("%10s %10s %10s %10s %10s\n", a , b ,d,e,f);
						
						 
					 }
					 System.out.println(fmt+Console.RESET);
			 }else {
				 System.out.println("List is Empty Or there no project by this name");
			 }
		
		 
		}catch(SQLException fd) {
			System.out.println(fd.getMessage());
		}
		
		return l;
	}

	@Override
	public Employee checkEmployee(int id) throws EmployeeException, SQLException {
		// TODO Auto-generated method stub
		Employee em = null;
		
		try(Connection c = DBConnection.provideConnection()){
			
			
			PreparedStatement ps = c.prepareStatement("select * from employee where id = ?");
			
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int idd = rs.getInt("id");
				
				String n = rs.getString("name");
				
				String g = rs.getString("address");
				
				int wage = rs.getInt("wage");
				
				int duty = rs.getInt("duty");
				
				int pa = rs.getInt("project_assigned");
				
				int ga = rs.getInt("GPOAssigned");
				
				em = new Employee(idd, n, g, wage, duty,pa, ga);
				
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return em;
	}

	@Override
	public List<String> checkWageByProject(String projName) throws EmployeeException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String assignProjToEmp(String pname, int Id, String ename, String gname)
			throws EmployeeException, SQLException {
		// TODO Auto-generated method stub
		String message = "Assign failed.." ;
		
		
		try(Connection c = DBConnection.provideConnection()){
			
			PreparedStatement  ps = c.prepareStatement("update employee set project_assigned = (select id from project where name = ?) where id = ? and name = ?");
			PreparedStatement  gs = c.prepareStatement("update employee set GPOAssigned = (select id from GPM where name = ?) where id = ? and name = ?");
			
			ps.setString(1, pname);
			ps.setInt(2, Id);
			ps.setString(3, ename);
			
			gs.setString(1, gname);
			gs.setInt(2, Id);
			gs.setString(3, ename);
			
			int n = ps.executeUpdate();
			int x = gs.executeUpdate();
			
			if(n > 0  && x > 0 ) {
				message = "Updated Successfully";
			}
		}catch(SQLException e) {
			
			System.err.println(e.getMessage());
			
		}
		
		return message;
	}
	



}
