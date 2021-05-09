package com.iuh.detai23.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.detai23.entities.NhanVien;
import com.iuh.detai23.repositoties.NhanVienRepository;
import com.iuh.detai23.service.NhanVienService;

@Service
public class NhanVienServiceImpl implements NhanVienService{

	@Autowired
	private NhanVienRepository nhanVienRepository;
	
	@Override
	public NhanVien save(NhanVien nhanVien) {
		// TODO Auto-generated method stub
		return nhanVienRepository.save(nhanVien);
	}

	@Override
	public List<NhanVien> findAll() {
		// TODO Auto-generated method stub
		return nhanVienRepository.findAll();
	}

	@Override
	public NhanVien findById(int id) {
		// TODO Auto-generated method stub
		return nhanVienRepository.getOne(Integer.valueOf(id));
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		//nhanVienRepository.delete(id); 
	}
	
}
