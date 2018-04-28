package com.wesai.model.param.voucher;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class VoucherCodeBind {
	
	private int id;                      //绑定卡券的id
	private int batch_id;                //批次id
	private int voucher_id;              //卡券id
	private int voucher_task_id;         //卡券关联任务id
	private int task_user_log_id;        //用户触发任务规则ID
	private String user_id;              //用户id
	private String code_str;             //券吗
	private String code_pwd;             //券密码
	private int status;                  //状态 0 未发放 1 已发放 2 已消费
	private Date update_time;            //更新时间
	private Date get_time;               //兑换时间
	private Date consume_time;           //消费时间
	private String source_type;          //消费类型
	private int source_id;               //资源id
	private Integer nominal_amount;      //资源面值
	private Integer amount_type;         //卡券额度类型
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
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
	public int getTask_user_log_id() {
		return task_user_log_id;
	}
	public void setTask_user_log_id(int task_user_log_id) {
		this.task_user_log_id = task_user_log_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public String getSource_type() {
		return source_type;
	}
	public void setSource_type(String source_type) {
		this.source_type = source_type;
	}
	public int getSource_id() {
		return source_id;
	}
	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}
	public Integer getNominal_amount() {
		return nominal_amount;
	}
	public void setNominal_amount(Integer nominal_amount) {
		this.nominal_amount = nominal_amount;
	}
	public Integer getAmount_type() {
		return amount_type;
	}
	public void setAmount_type(Integer amount_type) {
		this.amount_type = amount_type;
	}
	@Override
	public String toString() {
		return "VoucherCodeBind [id=" + id + ", batch_id=" + batch_id
				+ ", voucher_id=" + voucher_id + ", voucher_task_id="
				+ voucher_task_id + ", task_user_log_id=" + task_user_log_id
				+ ", user_id=" + user_id + ", code_str=" + code_str
				+ ", code_pwd=" + code_pwd + ", status=" + status
				+ ", update_time=" + update_time + ", get_time=" + get_time
				+ ", consume_time=" + consume_time + ", source_type="
				+ source_type + ", source_id=" + source_id
				+ ", nominal_amount=" + nominal_amount + ", amount_type="
				+ amount_type + "]";
	}
}
