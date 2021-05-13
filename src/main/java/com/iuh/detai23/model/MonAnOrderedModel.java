package com.iuh.detai23.model;

public class MonAnOrderedModel {
	private int maMonAn;
	private String tenMonAn;
	private int soLuong;
	public int getMaMonAn() {
		return maMonAn;
	}
	public void setMaMonAn(int maMonAn) {
		this.maMonAn = maMonAn;
	}
	public String getTenMonAn() {
		return tenMonAn;
	}
	public void setTenMonAn(String tenMonAn) {
		this.tenMonAn = tenMonAn;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public MonAnOrderedModel(int maMonAn, String tenMonAn, int soLuong) {
		super();
		this.maMonAn = maMonAn;
		this.tenMonAn = tenMonAn;
		this.soLuong = soLuong;
	}
	public MonAnOrderedModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
