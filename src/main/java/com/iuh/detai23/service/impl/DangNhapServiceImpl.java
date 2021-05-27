package com.iuh.detai23.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.detai23.entities.KhachHang;
import com.iuh.detai23.entities.NhanVien;
import com.iuh.detai23.model.DangNhapModel;
import com.iuh.detai23.repositoties.KhachHangRepository;
import com.iuh.detai23.repositoties.NhanVienRepository;
import com.iuh.detai23.service.DangNhapService;

@Service
public class DangNhapServiceImpl implements DangNhapService{
	
	@Autowired
	private KhachHangRepository khachHangRepository;
	
	@Autowired
	private NhanVienRepository nhanVienRepository;
	
	@Override
	public int checkUserDangNhap(DangNhapModel dangNhapModel) {
		// TODO Auto-generated method stub
		List<KhachHang> listKhachHang = new ArrayList<KhachHang>(); 
		listKhachHang = khachHangRepository.findAll();
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		listNhanVien = nhanVienRepository.findAll();
		for(KhachHang kh : listKhachHang) {
			if(kh.getTenTaiKhoan().equals(dangNhapModel.getTenDangNhap())&& kh.getMatKhau().equals(dangNhapModel.getMatKhau()) && kh.getQuyenTruyCap().getMaQuyenTruyCap()==1){
				return 1;
			}
		}
		for(NhanVien nv : listNhanVien) {
			if(nv.getTenTaiKhoan().equals(dangNhapModel.getTenDangNhap()) && nv.getMatKhau().equals(dangNhapModel.getMatKhau()) && nv.getQuyenTruyCap().getMaQuyenTruyCap() == 2){
				return 2;
			}
			else if(nv.getTenTaiKhoan().equals(dangNhapModel.getTenDangNhap()) && nv.getMatKhau().equals(dangNhapModel.getMatKhau()) && nv.getQuyenTruyCap().getMaQuyenTruyCap() == 3){
				return 3;
			}
		}
		return 0;
	}

	@Override
	public KhachHang getKhachHangByTenTaiKhoan(String tenTaiKhoan) {
		// TODO Auto-generated method stub
		List<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		listKhachHang = khachHangRepository.findAll();
		for(KhachHang khachHang : listKhachHang) {
			if(khachHang.getTenTaiKhoan().equals(tenTaiKhoan)) {
				return khachHang;
			}
		}
		return null;
	}

	@Override
	public NhanVien getNhanVienByTenTaiKhoan(String tenTaiKhoan) {
		// TODO Auto-generated method stub
		List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
		listNhanVien = nhanVienRepository.findAll();
		for(NhanVien nhanVien : listNhanVien) {
			if(nhanVien.getTenTaiKhoan().equals(tenTaiKhoan)) {
				return nhanVien;
			}
		}
		return null;
	}

}
