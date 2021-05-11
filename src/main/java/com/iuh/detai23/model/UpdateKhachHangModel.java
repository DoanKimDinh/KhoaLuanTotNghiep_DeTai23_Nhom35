package com.iuh.detai23.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateKhachHangModel {
	private int maKhachHang;  
	private String tenKhachHang;  
	private String sdt;  
	private String email;  
	private String tenTaiKhoan;  
	private String matKhau;  
	private String diaChi; 
	private int maQuyenTruyCap;
}
