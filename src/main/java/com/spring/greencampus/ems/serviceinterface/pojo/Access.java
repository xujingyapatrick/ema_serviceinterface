package com.spring.greencampus.ems.serviceinterface.pojo;

import java.util.Date;



public class Access {
	private long userid;
	private String token;
	private Date expireAt;
	
	public Access() {
	}
	public Access(long userid, String cookie, Date expireAt) {
		super();
		this.userid = userid;
		this.token = cookie;
		this.expireAt = expireAt;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String cookie) {
		this.token = cookie;
	}
	public Date getExpireAt() {
		return expireAt;
	}
	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}
	

}
