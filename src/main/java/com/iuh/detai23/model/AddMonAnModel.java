package com.iuh.detai23.model;

import java.io.Serializable;

public class AddMonAnModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int soLuong;
	private String tenMonAn;

	

	public AddMonAnModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddMonAnModel(int id, int soLuong) {
		super();
		this.id = id;
		this.soLuong = soLuong;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTenMonAn() {
		return tenMonAn;
	}

	public void setTenMonAn(String tenMonAn) {
		this.tenMonAn = tenMonAn;
	}

	
	
}
