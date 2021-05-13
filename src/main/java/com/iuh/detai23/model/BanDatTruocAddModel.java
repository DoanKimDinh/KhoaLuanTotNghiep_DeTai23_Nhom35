package com.iuh.detai23.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BanDatTruocAddModel {
	private int soNguoi; 
	private String ngayDen; 
	private String thoiGianDen; 
	
	private String ghiChu;
	
	private String tenKhachHang;
	private String email;
	private String phone;
	private String diaChi; 
}