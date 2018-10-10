package com.qst.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import com.qst.db.DBUtil;
import com.qst.models.City;

public class CityImpl implements ICityDao {

	@Override
	public void insert(DBUtil db) throws ClassNotFoundException, SQLException {
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql="insert into city(name,countrycode,district,population) values (?,?,?,?)";
	    PreparedStatement pst = conn.prepareStatement(sql);
	    pst.setString(1,"CLARK");
	    pst.setString(2,"NLD");
	    pst.setString(3,"CLARK");
	    pst.setInt(4,123);
	    pst.executeUpdate();
	    conn.close();
	    pst.close();
	    System.out.println("添加成功！");
	    System.out.println("关闭数据库！");
		

	}


	@Override
	public void update(DBUtil db) throws ClassNotFoundException, SQLException {
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql="update city set name=? where name=?";
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1,"ZZ");
		stm.setString(2,"CLARK");
		stm.executeUpdate();
		conn.close();
		stm.close();
		 System.out.println("修改成功！");
		
	}

	@Override
	public void delete(DBUtil db) throws ClassNotFoundException, SQLException {
		DBUtil dbu = new DBUtil();
		Connection conn = dbu.getConnection();
		String sql="delete from city where name=?";
	    PreparedStatement pst = conn.prepareStatement(sql);
	    pst.setString(1,"ZZ");
	    pst.executeUpdate();
	    conn.close();
	    pst.close();
	    System.out.println("删除成功！");
	    
		

	}

	
	@Override
	public void showInfo(DBUtil db) throws SQLException, ClassNotFoundException {
		DBUtil dbu=new DBUtil();
		Connection conn= dbu.getConnection();
		// 第三步：数据库操作描述Statment对象并给与描述语句,PrepareStatement;
//		Statement st = conn.createStatement();
		String sql = "select * from city where Name like 'ZZ'";
		PreparedStatement pst = conn.prepareStatement(sql);
		//pst.setString(1, "Herat");
		//pst.setInt(2, 186800);

		// 第四步：执行查询语句并返回数据集
		// ResultSet rs = st.executeQuery(sql);
		ResultSet rs = pst.executeQuery();
		// System.out.println("成功插入一条数据！");
		// 第五步：使用数据集：
		ResultSetMetaData rsmd = rs.getMetaData();
		//int colNum = rsmd.getColumnCount();
		System.out.println("序号|名称|国家代码|地区|人口");
		while (rs.next()) {
			City city = new City();//创建实体类，映射到数据库记录

			city.setId(rs.getInt("id"));
			city.setName(rs.getString("name"));
			city.setDistrict(rs.getString("district"));
			city.setPopulation(rs.getInt("population"));
			city.setCountryCode(rs.getString("countrycode"));
			
			
			city.showInfo();//输出City实例里面的所有属性数据

		}

		rs.close();
		// st.close();
		pst.close();
		conn.close();
		
	}

	@Override
	public List<City> search(DBUtil db) {
		// TODO Auto-generated method stub
		return null;
	}

	



}
