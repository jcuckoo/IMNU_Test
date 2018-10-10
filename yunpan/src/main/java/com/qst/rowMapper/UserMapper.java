package com.qst.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.qst.pojo.User;

public class UserMapper implements RowMapper<User>{
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=new User();
		user.setId(rs.getInt("id"));
		user.setUserName(rs.getString("userName"));
		user.setUserPwd(rs.getString("userPwd"));
		user.setSex(rs.getInt("sex"));
		return user;
	}

}
