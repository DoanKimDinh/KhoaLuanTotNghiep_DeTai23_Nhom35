package com.iuh.detai23.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.detai23.entities.BanDatTruoc;
import com.iuh.detai23.model.BanDatTruocAddModel;
import com.iuh.detai23.repositoties.BanDatTruocRepository;
import com.iuh.detai23.service.BanDatTruocService;
import com.iuh.detai23.service.KhachHangService;
import com.iuh.detai23.type.TypeDatTruoc;

@Service
public class BanDatTruocServiceImpl implements BanDatTruocService{
	@Autowired 
	private BanDatTruocRepository banDatTruocRepo;
	
	@Autowired
	private KhachHangService khachHangService;

	@Override
	public BanDatTruoc save(BanDatTruoc banDatTruoc) {
		// TODO Auto-generated method stub
		return banDatTruocRepo.save(banDatTruoc);
	}

	@Override
	public List<BanDatTruoc> findAll() {
		// TODO Auto-generated method stub
		return banDatTruocRepo.findAll();
	}

	@Override
	public Optional<BanDatTruoc> findById(int id) {
		// TODO Auto-generated method stub
		return banDatTruocRepo.findById(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		banDatTruocRepo.deleteById(Integer.valueOf(id));
	}

	@Override
	public BanDatTruocAddModel save(BanDatTruocAddModel banDatTruocAddModel) {
		// TODO Auto-generated method stub
		BanDatTruoc datTruoc = new BanDatTruoc();
		datTruoc.setDatTruoc(TypeDatTruoc.ChuaXacNhan);
		datTruoc.setDiaChi(banDatTruocAddModel.getDiaChi());
		datTruoc.setGhiChu(banDatTruocAddModel.getGhiChu());
		datTruoc.setKhachHang(khachHangService.getKhachHangByEmail(banDatTruocAddModel.getEmail()));
		datTruoc.setNgayDen(banDatTruocAddModel.getNgayDen());
		datTruoc.setSoNguoi(banDatTruocAddModel.getSoNguoi());
		datTruoc.setThoiGianDen(banDatTruocAddModel.getThoiGianDen());
		
		banDatTruocRepo.save(datTruoc);
		
		return null;
	}	
}
