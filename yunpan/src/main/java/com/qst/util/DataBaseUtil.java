package com.qst.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtil {
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String url="jdbc:mysql://localhost:3306/test";
	String user="root";
	String password="";
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		 // 注册 JDBC 驱动
        Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		conn=DriverManager.getConnection(url, user, password);
		if(conn!=null) {
			return conn;
		}
		return null;
	}
	public int executeUpdate(String sql,Object[] params) {
		int result=0;
		try {
			getConnection();
			pst=conn.prepareStatement(sql);
			if(params!=null&&params.length>0) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i+1, params[i]);
				}
			}
			result=pst.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return result;
	}
	public ResultSet executeQuery(String sql,Object[] params) {
		try {
			getConnection();
			pst=conn.prepareStatement(sql);
			if(params!=null&&params.length>0) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i+1, params[i]);
				}
			}
			rs=pst.executeQuery();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public void closeAll() {
		//释放资源
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pst!=null) {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
