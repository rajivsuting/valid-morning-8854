package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.GPM;
import com.masai.utility.DBConnection;

public class GPMDaoImpl implements GPMDao {

	@Override
	public String registerGPM(GPM gpm) {
		
		String message = "Not Inserted !";
		
		try(Connection con = DBConnection.provideConnection()){
			PreparedStatement ps = con.prepareStatement("insert into GPM(name,location,email,password) values(?,?,?,?)");
			
			ps.setString(1, gpm.getName());
			ps.setString(2, gpm.getLocation());
			ps.setString(3, gpm.getEmail());
			ps.setString(4, gpm.getPassword());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Gram Panchayat Member added successfully...";
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public List<GPM> viewAllGPM() throws SQLException {
		// TODO Auto-generated method stub
		List<GPM> list = new ArrayList<>();
		
		
		try(Connection c = DBConnection.provideConnection()){
			
			PreparedStatement ps = c.prepareStatement("select * from grampanchayatmember");
			
			ResultSet rs =  ps.executeQuery();
			
			
			while(rs.next()) {
				
				int id = rs.getInt("ID");
				String name = rs.getString("Gname");
				String loc = rs.getString("Location");
				String usr = rs.getString("username");
				String pass = rs.getString("password");
				
				list.add(new GPM(id, name, loc, usr, pass));
				
			}
			
		}catch(SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		return list;
	}



}
