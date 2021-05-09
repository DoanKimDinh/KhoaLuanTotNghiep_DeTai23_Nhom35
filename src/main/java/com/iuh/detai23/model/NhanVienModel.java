package com.iuh.detai23.model;

import com.iuh.detai23.type.TypeGioiTinh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienModel {
	private String tenNhanVien;
	private String soDienThoai;
	private String email;
	private String chungMinhNhanDan;
	private String diaChi;
	private TypeGioiTinh gioiTinh;
	private String tenTaiKhoan;
	private String matKhau;
	private int maQuyenTruyCap;
}
