package com.iuh.detai23.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.detai23.entities.KhachHang;
import com.iuh.detai23.repositoties.KhachHangRepository;
import com.iuh.detai23.service.KhachHangService;

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
	public Optional<KhachHang> findById(int id) {
		// TODO Auto-generated method stub
		return khachHangRepository.findById(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
