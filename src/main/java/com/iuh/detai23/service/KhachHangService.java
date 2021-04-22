package com.iuh.detai23.service;

import java.util.List;
import java.util.Optional;

import com.iuh.detai23.entities.KhachHang;

public interface KhachHangService {
	public KhachHang save(KhachHang khachHang);
	public List<KhachHang> findAll();
	public Optional<KhachHang> findById(int id);
	public void delete(int id);
}
