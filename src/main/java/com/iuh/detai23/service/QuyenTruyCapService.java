package com.iuh.detai23.service;

import java.util.List;
import java.util.Optional;


import com.iuh.detai23.entities.QuyenTruyCap;

public interface QuyenTruyCapService {
	public QuyenTruyCap save(QuyenTruyCap banDatTruoc);
	public List<QuyenTruyCap> findAll();
	public Optional<QuyenTruyCap> findById(int id);
	public void delete(int id);
	public QuyenTruyCap findByMaQuyenTruyCap(int id);
}
