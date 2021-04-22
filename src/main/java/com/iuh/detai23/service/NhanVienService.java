package com.iuh.detai23.service;

import java.util.List;
import java.util.Optional;


import com.iuh.detai23.entities.NhanVien;

public interface NhanVienService {
	public NhanVien save(NhanVien nhanVien);
	public List<NhanVien> findAll();
	public Optional<NhanVien> findById(int id);
	public void delete(int id);
}
