package com.iuh.detai23.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.iuh.detai23.type.TypeDatTruoc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data

@NoArgsConstructor
@AllArgsConstructor
public class BanDatTruoc {
	@Id
	@SequenceGenerator(name = "maDatTruoc_seq", allocationSize = 1)
	@GeneratedValue(generator = "maDatTruoc_seq")
	private int maDatTruoc;
	private String ngayDen; 
	private String thoiGianDen; 
	private int soNguoi; 
	private String ghiChu;
	private TypeDatTruoc datTruoc;
	
	private String diaChi;
	
	@ManyToOne
	private KhachHang khachHang;
	
	@OneToMany(mappedBy = "banDatTruoc",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ChiTietMonDatTruoc> chiTietMonDatTruoc;

	public BanDatTruoc(String ngayDen, String thoiGianDen, int soNguoi, String ghiChu, String diaChi,
			TypeDatTruoc datTruoc) {
		super();
		this.ngayDen = ngayDen;
		this.soNguoi = soNguoi;
		this.ghiChu = ghiChu;
		this.datTruoc = datTruoc;
		this.thoiGianDen = thoiGianDen;
		this.diaChi = diaChi;
	}
	
	public BanDatTruoc(String ngayDen, int soNguoi, String ghiChu, TypeDatTruoc datTruoc) {
		super();
		this.ngayDen = ngayDen;
		this.soNguoi = soNguoi;
		this.ghiChu = ghiChu;
		this.datTruoc = datTruoc;
	}

	
	
} 
