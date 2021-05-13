package com.iuh.detai23.service;

import java.util.List;
import java.util.Optional;

import com.iuh.detai23.entities.BanDatTruoc;
import com.iuh.detai23.model.BanDatTruocAddModel;

public interface BanDatTruocService {
	public BanDatTruoc save(BanDatTruoc banDatTruoc);
	public List<BanDatTruoc> findAll();
	public Optional<BanDatTruoc> findById(int id);
	public void delete(int id);
	public BanDatTruocAddModel save(BanDatTruocAddModel banDatTruocAddModel);
}
