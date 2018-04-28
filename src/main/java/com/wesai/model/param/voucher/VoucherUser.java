package com.wesai.model.param.voucher;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class VoucherUser {
	
	private int id;                         //流水号
	private String user_id;                   //用户编号
	private String name;                    //用户名称
	private String mobile;                  //用户手机
	private int voucher_id;                 //卡券id
	private int voucher_task_id;            //卡券关联任务id
	private String code_str;                //券吗
	private String code_pwd;                //券密码
	private int status;                     //状态 0 未发放 1 已发放 2 已消费
	private Date update_time;               //更新时间
	private Date get_time;                  //兑换时间
	private Date consume_time;              //消费时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getVoucher_id() {
		return voucher_id;
	}
	public void setVoucher_id(int voucher_id) {
		this.voucher_id = voucher_id;
	}
	public int getVoucher_task_id() {
		return voucher_task_id;
	}
	public void setVoucher_task_id(int voucher_task_id) {
		this.voucher_task_id = voucher_task_id;
	}
	public String getCode_str() {
		return code_str;
	}
	public void setCode_str(String code_str) {
		this.code_str = code_str;
	}
	public String getCode_pwd() {
		return code_pwd;
	}
	public void setCode_pwd(String code_pwd) {
		this.code_pwd = code_pwd;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Date getGet_time() {
		return get_time;
	}
	public void setGet_time(Date get_time) {
		this.get_time = get_time;
	}
	public Date getConsume_time() {
		return consume_time;
	}
	public void setConsume_time(Date consume_time) {
		this.consume_time = consume_time;
	}
}
