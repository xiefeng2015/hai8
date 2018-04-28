package com.wesai.model.param.user;

import org.springframework.stereotype.Component;

@Component
public class AdminPerson {
	
	private String admin_person_id;
	private String name;
	private int gender;
	private String mobile;
	private String user_name;
	private String password;
	private int status;
	private long create_time;
	private long update_time;
	
	public String getAdmin_person_id() {
		return admin_person_id;
	}
	public void setAdmin_person_id(String admin_person_id) {
		this.admin_person_id = admin_person_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getCreate_time() {
		return create_time;
	}
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	public long getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}
}
