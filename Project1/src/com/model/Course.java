package com.model;

public class Course {
	private int cid,cduration;
	private String cname;
	private int cfees;
	
	public Course(int cid, String cname, int cduration, int cfees) {
		super();
		this.cid = cid;
		this.cduration = cduration;
		this.cname = cname;
		this.cfees = cfees;
	}

	public Course() {
		super();
	}
	
	
	
	public int getCfees() {
		return cfees;
	}

	public void setCfees(int cfees) {
		this.cfees = cfees;
	}

	public Course(int cid) {
		super();
		this.cid = cid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCduration() {
		return cduration;
	}

	public void setCduration(int cduration) {
		this.cduration = cduration;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cduration=" + cduration + ", cname=" + cname + ", cfees=" + cfees + "]";
	}

	
	
	
}
