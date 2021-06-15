package com.iuh.detai23.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.detai23.entities.HoaDon;
import com.iuh.detai23.repositoties.HoaDonRepository;
import com.iuh.detai23.service.HoaDonService;

@Service
public class HoaDonServiceImpl implements HoaDonService {

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

	@Override
	public double getTotalMoney() {
		// TODO Auto-generated method stub
		return hoaDonRepository.getTotalMoneyStore();
	}

	@Override
	public double getTotalMoneyWithMonth(int year, int month) {
		// TODO Auto-generated method stub
		String string;
		if (month > 9)
			string = year + "-" + month + "%";
		else
			string = year + "-0" + month + "%";
		
		Object object = hoaDonRepository.getTotalMoneyStoreWithMonth(string);
		if (object != null)
			return (double) object;
		else
			return 0;
	}

	@Override
	public List<HoaDon> getListHoaDonByMonth(int year, int month) {
		// TODO Auto-generated method stub
		String string;
		if (month > 9)
			string = year + "-" + month + "%";
		else
			string = year + "-0" + month + "%";
		
		List<HoaDon> object = hoaDonRepository.getListHoaDonByMonth(string);
		if (object != null)
			return object;
		else
			return null;
	}

	@Override
	public int getTotalAmountPersonInBill(int year, int month) {
		// TODO Auto-generated method stub
		String string;
		if (month > 9)
			string = year + "-" + month + "%";
		else
			string = year + "-0" + month + "%";
		
		List<HoaDon> object = hoaDonRepository.getListHoaDonByMonth(string);
		
		Set<Integer> soluong = new HashSet<Integer>();
		for (HoaDon hoaDon : object) {
			if(hoaDon.getKhachHang()!=null) {
				soluong.add(hoaDon.getKhachHang().getMaKhachHang());
			}
		}
		return soluong.size();
	}



}
