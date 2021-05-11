package com.iuh.detai23.service;

import java.util.List;
import java.util.Optional;

import com.iuh.detai23.entities.KhachHang;
import com.iuh.detai23.model.DangNhapModel;

public interface KhachHangService {
	public KhachHang save(KhachHang khachHang);
	public List<KhachHang> findAll();
	public KhachHang findById(int id);
	public void delete(int id);
	public boolean checkDangNhap(DangNhapModel dangNhapModel);
	public KhachHang getKhachHangByAccount(String tenTaiKhoan);
}
