package com.wesai.model.param.voucher;

import org.springframework.stereotype.Component;

import java.util.Date;

/**  
 * CopyRright   (c)2016-2017                 
 * Project:     <微赛卡卷接口测试>                                           
 * Module ID:   <voucher实体对象>     
 * Comments:    <用于封装卡券手动任务列表获取到的实体字段>                                            
 * JDK 版本号:  <JDK1.7>                               
 * Namespace:   com.wesai.lottery.itest.model.param                              
 * Author：     <积德>                  
 * Create Date：<创建日期，2017-05-31>                        
*/
@Component
public class ArtificialList {
	
	private int id;                   //用户关联卡券任务编号
	private String userId;            //用户编号
	private Date createTime;          //发放时间
	private int voucherTaskId;        //卡券任务编号
	private String operater;          //操作人的编号
	private long nominalAmount;       //卡券的面值
	private String mobile;            //用户手机号
	private String operaterName;      //操作人名称
	private int codeStatus;           //卡券的有效状态
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getVoucherTaskId() {
		return voucherTaskId;
	}
	public void setVoucherTaskId(int voucherTaskId) {
		this.voucherTaskId = voucherTaskId;
	}
	public String getOperater() {
		return operater;
	}
	public void setOperater(String operater) {
		this.operater = operater;
	}
	public long getNominalAmount() {
		return nominalAmount;
	}
	public void setNominalAmount(long nominalAmount) {
		this.nominalAmount = nominalAmount;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOperaterName() {
		return operaterName;
	}
	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}
	public int getCodeStatus() {
		return codeStatus;
	}
	public void setCodeStatus(int codeStatus) {
		this.codeStatus = codeStatus;
	}
}
