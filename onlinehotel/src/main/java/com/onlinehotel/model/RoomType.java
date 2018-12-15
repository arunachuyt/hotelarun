package com.onlinehotel.model;

public class RoomType {

	private int typeid;
	private String type;

	public RoomType() {
		// TODO Auto-generated constructor stub
	}

	public RoomType(int typeid, String type) {
		this.typeid = typeid;
		this.type = type;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "RoomType [typeid=" + typeid + ", type=" + type + "]";
	}
	


}
