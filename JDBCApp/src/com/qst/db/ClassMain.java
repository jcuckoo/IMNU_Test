package com.qst.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.qst.dao.CityImpl;
import com.qst.dao.ICityDao;
import com.qst.models.City;

public class ClassMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ICityDao city=new CityImpl();
		DBUtil db=new DBUtil();
//		city.insert(db);
		city.showInfo(db);
//		city.update(db);
//		city.delete(db);
/*		// 连接数据库JDBC的操作
		String Driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/world?useSSL=false&useUnicode=true&characterEncoding=utf-8";
		String user = "root";
		String password = "123456";

		try {
			// 第一步：选择mysql驱动
			Class.forName(Driver);

			// 第二步：创建数据连接
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("成功连接数据库！");

			// 第三步：数据库操作描述Statment对象并给与描述语句,PrepareStatement;
//			Statement st = conn.createStatement();
			String sql = "select * from city where name=? and population=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, "Herat");
			pst.setInt(2, 186800);

			// 第四步：执行查询语句并返回数据集
			// ResultSet rs = st.executeQuery(sql);
			ResultSet rs = pst.executeQuery();
			// System.out.println("成功插入一条数据！");
			// 第五步：使用数据集：
			ResultSetMetaData rsmd = rs.getMetaData();
			int colNum = rsmd.getColumnCount();
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
			System.out.println("关闭数据库！");
		} catch (Exception e) {
			e.printStackTrace();
		}*/

	}

}
