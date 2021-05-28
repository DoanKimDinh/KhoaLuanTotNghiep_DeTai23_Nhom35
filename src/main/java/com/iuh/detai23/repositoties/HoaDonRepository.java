package com.iuh.detai23.repositoties;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iuh.detai23.entities.HoaDon;

public interface HoaDonRepository extends JpaRepository<HoaDon, Integer>{
	@Query(value = "select sum(chi_tiet_hoa_don.don_gia*chi_tiet_hoa_don.so_luong) from hoa_don inner join chi_tiet_hoa_don on hoa_don.ma_hoa_don = chi_tiet_hoa_don.ma_hoa_don_key\r\n" + 
			"", nativeQuery = true)
	double getTotalMoneyStore();
	
	@Query(value = "select sum(chi_tiet_hoa_don.don_gia*chi_tiet_hoa_don.so_luong) from hoa_don inner join chi_tiet_hoa_don on hoa_don.ma_hoa_don = chi_tiet_hoa_don.ma_hoa_don_key\r\n" + 
			"where ngay_lap_hoa_don LIKE :monthSelect", nativeQuery = true)
	Object getTotalMoneyStoreWithMonth(@Param("monthSelect") String monthSelect);
	
	@Query(value = "select * from hoa_don\r\n" + 
			"where ngay_lap_hoa_don LIKE :monthSelect", nativeQuery = true)
	List<HoaDon> getListHoaDonByMonth(@Param("monthSelect") String monthSelect);
}
