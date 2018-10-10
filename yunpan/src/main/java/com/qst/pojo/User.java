package com.qst.pojo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Administrator
 *
 */
public class User {
	private int id;
	private String userName;
	private String userPwd;
	private String headPic;
	private MultipartFile headPicFile;
	private int sex;
	private Date birthday;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	public MultipartFile getHeadPicFile() {
		return headPicFile;
	}
	public void setHeadPicFile(MultipartFile headPicFile) {
		this.headPicFile = headPicFile;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
