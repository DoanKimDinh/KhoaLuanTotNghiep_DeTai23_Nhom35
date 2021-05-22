package com.iuh.detai23.repositoties;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iuh.detai23.entities.MonAn;

public interface MonAnRepository extends JpaRepository<MonAn, Integer>{
	@Query("SELECT m FROM MonAn m WHERE tinhTrang != 'NgungKinhDoanh'")
	List<MonAn> timMonAnDangKinhDoanh();
}
