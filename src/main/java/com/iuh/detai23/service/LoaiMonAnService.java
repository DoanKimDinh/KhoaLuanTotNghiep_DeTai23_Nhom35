package com.iuh.detai23.service;

import java.util.List;
import java.util.Optional;

import com.iuh.detai23.entities.LoaiMonAn;

public interface LoaiMonAnService {
	public LoaiMonAn save(LoaiMonAn banDatTruoc);
	public List<LoaiMonAn> findAll();
	public Optional<LoaiMonAn> findById(int id);
	public void delete(int id);
	public LoaiMonAn findByMaLoaiMonAn(int id);
}
