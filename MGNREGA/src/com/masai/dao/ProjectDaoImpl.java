package com.masai.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.masai.bean.Project;
import com.masai.exception.ProjectException;
import com.masai.utility.Console;
import com.masai.utility.DBConnection;

public class ProjectDaoImpl implements ProjectDao {

	@Override
	public String addProject(Project p) throws ProjectException, SQLException {
		// TODO Auto-generated method stub
		
		String message = Console.RED+ "Not Inserted !";
		
		try(Connection con = DBConnection.provideConnection()){
			PreparedStatement ps = con.prepareStatement("insert into Project(name,location) values(?,?)");
			
			ps.setString(1, p.getName());
			ps.setString(2, p.getLocation());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = Console.GREEN+ "Project added successfully...";
			}else {
				throw new ProjectException(message);
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String allocateProjectToGPM(String p, String g) throws SQLException {
		// TODO Auto-generated method stub
		String message = Console.RED+"Tasks assignment error !"+Console.RESET ;
		
		try(Connection con = DBConnection.provideConnection()){
			PreparedStatement ps = con.prepareStatement("insert into gpm_pro values("
					+ "(select id from project where name = ?),"
					+ "(select ID from GPM where name = ?));");
			
			ps.setString(1, p);
			ps.setString(2, g);
			
			int update = ps.executeUpdate();
			
			if(update > 0) {
				message = Console.GREEN+"Project " + p + " assigned successfully to " + g + " GP memeber"+Console.RESET;
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println(Console.RED+ e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Project> viewAllProjects() {
		// TODO Auto-generated method stub
		
		List<Project> list = new ArrayList<>();
		
		
		try(Connection con = DBConnection.provideConnection()){
			
			PreparedStatement ps = con.prepareStatement("select * from project");
			
			ResultSet x = ps.executeQuery();
			
			while(x.next()) {
				
				int id = x.getInt("id");
				String name = x.getString("name");
				String loc = x.getString("location");
				
				Project p = new Project(id , name , loc)  ;
				
				list.add(p);
			}
			
			
		}catch(SQLException e) {
			
			System.out.println(Console.RED+e.getMessage()+Console.RESET);
		}
		
		
		return list;
	}
	
	

}
