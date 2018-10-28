package com.model;

public class preReq {
	int cid;
	int preReqCid;
	int minMksReq;
	
	public int getMinMksReq() {
		return minMksReq;
	}
	public void setMinMksReq(int minMksReq) {
		this.minMksReq = minMksReq;
	}
	public preReq() {
		super();
		
	}
	
	public preReq(int cid, int preReqCid, int minMksReq) {
		super();
		this.cid = cid;
		this.preReqCid = preReqCid;
		this.minMksReq = minMksReq;
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
		return "preReq [cid=" + cid + ", preReqCid=" + preReqCid + ", minMksReq=" + minMksReq + "]";
	}
	
	
	

	
}
