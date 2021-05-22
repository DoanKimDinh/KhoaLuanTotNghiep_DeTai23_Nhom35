package com.iuh.detai23.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.detai23.entities.MonAn;
import com.iuh.detai23.repositoties.MonAnRepository;
import com.iuh.detai23.service.MonAnService;

@Service
public class MonAnServiceImpl implements MonAnService{

	@Autowired
	private MonAnRepository monAnRepository;
	@Override
	public MonAn save(MonAn monAn) {
		// TODO Auto-generated method stub
		return monAnRepository.save(monAn);
	}

	@Override
	public List<MonAn> findAll() {
		// TODO Auto-generated method stub
		return monAnRepository.findAll();
	}

	@Override
	public MonAn findById(int id) {
		// TODO Auto-generated method stub
		return monAnRepository.getOne(Integer.valueOf(id));
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		monAnRepository.deleteById(Integer.valueOf(id));
	}

	@Override
	public Optional<MonAn> findBy(int id) {
		// TODO Auto-generated method stub
		return monAnRepository.findById(id);
	}

	@Override
	public List<MonAn> finDall() {
		return monAnRepository.timMonAnDangKinhDoanh();
	}
	
}
