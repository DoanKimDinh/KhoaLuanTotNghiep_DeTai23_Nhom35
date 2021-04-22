package com.iuh.detai23.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonAn {
	@Id
	@SequenceGenerator(name = "monAn_seq", allocationSize = 1)
	@GeneratedValue(generator = "monAn_seq")
	private int maMonAn;
	private String tenMonAn;
	private double DonGia;
	private String moTa;
	private String hinhAnh;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private LoaiMonAn loaiMonAn;

	public MonAn(String tenMonAn, double donGia, String moTa, String hinhAnh) {
		super();
		this.tenMonAn = tenMonAn;
		DonGia = donGia;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
	}

	public MonAn(String tenMonAn, double donGia, String moTa, String hinhAnh, LoaiMonAn loaiMonAn) {
		super();
		this.tenMonAn = tenMonAn;
		DonGia = donGia;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.loaiMonAn = loaiMonAn;
	}	
	
	
	
}
