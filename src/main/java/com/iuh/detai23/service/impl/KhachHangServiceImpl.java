package com.iuh.detai23.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.detai23.entities.KhachHang;
import com.iuh.detai23.repositoties.KhachHangRepository;
import com.iuh.detai23.service.KhachHangService;
import com.iuh.detai23.model.DangNhapModel;

@Service
public class KhachHangServiceImpl implements KhachHangService{

	@Autowired
	private KhachHangRepository khachHangRepository;
	
	@Override
	public KhachHang save(KhachHang khachHang) {
		// TODO Auto-generated method stub
		return khachHangRepository.save(khachHang);
	}

	@Override
	public List<KhachHang> findAll() {
		// TODO Auto-generated method stub
		return khachHangRepository.findAll();
	}

	@Override
	public KhachHang findById(int id) {
		// TODO Auto-generated method stub
		return khachHangRepository.getOne(Integer.valueOf(id));
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkDangNhap(DangNhapModel dangNhapModel) {
		List<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		listKhachHang = khachHangRepository.findAll();
		for (KhachHang khachHang : listKhachHang) {
			if(khachHang.getTenTaiKhoan().equals(dangNhapModel.getTenDangNhap())&&khachHang.getMatKhau().equals(dangNhapModel.getMatKhau())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public KhachHang getKhachHangByAccount(String tenTaiKhoan) {
		// TODO Auto-generated method stub
		List<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		listKhachHang = khachHangRepository.findAll();
		for (KhachHang khachHang : listKhachHang) {
			if(khachHang.getTenTaiKhoan().equals(tenTaiKhoan)) {
				return khachHang;
			}
		}
		return null;
	}

	@Override
	public KhachHang getKhachHangByEmail(String email) {
		// TODO Auto-generated method stub
		List<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		listKhachHang = khachHangRepository.findAll();
		for (KhachHang khachHang : listKhachHang) {
			if(khachHang.getEmail().equals(email)) {
				return khachHang;
			}
		}
		return null;
	}

	@Override
	public KhachHang getKhachHangBySDT(String sdt) {
		// TODO Auto-generated method stub
		List<KhachHang> listKhachHang = new ArrayList<KhachHang>();
		listKhachHang = khachHangRepository.findAll();
		for (KhachHang khachHang : listKhachHang) {
			if(khachHang.getSdt().equals(sdt)) {
				return khachHang;
			}
		}		
		return null;
	}

}
