package com.iuh.detai23.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietHoaDonModel {
	private String ngayLapHoaDon;
	private String tenKhachHang;
	private String diaChiEmail;
	private String sdt;
	private String diaChi;
	
	private List<ChiTietMonAnModel> chiTiet;

}
