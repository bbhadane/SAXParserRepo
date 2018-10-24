package com.model;

public class preReq {
	int cid;
	int preReqCid;
	
	
	public preReq() {
		super();
		
	}
	public preReq(int cid, int preReqCid) {
		super();
		this.cid = cid;
		this.preReqCid = preReqCid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPreReqCid() {
		return preReqCid;
	}
	public void setPreReqCid(int preReqCid) {
		this.preReqCid = preReqCid;
	}
	@Override
	public String toString() {
		return "preReq [cid=" + cid + ", preReqCid=" + preReqCid + "]";
	}
	
	

	
}
