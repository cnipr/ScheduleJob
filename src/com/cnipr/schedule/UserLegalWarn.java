package com.cnipr.schedule;

import java.util.Date;

public class UserLegalWarn {

	private String uuid;
	
	private String username;
	
	private String title;
	
	private Date createTime;
	
	private Date latestPubDate;
	
	private String strWhere;
	
	private String strSources;
	
	private int state;
	
	private String ans;
	
	private int trsCount;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLatestPubDate() {
		return latestPubDate;
	}

	public void setLatestPubDate(Date latestPubDate) {
		this.latestPubDate = latestPubDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStrWhere() {
		return strWhere;
	}

	public void setStrWhere(String strWhere) {
		this.strWhere = strWhere;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public String getStrSources() {
		return strSources;
	}

	public void setStrSources(String strSources) {
		this.strSources = strSources;
	}

	public int getTrsCount() {
		return trsCount;
	}

	public void setTrsCount(int trsCount) {
		this.trsCount = trsCount;
	}
}
