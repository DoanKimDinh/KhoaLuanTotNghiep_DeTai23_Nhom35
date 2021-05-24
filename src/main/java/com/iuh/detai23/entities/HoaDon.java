package com.iuh.detai23.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iuh.detai23.type.TypeHoaDon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class HoaDon {
	

	@Id
	@SequenceGenerator(name = "maHoaDon_seq", allocationSize = 1)
	@GeneratedValue(generator = "maHoaDon_seq")
	private int maHoaDon;
	private LocalDateTime ngayDen;
	private LocalDateTime ngayLapHoaDon;
	@Enumerated(EnumType.STRING)
	private TypeHoaDon tinhTrang;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private KhachHang khachHang;
	
	@ManyToOne
	private NhanVien nhanVien;
	
	
	@OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ChiTietHoaDon> chiTietHoadon;
	
	private String ghiChu;

	public HoaDon(LocalDateTime ngayDen, LocalDateTime ngayLapHoaDon, TypeHoaDon tinhTrang, KhachHang khachHang,
			NhanVien nhanVien, String ghiChu) {
		super();
		this.ngayDen = ngayDen;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.tinhTrang = tinhTrang;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ghiChu = ghiChu;
	}

	public HoaDon(LocalDateTime ngayDen, LocalDateTime ngayLapHoaDon, TypeHoaDon tinhTrang, String ghiChu) {
		super();
		this.ngayDen = ngayDen;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.tinhTrang = tinhTrang;
		this.ghiChu = ghiChu;
	}
	
	
}
