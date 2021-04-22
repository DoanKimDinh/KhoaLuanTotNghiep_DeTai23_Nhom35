package com.iuh.detai23.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.detai23.entities.LoaiMonAn;
import com.iuh.detai23.repositoties.LoaiMonAnRepository;
import com.iuh.detai23.service.LoaiMonAnService;

@Service
public class LoaiMonAnServiceImpl implements LoaiMonAnService{

	@Autowired
	private LoaiMonAnRepository loaiMonAnRepository;
	
	@Override
	public LoaiMonAn save(LoaiMonAn banDatTruoc) {
		// TODO Auto-generated method stub
		return loaiMonAnRepository.save(banDatTruoc);
	}

	@Override
	public List<LoaiMonAn> findAll() {
		// TODO Auto-generated method stub
		return loaiMonAnRepository.findAll();
	}

	@Override
	public Optional<LoaiMonAn> findById(int id) {
		// TODO Auto-generated method stub
		return loaiMonAnRepository.findById(Integer.valueOf(id));
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		loaiMonAnRepository.deleteById(Integer.valueOf(id));
	}

	@Override
	public LoaiMonAn findByMaLoaiMonAn(int id) {
		// TODO Auto-generated method stub
		return loaiMonAnRepository.getOne(id);
	}

}
