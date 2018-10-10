package com.qst.dao;

import java.sql.SQLException;
import java.util.List;

import com.qst.db.DBUtil;
import com.qst.models.City;

public interface ICityDao {
	public void insert(DBUtil db) throws ClassNotFoundException, SQLException;
	public void update(DBUtil db) throws ClassNotFoundException, SQLException;
	public void delete(DBUtil db) throws ClassNotFoundException, SQLException;
	public List<City> search(DBUtil db);
	public void showInfo(DBUtil db) throws SQLException, ClassNotFoundException;


}
