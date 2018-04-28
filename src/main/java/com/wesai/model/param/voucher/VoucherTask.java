package com.wesai.model.param.voucher;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class VoucherTask {
	
	private int id;
	private String title;
	private int stock;
	private int put_num;
	private Date start_time;
	private Date end_time;
	private int triger_mode;
	private Date update_time;
	private Date create_time;
	private int status;
	private String bind_user_id;
	private String operater;
	private int has_black;
	private String channel_id;
	
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPut_num() {
		return put_num;
	}
	public void setPut_num(int put_num) {
		this.put_num = put_num;
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
	public int getTriger_mode() {
		return triger_mode;
	}
	public void setTriger_mode(int triger_mode) {
		this.triger_mode = triger_mode;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getBind_user_id() {
		return bind_user_id;
	}
	public void setBind_user_id(String bind_user_id) {
		this.bind_user_id = bind_user_id;
	}
	public String getOperater() {
		return operater;
	}
	public void setOperater(String operater) {
		this.operater = operater;
	}
	public int getHas_black() {
		return has_black;
	}
	public void setHas_black(int has_black) {
		this.has_black = has_black;
	}
	public String getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(String channel_id) {
		this.channel_id = channel_id;
	}
}
