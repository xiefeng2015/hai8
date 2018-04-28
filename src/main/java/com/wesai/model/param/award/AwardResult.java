package com.wesai.model.param.award;

import org.springframework.stereotype.Component;

@Component
public class AwardResult {
	
	private int otherWinStatus;     //第三方中奖状态， 默认为 3, 3：待开奖， 4：未中奖，5：中奖  6 异常票
	private int wsWinStatus;        //微赛中奖状态， 默认为 3, 3：待开奖， 4：未中奖，5：中奖   6 异常票
	private int otherAwardStatus;   //第三方开奖状态， 默认为 0, 待开奖  1 已开奖
	private int wsAwardStatus;      //微赛开奖状态， 默认为 0, 待开奖  1 已开奖 2 异常
	private int compareAwardResult; //开奖对比结果， 默认为 0, 0 未对比 1 对比一致 2 对比异常 3 异常待处理 4 异常处理成功 5  异常处理失败
	private int sendAwardType;      //派奖类型： 1 以第三为准 2 对比派奖 3 结果优先派奖
	
	public int getOtherWinStatus() {
		return otherWinStatus;
	}
	public void setOtherWinStatus(int otherWinStatus) {
		this.otherWinStatus = otherWinStatus;
	}
	public int getWsWinStatus() {
		return wsWinStatus;
	}
	public void setWsWinStatus(int wsWinStatus) {
		this.wsWinStatus = wsWinStatus;
	}
	public int getOtherAwardStatus() {
		return otherAwardStatus;
	}
	public void setOtherAwardStatus(int otherAwardStatus) {
		this.otherAwardStatus = otherAwardStatus;
	}
	public int getWsAwardStatus() {
		return wsAwardStatus;
	}
	public void setWsAwardStatus(int wsAwardStatus) {
		this.wsAwardStatus = wsAwardStatus;
	}
	public int getCompareAwardResult() {
		return compareAwardResult;
	}
	public void setCompareAwardResult(int compareAwardResult) {
		this.compareAwardResult = compareAwardResult;
	}
	public int getSendAwardType() {
		return sendAwardType;
	}
	public void setSendAwardType(int sendAwardType) {
		this.sendAwardType = sendAwardType;
	}
}
