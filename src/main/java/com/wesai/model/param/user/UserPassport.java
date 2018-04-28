package com.wesai.model.param.user;

public class UserPassport {
	
	private String name;            // 用户名称
	private long user_id;           // 用户编号
	private int status;             // 用户状态
	private int level;              // 用户级别
	private int sex;                // 用户性别
	private String mobile;          // 用户手机
	private String avatar;          // 用户头像url地址
	private String password_md5;    // md5加密后的密文
	private short created;          // 创建时间戳
	private String last_login_ip;   // 最后登录IP
	private short  last_login_time; // 最后登录时间
	private String reg_referer;     // 注册渠道
	private int is_robot_user;      // 是否机器注册
	private String load_batch_id;   // 导入批次号
	private int passworded;         // 密码是否已更改过
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getPassword_md5() {
		return password_md5;
	}
	public void setPassword_md5(String password_md5) {
		this.password_md5 = password_md5;
	}
	public short getCreated() {
		return created;
	}
	public void setCreated(short created) {
		this.created = created;
	}
	public String getLast_login_ip() {
		return last_login_ip;
	}
	public void setLast_login_ip(String last_login_ip) {
		this.last_login_ip = last_login_ip;
	}
	public short getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(short last_login_time) {
		this.last_login_time = last_login_time;
	}
	public String getReg_referer() {
		return reg_referer;
	}
	public void setReg_referer(String reg_referer) {
		this.reg_referer = reg_referer;
	}
	public int getIs_robot_user() {
		return is_robot_user;
	}
	public void setIs_robot_user(int is_robot_user) {
		this.is_robot_user = is_robot_user;
	}
	public String getLoad_batch_id() {
		return load_batch_id;
	}
	public void setLoad_batch_id(String load_batch_id) {
		this.load_batch_id = load_batch_id;
	}
	public int getPassworded() {
		return passworded;
	}
	public void setPassworded(int passworded) {
		this.passworded = passworded;
	}
}
