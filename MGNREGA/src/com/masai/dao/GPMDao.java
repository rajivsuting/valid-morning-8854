package com.masai.dao;

import java.sql.SQLException;
import java.util.List;

import com.masai.bean.GPM;
import com.masai.exception.GPMException;

public interface GPMDao {
	
	public String registerGPM(GPM gpm) throws GPMException, SQLException;
	
	public List<GPM> viewAllGPM() throws SQLException ;

}
