package com.spritle.model;

public class Task {
	private int id;
	private int mid;
	private int sid;
	private String fn;
	private String sn;
	private String opreation;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getOpreation() {
		return opreation;
	}

	public void setOpreation(String opreation) {
		this.opreation = opreation;
	}

	

	public Task(int mid, int sid, String fn, String sn, String opreation) {
		super();
		this.mid = mid;
		this.sid = sid;
		this.fn = fn;
		this.sn = sn;
		this.opreation = opreation;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(int id, int mid, int sid, String fn, String sn, String opreation) {
		super();
		this.id = id;
		this.mid = mid;
		this.sid = sid;
		this.fn = fn;
		this.sn = sn;
		this.opreation = opreation;
	}
}
