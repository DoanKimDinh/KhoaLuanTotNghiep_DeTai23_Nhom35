package com.iuh.detai23.service;

import java.util.List;
import java.util.Optional;


import com.iuh.detai23.entities.HoaDon;

public interface HoaDonService {
	public HoaDon save(HoaDon hoaDon);
	public List<HoaDon> findAll();
	public Optional<HoaDon> findById(int id);
	public void delete(int id);
	public double getTotalMoney();
	public double getTotalMoneyWithMonth(int year, int month);
	public List<HoaDon> getListHoaDonByMonth( int year, int month);
}
