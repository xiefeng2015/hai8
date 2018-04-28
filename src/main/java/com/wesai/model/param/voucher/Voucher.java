package com.wesai.model.param.voucher;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Voucher {
	
	private int id;  //卡券id
	private String title;  //卡券名称
	private String inner_title; 
	private int pwd_type;  //卡密类型 1 不带卡密卡券 2 带卡密卡券
	private int bind_account; 
	private String category;
	private int status;
	private Integer amount_type;
	private Integer nominal_amount;
	private int stock;
	private int put_mode;
	private int put_num;
	private int consume_num;
	private int term_type;
	private Date start_time;
	private Date end_time;
	private int fixed_term;
	private int fixed_start_term;
	private Date update_time;
	private Date create_time;
	private String remark;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInner_title() {
		return inner_title;
	}
	public void setInner_title(String inner_title) {
		this.inner_title = inner_title;
	}
	public int getPwd_type() {
		return pwd_type;
	}
	public void setPwd_type(int pwd_type) {
		this.pwd_type = pwd_type;
	}
	public int getBind_account() {
		return bind_account;
	}
	public void setBind_account(int bind_account) {
		this.bind_account = bind_account;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Integer getAmount_type() {
		return amount_type;
	}
	public void setAmount_type(Integer amount_type) {
		this.amount_type = amount_type;
	}
	public Integer getNominal_amount() {
		return nominal_amount;
	}
	public void setNominal_amount(Integer nominal_amount) {
		this.nominal_amount = nominal_amount;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPut_mode() {
		return put_mode;
	}
	public void setPut_mode(int put_mode) {
		this.put_mode = put_mode;
	}
	public int getPut_num() {
		return put_num;
	}
	public void setPut_num(int put_num) {
		this.put_num = put_num;
	}
	public int getConsume_num() {
		return consume_num;
	}
	public void setConsume_num(int consume_num) {
		this.consume_num = consume_num;
	}
	public int getTerm_type() {
		return term_type;
	}
	public void setTerm_type(int term_type) {
		this.term_type = term_type;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public int getFixed_term() {
		return fixed_term;
	}
	public void setFixed_term(int fixed_term) {
		this.fixed_term = fixed_term;
	}
	public int getFixed_start_term() {
		return fixed_start_term;
	}
	public void setFixed_start_term(int fixed_start_term) {
		this.fixed_start_term = fixed_start_term;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}	
