package com.iuh.detai23.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.detai23.entities.HoaDon;
import com.iuh.detai23.repositoties.HoaDonRepository;
import com.iuh.detai23.service.HoaDonService;

@Service
public class HoaDonServiceImpl  implements HoaDonService{

	@Autowired
	private HoaDonRepository hoaDonRepository;
	@Override
	public HoaDon save(HoaDon hoaDon) {
		// TODO Auto-generated method stub
		return hoaDonRepository.save(hoaDon);
	}

	@Override
	public List<HoaDon> findAll() {
		// TODO Auto-generated method stub
		return hoaDonRepository.findAll();
	}

	@Override
	public Optional<HoaDon> findById(int id) {
		// TODO Auto-generated method stub
		return hoaDonRepository.findById(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
