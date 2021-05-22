package com.iuh.detai23.service;

import java.util.List;
import java.util.Optional;

import com.iuh.detai23.entities.MonAn;

public interface MonAnService {
	public MonAn save(MonAn monAn);
	public List<MonAn> findAll();
	public MonAn findById(int id);
	public Optional<MonAn> findBy(int id);
	public void delete(int id);
	public List<MonAn> finDall(); 
	
}
