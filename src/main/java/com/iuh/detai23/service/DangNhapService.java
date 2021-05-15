package com.iuh.detai23.service;

import com.iuh.detai23.entities.KhachHang;
import com.iuh.detai23.entities.NhanVien;
import com.iuh.detai23.model.DangNhapModel;

public interface DangNhapService {
	public int checkUserDangNhap(DangNhapModel dangNhapModel);
	public KhachHang getKhachHangByTenTaiKhoan(String tenTaiKhoan);
	public NhanVien getNhanVienByTenTaiKhoan(String tenTaiKhoan);
}
