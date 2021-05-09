package com.iuh.detai23.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.detai23.entities.QuyenTruyCap;
import com.iuh.detai23.repositoties.QuyenTruyCapRepository;
import com.iuh.detai23.service.QuyenTruyCapService;

@Service
public class QuyenTruyCapServiceImpl implements QuyenTruyCapService{

	
	@Autowired
	private QuyenTruyCapRepository quyenTruyCapRepository;
	@Override
	public QuyenTruyCap save(QuyenTruyCap banDatTruoc) {
		// TODO Auto-generated method stub
		return quyenTruyCapRepository.save(banDatTruoc);
	}

	@Override
	public List<QuyenTruyCap> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<QuyenTruyCap> findById(int id) {
		// TODO Auto-generated method stub
		return quyenTruyCapRepository.findById(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QuyenTruyCap findByMaQuyenTruyCap(int id) {
		// TODO Auto-generated method stub
		return quyenTruyCapRepository.getOne(id);
	}
	
}
