package com.iuh.detai23.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BanDatTruocAddModel {
	private String ngayDen; 
	private String thoiGianDen; 
	private int soNguoi; 
	private String ghiChu;
	private String diaChi; 
}
